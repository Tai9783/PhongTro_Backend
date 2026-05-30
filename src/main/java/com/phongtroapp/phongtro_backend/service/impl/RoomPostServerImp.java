package com.phongtroapp.phongtro_backend.service.impl;

import com.phongtroapp.phongtro_backend.model.RoomPost;
import com.phongtroapp.phongtro_backend.repository.impl.RoomPostRepository;
import com.phongtroapp.phongtro_backend.service.RoomPostServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoomPostServerImp implements RoomPostServer {

    @Autowired
    private RoomPostRepository roomPostRepository;
    @Override
    public RoomPost saveRoomPost(String roomId) {
        String postId= UUID.randomUUID().toString();
        RoomPost newPost= new RoomPost(postId,roomId.trim().replace("\"", ""));
        return roomPostRepository.save(newPost);
    }
}
