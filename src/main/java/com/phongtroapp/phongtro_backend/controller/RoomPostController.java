package com.phongtroapp.phongtro_backend.controller;


import com.phongtroapp.phongtro_backend.model.RoomPost;
import com.phongtroapp.phongtro_backend.service.impl.RoomPostServerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roompost/")
@CrossOrigin(origins = "*")
public class RoomPostController {
    @Autowired
    private RoomPostServerImp roomPostServerImp;

    @PostMapping("/saveroompost")
    public RoomPost saveRoomPost(@RequestBody String roomId){
        return roomPostServerImp.saveRoomPost(roomId);
    }
}
