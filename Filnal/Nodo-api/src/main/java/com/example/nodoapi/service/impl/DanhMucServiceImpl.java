package com.example.nodoapi.service.impl;

import com.example.nodoapi.entities.DanhMucEntity;
import com.example.nodoapi.pagination.exceptions.CustomException;
import com.example.nodoapi.repository.DanhMucRepository;
import com.example.nodoapi.request.FindRequet;
import com.example.nodoapi.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucServiceImpl implements DanhMucService {

    @Autowired
    private DanhMucRepository repository;

    @Override
    public DanhMucEntity insert(DanhMucEntity entity) throws CustomException {
        if (entity.equals(null)) {
            throw new CustomException(500, "Dữ liệu không hợp lệ!");
        }
        return this.repository.save(entity);
    }

    @Override
    public DanhMucEntity update(Integer id, DanhMucEntity entity) throws CustomException {
        if (id.equals(null)) {
            throw new CustomException(500, "Không có id");
        }
        entity.setId(id);
        return this.repository.save(entity);
    }

    @Override
    public DanhMucEntity delete(Integer id) throws CustomException {
        DanhMucEntity entity = this.repository.getReferenceById(id);
        if (entity.getId() == id) {
            this.repository.delete(entity);
            return entity;
        }
        return null;
    }

    @Override
    public List<DanhMucEntity> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<DanhMucEntity> getFind(FindRequet requet) {
        if (requet.getTrangThai() == null && requet.getMa() == null && requet.getTen() == null) {
            return this.getAll();
        }else {
            if(requet.getTen() == null && requet.getMa() == null) {
                return this.repository.findDanhMucEntityByTrangThai(requet.getTrangThai());
            }else if(requet.getTen() == null && requet.getTrangThai() == null) {
                return this.repository.findDanhMucEntityByMa(requet.getMa());
            }else if(requet.getMa() == null && requet.getTrangThai() == null) {
                return  this.repository.findDanhMucEntityByTen(requet.getTen());
            }else {
                if (requet.getTen() == null) {
                    return this.repository.findDanhMucEntityByMaAndTrangThai(requet.getTrangThai(), requet.getMa());
                }
                if (requet.getMa() == null) {
                    return this.repository.findDanhMucEntityByTenAndTrangThai(requet.getTen(), requet.getTrangThai());
                }
                if (requet.getTrangThai() == null) {
                    return this.repository.findDanhMucEntityByTenAndMa(requet.getTen(), requet.getMa());
                }
            }
        }


        return this.repository.findDanhMucEntityByTenAndMaAndTrangThai(requet.getTen(), requet.getTrangThai(), requet.getMa());
    }

    @Override
    public DanhMucEntity getOne(Integer id) throws CustomException {
        return this.repository.getReferenceById(id);
    }
}
