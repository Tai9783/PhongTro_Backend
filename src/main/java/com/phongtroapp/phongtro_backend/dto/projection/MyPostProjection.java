package com.phongtroapp.phongtro_backend.dto.projection;

import java.time.LocalDateTime;

public interface MyPostProjection {
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
