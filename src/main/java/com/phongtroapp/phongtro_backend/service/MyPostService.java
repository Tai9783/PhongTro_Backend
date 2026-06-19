package com.phongtroapp.phongtro_backend.service;

import com.phongtroapp.phongtro_backend.dto.MyPost;

import java.util.List;


public interface MyPostService {
    List<MyPost> getListPost(String landlord);
}
