package com.phongtroapp.phongtro_backend.service;

import com.phongtroapp.phongtro_backend.model.CityRoomCount;
import com.phongtroapp.phongtro_backend.model.FilterRoomRequest;
import com.phongtroapp.phongtro_backend.model.PriceRange;
import com.phongtroapp.phongtro_backend.model.RentalRoom;

import java.util.List;

public interface RentalRoomService {
    List<RentalRoom> getAllRooms();
    List<RentalRoom> getAvailableRooms();

    List<RentalRoom> locRoomHome(Double minPrice, Double maxPrice, String city);
    List<CityRoomCount> getCity();
    List<String> getWard(String city);
    List<RentalRoom> getListRoomByFilter(FilterRoomRequest requestRoom);
}
