package com.phongtroapp.phongtro_backend.service.impl;

import com.phongtroapp.phongtro_backend.dto.projection.MyPostProjection;
import com.phongtroapp.phongtro_backend.dto.MyPostResponse;
import com.phongtroapp.phongtro_backend.repository.MyPostRepository;
import com.phongtroapp.phongtro_backend.service.MyPostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MyPostServiceImpl implements MyPostService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final MyPostRepository myPostRepository;

    public MyPostServiceImpl(MyPostRepository myPostRepository) {
        this.myPostRepository = myPostRepository;
    }


    @Override
    public List<MyPostResponse> getListPost(String landlord) {
        LocalDateTime now = LocalDateTime.now();
        return myPostRepository.getListPost(landlord).stream()
                .map(post -> new MyPostResponse(
                        post.getPostId(),
                        post.getRoomId(),
                        post.getExpireAt() != null && post.getExpireAt().isAfter(now),
                        post.getCreateAt() != null ? post.getCreateAt().format(DATE_FORMATTER) : "",
                        post.getExpireAt() != null ? post.getExpireAt().format(DATE_FORMATTER) : "",
                        post.getTitle(),
                        post.getPrice(),
                        post.getArea(),
                        post.getImageJson()
                ))
                .toList();
    }
}
