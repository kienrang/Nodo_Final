package com.example.nodoapi.specifications;

import com.example.nodoapi.base.BaseSpecifications;

public class LoaiDanhMucSpecification extends BaseSpecifications {
    private static LoaiDanhMucSpecification INSTANCE;

    public static LoaiDanhMucSpecification getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoaiDanhMucSpecification();
        }

        return INSTANCE;
    }
}
