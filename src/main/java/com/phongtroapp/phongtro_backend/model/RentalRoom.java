package com.phongtroapp.phongtro_backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "rentalroom")
public class RentalRoom {
    @Id
    @Column(name = "roomId")
    private String roomId;

    @Column(name = "landlordId")
    private String landlordId;

    private String title;
    private String description;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;
    @Column(name = "area", precision = 10, scale = 2)
    private BigDecimal area;

    @Column(name = "images_json", columnDefinition = "json")
    private String imagesJson;


    private int status;
    @Column(name = "createdAt", columnDefinition = "DateTime")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "ward")
    private String ward;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getImagesJson() {
        return imagesJson;
    }

    public void setImagesJson(String imagesJson) {
        this.imagesJson = imagesJson;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public RentalRoom(String roomId, String landlordId, String title, String description, BigDecimal price, BigDecimal area, String imagesJson, int status, LocalDateTime createdAt, String address, String city, String ward) {
        this.roomId = roomId;
        this.landlordId = landlordId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.area = area;
        this.imagesJson = imagesJson;
        this.status = status;
        this.createdAt = createdAt;
        this.address = address;
        this.city = city;
        this.ward = ward;
    }
    public RentalRoom() {}
}
