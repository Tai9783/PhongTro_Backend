package com.phongtroapp.phongtro_backend.service.impl;

import com.phongtroapp.phongtro_backend.model.CityRoomCount;
import com.phongtroapp.phongtro_backend.model.RentalRoom;
import com.phongtroapp.phongtro_backend.repository.RentalRoomRepository;
import com.phongtroapp.phongtro_backend.service.RentalRoomService;
import org.springframework.stereotype.Service;

import java.util.List;
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


}
