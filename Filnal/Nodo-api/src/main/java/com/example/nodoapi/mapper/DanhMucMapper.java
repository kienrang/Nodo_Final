package com.example.nodoapi.mapper;

import com.example.nodoapi.dto.DanhMucDto;
import com.example.nodoapi.dto.LoaiDanhMucDto;
import com.example.nodoapi.entities.DanhMucEntity;
import com.example.nodoapi.entities.LoaiDanhMuc;
import com.example.nodoapi.request.DanhMucRequest;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DanhMucMapper{
    private static DanhMucMapper INSTANCE;

    public static DanhMucMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DanhMucMapper();
        }

        return INSTANCE;
    }

    public DanhMucMapper() {
    }

    public static DanhMucDto toDTO(DanhMucEntity dm) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dm, DanhMucDto.class);
    }

    public static DanhMucEntity toEntity(DanhMucMapper cateDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cateDTO, DanhMucEntity.class);
    }

    public static Page<DanhMucDto> toPageDTO(Page<DanhMucEntity> page) {
        return page.map(new Function<>() {
            @Override
            public DanhMucDto apply(DanhMucEntity entity) {
                return DanhMucMapper.toDTO(entity);
            }
        });
    }

    public static List<DanhMucDto> toListDTO(List<DanhMucEntity> entityList) {
        List<DanhMucDto> list = new ArrayList<>();
        for (DanhMucEntity e : entityList) {
            list.add(DanhMucMapper.toDTO(e));
        }
        return list;
    }
}
