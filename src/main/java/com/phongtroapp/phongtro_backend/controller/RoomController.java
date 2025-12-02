package com.phongtroapp.phongtro_backend.controller;

import com.phongtroapp.phongtro_backend.model.CityRoomCount;
import com.phongtroapp.phongtro_backend.model.RentalRoom;
import com.phongtroapp.phongtro_backend.service.impl.RentalRoomServiceImpl;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/roomByPriceAndCity")
    public List<RentalRoom> locRoomHome(
            @RequestParam("minPrice") double minPrice,
            @RequestParam("maxPrice") double maxPrice,
            @RequestParam("city") String city
    ){
        return roomService.locRoomHome(minPrice,maxPrice,city);
    }

    @GetMapping("/listCity")
    public List<CityRoomCount> getListCity(){
         return roomService.getCity();
    }

    @GetMapping("/listWard")
    public List<String> getWard(@RequestParam("city") String city){
        return roomService.getWard(city);
    }


}
