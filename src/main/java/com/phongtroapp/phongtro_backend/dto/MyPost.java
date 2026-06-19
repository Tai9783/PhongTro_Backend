package com.phongtroapp.phongtro_backend.dto;

import java.time.LocalDateTime;

public interface MyPost {
    String getPostId();
    String getRoomId();
    boolean getStatus();
    LocalDateTime getCreateAt();
    LocalDateTime getExpireAt();
    String getTitle();
    double getPrice();
    double getArea();
    String getImageJson();
}
