package com.phongtroapp.phongtro_backend.model;

public class CityRoomCount {
    private String city;
    private Long roomCount;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Long roomCount) {
        this.roomCount = roomCount;
    }

    public CityRoomCount(String city, Long roomCount) {
        this.city = city;
        this.roomCount = roomCount;
    }
}
