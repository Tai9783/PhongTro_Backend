package com.phongtroapp.phongtro_backend.model;

public class PriceRange {
    private Long min, max;

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public PriceRange(Long min, Long max) {
        this.min = min;
        this.max = max;
    }
}
