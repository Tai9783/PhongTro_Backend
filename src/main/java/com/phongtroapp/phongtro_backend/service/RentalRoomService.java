package com.phongtroapp.phongtro_backend.service;

import com.phongtroapp.phongtro_backend.model.RentalRoom;

import java.util.List;

public interface RentalRoomService {
    List<RentalRoom> getAllRooms();
    List<RentalRoom> getAvailableRooms();

    List<RentalRoom> locRoomHome(Double minPrice, Double maxPrice, String city);
}
