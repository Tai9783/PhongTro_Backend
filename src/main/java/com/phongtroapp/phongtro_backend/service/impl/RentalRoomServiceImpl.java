package com.phongtroapp.phongtro_backend.service.impl;

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
        System.out.println("[v0] Rooms from DB: " + rooms.get(0).getRoomId());
        System.out.println("[v0] LandlordId: " + rooms.get(0).getLandlordId());
        System.out.println("[v0] CreatedAt: " + rooms.get(0).getCreatedAt());
        //  lọc theo trạng thái
        return rooms;
    }

    public List<RentalRoom> getAvailableRooms() {

        return roomRepository.findByStatus(1);
    }
}
