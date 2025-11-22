package com.phongtroapp.phongtro_backend.controller;

import com.phongtroapp.phongtro_backend.model.RentalRoom;
import com.phongtroapp.phongtro_backend.service.impl.RentalRoomServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {
    private final RentalRoomServiceImpl roomService;

    public RoomController(RentalRoomServiceImpl roomService) {
        this.roomService = roomService;
    }
    // API Endpoint: GET http://localhost:8080/api/rooms/featured
    @GetMapping("/featured")
    public List<RentalRoom> getFeaturedRooms() {
        return roomService.getAllRooms(); // Trả về danh sách phòng
    }
}
