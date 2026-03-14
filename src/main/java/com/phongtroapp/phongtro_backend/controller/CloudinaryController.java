package com.phongtroapp.phongtro_backend.controller;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/cloudinary")
public class CloudinaryController {
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/signature")
    public Map<String,String> getSignature(){
        long timestamp= System.currentTimeMillis()/1000;

        Map<String, Object> params = new HashMap<>();
        params.put("timestamp", timestamp);

        String signature = cloudinary.apiSignRequest(params, cloudinary.config.apiSecret);

        Map<String, String> response = new HashMap<>();
        response.put("timestamp", String.valueOf(timestamp));
        response.put("signature", signature);
        response.put("api_key", cloudinary.config.apiKey);
        response.put("cloud_name", cloudinary.config.cloudName);

        return response;
    }
}
