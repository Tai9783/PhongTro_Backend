package com.phongtroapp.phongtro_backend.controller;


import com.phongtroapp.phongtro_backend.model.User;
import com.phongtroapp.phongtro_backend.service.impl.UserServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/getuser")
    public User getUser(
            @RequestParam("taikhoan") String taikhoan,
            @RequestParam("pass") String pass){
        return userService.getUser(taikhoan,pass);
    }

    @GetMapping("/getuserbyid")
    public User getUserById(@RequestParam("userId") String userId){
        return userService.getUserById(userId);
    }
}
