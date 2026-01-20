package com.phongtroapp.phongtro_backend.model;

import java.util.List;

public class FilterRoomRequest {
    private String nameCity;
    private List<String> nameWard;
    private List<PriceRange> listPrice;
    private List<String> listAmenity;

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public List<String> getNameWard() {
        return nameWard;
    }

    public void setNameWard(List<String> nameWard) {
        this.nameWard = nameWard;
    }

    public List<PriceRange> getListPrice() {
        return listPrice;
    }

    public void setListPrice(List<PriceRange> listPrice) {
        this.listPrice = listPrice;
    }

    public List<String> getListAmenity() {
        return listAmenity;
    }

    public void setListAmenity(List<String> listAmenity) {
        this.listAmenity = listAmenity;
    }

    public FilterRoomRequest(String nameCity, List<String> nameWard, List<PriceRange> listPrice, List<String> listAmenity) {
        this.nameCity = nameCity;
        this.nameWard = nameWard;
        this.listPrice = listPrice;
        this.listAmenity = listAmenity;
    }
}
