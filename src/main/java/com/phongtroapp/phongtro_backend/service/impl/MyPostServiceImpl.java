package com.phongtroapp.phongtro_backend.service.impl;

import com.phongtroapp.phongtro_backend.dto.MyPost;
import com.phongtroapp.phongtro_backend.repository.impl.MyPostRepository;
import com.phongtroapp.phongtro_backend.service.MyPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPostServiceImpl implements MyPostService {
    private final MyPostRepository myPostRepository;

    public MyPostServiceImpl(MyPostRepository myPostRepository) {
        this.myPostRepository = myPostRepository;
    }


    @Override
    public List<MyPost> getListPost(String landlord) {
        return myPostRepository.getListPost(landlord);
    }
}
