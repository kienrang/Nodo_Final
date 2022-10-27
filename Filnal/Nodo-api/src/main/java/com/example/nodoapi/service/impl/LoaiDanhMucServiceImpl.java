package com.example.nodoapi.service.impl;

import com.example.nodoapi.base.Filter;
import com.example.nodoapi.entities.LoaiDanhMuc;
import com.example.nodoapi.repository.LoaiDanhMucRepository;
import com.example.nodoapi.request.FindRequet;
import com.example.nodoapi.service.LoaiDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoaiDanhMucServiceImpl implements LoaiDanhMucService {
    @Autowired
    private LoaiDanhMucRepository loaiDanhMucRepository;

    @Override
    public LoaiDanhMuc insert(LoaiDanhMuc data) {
        return this.loaiDanhMucRepository.save(data);
    }

    @Override
    public LoaiDanhMuc update(Integer id, LoaiDanhMuc entity) {
        try {
            return this.loaiDanhMucRepository.save(entity);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public LoaiDanhMuc delete(LoaiDanhMuc entity) {
        this.loaiDanhMucRepository.delete(entity);
        return entity;
    }

    @Override
    public LoaiDanhMuc getOne(Integer id) {
        return this.loaiDanhMucRepository.getReferenceById(id);
    }

    @Override
    public List<LoaiDanhMuc> getAll() {
        return this.loaiDanhMucRepository.findAll();
    }

    @Override
    public List<LoaiDanhMuc> findLoaiDanhMuc(FindRequet requet) {
        if (requet.getTrangThai() == null && requet.getMa() == null && requet.getTen() == null) {
            return this.getAll();
        }else {
            if(requet.getTen() == null && requet.getMa() == null) {
                return this.loaiDanhMucRepository.findLoaiDanhMucMucEntityByTrangThai(requet.getTrangThai());
            }else if(requet.getTen() == null && requet.getTrangThai() == null) {
                return this.loaiDanhMucRepository.findLoaiDanhMucEntityByMa(requet.getMa());
            }else if(requet.getMa() == null && requet.getTrangThai() == null) {
                return  this.loaiDanhMucRepository.findLoaiDanhMucEntityByTen(requet.getTen());
            }else {
                if (requet.getTen() == null) {
                    return this.loaiDanhMucRepository.findLoaiDanhMucEntityByMaAndTrangThai(requet.getTrangThai(), requet.getMa());
                }
                if (requet.getMa() == null) {
                    return this.loaiDanhMucRepository.findLoaiDanhMucEntityByTenAndTrangThai(requet.getTen(), requet.getTrangThai());
                }
                if (requet.getTrangThai() == null) {
                    return this.loaiDanhMucRepository.findLoaiDanhMucEntityByTenAndMa(requet.getTen(), requet.getMa());
                }
            }
        }
        return this.loaiDanhMucRepository.findLoaiDanhMucEntityByTenAndMaAndTrangThai(requet.getTen(), requet.getTrangThai(), requet.getMa());
    }

    @Override
    public Page<LoaiDanhMuc> paginate(int page, int limit, List<Filter> whereParams, Map<String, String> sortBy) {
        return null;
    }


}
