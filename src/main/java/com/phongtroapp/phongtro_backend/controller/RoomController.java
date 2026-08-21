package com.phongtroapp.phongtro_backend.controller;

import com.phongtroapp.phongtro_backend.dto.CityRoomCount;
import com.phongtroapp.phongtro_backend.dto.FilterRoomRequest;
import com.phongtroapp.phongtro_backend.dto.RentalRoomRequest;
import com.phongtroapp.phongtro_backend.model.RentalRoom;
import com.phongtroapp.phongtro_backend.service.RentalRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {
    private final RentalRoomService roomService;

    public RoomController(RentalRoomService roomService) {
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
    @PostMapping("/filterRoom")
    public List<RentalRoom> getListRoom(@RequestBody FilterRoomRequest request){
        return roomService.getListRoomByFilter(request);
    }

    @PostMapping("/createRentalRoom")
    public ResponseEntity<?> createRoom(@RequestBody RentalRoomRequest rentalRoomRequest){
        RentalRoom savedRoom= roomService.saveRoom(rentalRoomRequest);
        if(savedRoom!=null)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create rental room");
    }
}
