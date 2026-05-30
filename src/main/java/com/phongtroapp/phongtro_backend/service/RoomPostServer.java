package com.phongtroapp.phongtro_backend.service;

import com.phongtroapp.phongtro_backend.model.RoomPost;

public interface RoomPostServer {
    RoomPost saveRoomPost(String roomId);
}
