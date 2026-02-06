package com.phongtroapp.phongtro_backend.repository.impl;

import com.phongtroapp.phongtro_backend.model.Amenity;
import com.phongtroapp.phongtro_backend.model.PriceRange;
import com.phongtroapp.phongtro_backend.model.RentalRoom;
import com.phongtroapp.phongtro_backend.repository.RentalRoomRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RentalRoomRepositoryImpl implements RentalRoomRepositoryCustom {

    @PersistenceContext
    private EntityManager em; //quản lý kho dữ liệu

    public RentalRoomRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<RentalRoom> filterRoomBySearch(
            String city,
            List<String> wards,
            List<PriceRange> priceRanges,
            List<String> amenities) {

        CriteriaBuilder cb= em.getCriteriaBuilder(); // Tạo hộp công cụ và nó sẽ cung cấp các phép toán(equal,like,and or...)
        CriteriaQuery<RentalRoom> cq= cb.createQuery(RentalRoom.class);// tạo query và xác định xem query cái gì
        Root<RentalRoom> room= cq.from(RentalRoom.class);// nguồn dữ liệu, lấy dữ liệu trong cột nào của bảng đó, tương đương FROM RentalRoom

        cq.select(room).distinct(true); // tránh dữ liệu trùng lặp
        List<Predicate> listCondition= new ArrayList<>();
        // Predicate = 1 điều kiện WHERE
        // listCondition = danh sách điều kiện sẽ ghép lại bằng AND

        if (city!=null&&!city.isBlank())
            listCondition.add(cb.like(room.get("city"),"%"+city+"%"));
        if(wards!=null && !wards.isEmpty())
            listCondition.add(room.get("ward").in(wards));  // in tương đương: ward = A OR ward = B OR ward = C
        if(priceRanges!= null && !priceRanges.isEmpty()){
            List<Predicate> listPrice= new ArrayList<>();

            Path<BigDecimal> pricePath= room.get("price");
            for(PriceRange pr : priceRanges){
                if(pr== null) continue;
                Long min= pr.getMin();
                Long max= pr.getMax();
                BigDecimal minBD = (min == null) ? null : BigDecimal.valueOf(min);
                BigDecimal maxBD = (max == null) ? null : BigDecimal.valueOf(max);
                if (minBD==null&& maxBD==null) continue;

                if(minBD!=null && maxBD!=null)
                    listPrice.add(cb.between(pricePath, minBD, maxBD)); // tương đương where price between min and max
                else if(minBD==null)
                    listPrice.add(cb.le(pricePath,maxBD)); // le tương đương less or equal(<=) (where price <=max)
                else //if (max== null)
                    listPrice.add(cb.ge(pricePath,minBD)); //  le tương đương greater or equal (>=) (where price >=max)
            }
            if(!listPrice.isEmpty())
                listCondition.add(cb.or(listPrice.toArray(new Predicate[0])));// City AND Ward AND ((range1 OR range2 OR range3)) AND Amenities
                //listCondition (andPreds) chỉ nhận 1 Predicate mỗi lần add(...).
            //
            //listPrice là List<Predicate> (nhiều điều kiện giá nhỏ).
            //
            //Mình cần gộp listPrice thành 1 Predicate dạng (p1 OR p2 OR p3...) bằng cb.or(...).
            //
            //Nhưng cb.or(...) nhận Predicate, không nhận List, nên phải đổi List → mảng
            //toArray(new Predicate[0]) = “chuyển List<Predicate> thành Predicate[] để truyền vào cb.or(...)”.
        }

        if (amenities != null && !amenities.isEmpty()) {

            Subquery<String> sub = cq.subquery(String.class);
            Root<RentalRoom> r2= sub.from(RentalRoom.class);
            Join<RentalRoom,Amenity> a2= r2.join("listAmenities", JoinType.INNER);

            sub.select(r2.get("roomId"))
                    .where(a2.get("amenityName").in(amenities))  //  WHERE amenity_name IN ('Wifi', 'Có máy lạnh')
                    .groupBy(r2.get("roomId"))
                    // HAVING countDistinct(amenityName) = số tiện ích user chọn
                    .having(cb.equal(cb.countDistinct(a2.get("amenityName")), amenities.size()));

            //Query chính: roomId phải nằm trong danh sách roomId của subquery
            listCondition.add(room.get("roomId").in(sub));
        }
        listCondition.add(cb.equal(room.get("status"), 1));
        cq.where(cb.and(listCondition.toArray(new Predicate[0])));



        return em.createQuery(cq).getResultList();
    }
}
