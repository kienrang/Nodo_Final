package com.example.nodoapi.mapper;

import com.example.nodoapi.dto.LoaiDanhMucDto;
import com.example.nodoapi.entities.LoaiDanhMuc;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LoaiDanhMucMapper {
    private static LoaiDanhMucMapper INSTANCE;

    public static LoaiDanhMucMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoaiDanhMucMapper();
        }

        return INSTANCE;
    }

    public LoaiDanhMucMapper() {
    }

    public static LoaiDanhMucDto toDTO(LoaiDanhMuc entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, LoaiDanhMucDto.class);
    }

    public static LoaiDanhMuc toEntity(LoaiDanhMucMapper ldmDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ldmDto, LoaiDanhMuc.class);
    }

    public static Page<LoaiDanhMucDto> toPageDTO(Page<LoaiDanhMuc> page) {
        return page.map(new Function<>() {
            @Override
            public LoaiDanhMucDto apply(LoaiDanhMuc entity) {
                return LoaiDanhMucMapper.toDTO(entity);
            }
        });
    }

    public static List<LoaiDanhMucDto> toListDTO(List<LoaiDanhMuc> entityList) {
        List<LoaiDanhMucDto> list = new ArrayList<>();
        for (LoaiDanhMuc e : entityList) {
            list.add(LoaiDanhMucMapper.toDTO(e));
        }
        return list;
    }
}
