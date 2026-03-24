package com.phongtroapp.phongtro_backend.repository;

import com.phongtroapp.phongtro_backend.dto.PriceRange;
import com.phongtroapp.phongtro_backend.model.RentalRoom;

import java.util.List;

public interface RentalRoomRepositoryCustom {
    List<RentalRoom> filterRoomBySearch(
            String city,
            List<String> wards,
            List<PriceRange> priceRanges,
            List<String> amenities
    );
}
