package com.phongtroapp.phongtro_backend.controller;

import com.phongtroapp.phongtro_backend.dto.MyPostResponse;
import com.phongtroapp.phongtro_backend.service.MyPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mypost/")
@CrossOrigin(origins = "*")
public class MyPostController {
    private final MyPostService myPostService;

    public MyPostController(MyPostService myPostService) {
        this.myPostService = myPostService;
    }

    @GetMapping("/getListPost")
    public List<MyPostResponse> getListPhong(
            @RequestParam("landlordId") String landlordId
    ){
        return myPostService.getListPost(landlordId);
    }
}
