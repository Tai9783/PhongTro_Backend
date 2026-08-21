package com.phongtroapp.phongtro_backend.service;

import com.phongtroapp.phongtro_backend.dto.MyPostResponse;

import java.util.List;


public interface MyPostService {
    List<MyPostResponse> getListPost(String landlord);
}
