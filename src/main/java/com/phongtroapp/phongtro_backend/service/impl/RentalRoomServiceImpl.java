package com.phongtroapp.phongtro_backend.service.impl;

import com.phongtroapp.phongtro_backend.model.CityRoomCount;
import com.phongtroapp.phongtro_backend.model.FilterRoomRequest;
import com.phongtroapp.phongtro_backend.model.PriceRange;
import com.phongtroapp.phongtro_backend.model.RentalRoom;
import com.phongtroapp.phongtro_backend.repository.RentalRoomRepository;
import com.phongtroapp.phongtro_backend.service.RentalRoomService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RentalRoomServiceImpl implements RentalRoomService {
    private final RentalRoomRepository roomRepository;

    public RentalRoomServiceImpl(RentalRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<RentalRoom> getAllRooms() {
        List<RentalRoom> rooms = roomRepository.findAll();
        //  lọc theo trạng thái
        return rooms;
    }

    public List<RentalRoom> getAvailableRooms() {

        return roomRepository.findByStatus(1);
    }

    @Override
    public List<RentalRoom> locRoomHome(Double minPrice, Double maxPrice, String city) {
        if (city != null) {
            city = city.trim();

            if (city.equals("Tp HCM")) {
                city = "Tp Hồ Chí Minh";
            }
            if (city.equals("Tất cả") || city.isEmpty()) {
                city = null;
            }
        }
        if (city==null){
            return roomRepository.findByPriceBetween(minPrice, maxPrice);
        }
        System.out.println("CITY BACKEND NHẬN = [" + city + "]");
        List<RentalRoom> rooms= roomRepository.filterRoomsPriceCity(minPrice,maxPrice,city);
        return rooms;
    }

    @Override
    public List<CityRoomCount> getCity(){
        List<CityRoomCount> listCity= roomRepository.findCity();
        return listCity;
    }
    @Override
    public List<String> getWard(String city){
        List<String> listWard= roomRepository.findWard(city);
        System.out.println("CITY BACKEND NHẬN = [" + city + "]");
        return listWard;
    }

    @Override
    public List<RentalRoom> getListRoomByFilter(FilterRoomRequest requestRoom)  {
        String nameCity= requestRoom.getNameCity();
        if(nameCity!=null)
            nameCity= nameCity.trim();

        List<PriceRange> listPrices= requestRoom.getListPrice();
        if (listPrices == null || listPrices.isEmpty() )
            listPrices= Collections.emptyList();
        else{
            listPrices= listPrices.stream()
                    .filter(java.util.Objects::nonNull)
                    .filter(pr-> pr.getMin() !=null || pr.getMax() !=null)
                    .collect(java.util.stream.Collectors.toList());
            // xử lý trường hợp đúng và list này chứa min max về kiểu Long nên không thể có khoảng trắng trong giá được
        }
        List<String> listAmenity= requestRoom.getListAmenity();
        if(listAmenity== null || listAmenity.isEmpty())
            listAmenity= Collections.emptyList();
        else{
            //Nếu list không null thì xử lý trim() cho các phần tử
            listAmenity= listAmenity.stream()
                    .map(String::trim)
                    .filter(s-> !s.isBlank())// loaị bỏ các phần tử rỗng trong list
                    .collect(Collectors.toList());
        }
        List<String> listWard= requestRoom.getNameWard();
        if (listWard== null || listWard.isEmpty())
            listWard= Collections.emptyList();
        else{
            listWard= listWard.stream()
                    .map(String::trim)
                    .filter(s-> !s.isBlank())// loaị bỏ các phần tử rỗng trong list
                    .collect(Collectors.toList());
        }

        return roomRepository.filterRoomBySearch(nameCity,listWard,listPrices,listAmenity);
    }


}
