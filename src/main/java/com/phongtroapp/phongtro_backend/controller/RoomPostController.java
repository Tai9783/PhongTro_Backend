package com.phongtroapp.phongtro_backend.controller;


import com.phongtroapp.phongtro_backend.model.RoomPost;
import com.phongtroapp.phongtro_backend.service.RoomPostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roompost/")
@CrossOrigin(origins = "*")
public class RoomPostController {
    private final RoomPostService roomPostService;

    public RoomPostController(RoomPostService roomPostService) {
        this.roomPostService = roomPostService;
    }

    @PostMapping("/saveroompost")
    public RoomPost saveRoomPost(@RequestBody String roomId){
        return roomPostService.saveRoomPost(roomId);
    }
}
