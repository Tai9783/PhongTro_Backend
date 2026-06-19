package com.phongtroapp.phongtro_backend.controller;

import com.phongtroapp.phongtro_backend.dto.MyPost;
import com.phongtroapp.phongtro_backend.service.impl.MyPostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mypost/")
@CrossOrigin(origins = "*")
public class MyPostController {
    private final MyPostServiceImpl myPostService;

    public MyPostController(MyPostServiceImpl myPostService) {
        this.myPostService = myPostService;
    }

    @GetMapping("/getListPost")
    public List<MyPost> getListPhong(
            @RequestParam("landlordId") String landlordId
    ){
        return myPostService.getListPost(landlordId);
    }
}
