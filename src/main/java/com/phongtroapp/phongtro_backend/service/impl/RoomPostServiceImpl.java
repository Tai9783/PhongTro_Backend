package com.phongtroapp.phongtro_backend.service.impl;

import com.phongtroapp.phongtro_backend.model.RoomPost;
import com.phongtroapp.phongtro_backend.repository.RoomPostRepository;
import com.phongtroapp.phongtro_backend.service.RoomPostService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoomPostServiceImpl implements RoomPostService {

    private final RoomPostRepository roomPostRepository;

    public RoomPostServiceImpl(RoomPostRepository roomPostRepository) {
        this.roomPostRepository = roomPostRepository;
    }

    @Override
    public RoomPost saveRoomPost(String roomId) {
        String postId= UUID.randomUUID().toString();
        RoomPost newPost= new RoomPost(postId,roomId.trim().replace("\"", ""));
        return roomPostRepository.save(newPost);
    }
}
