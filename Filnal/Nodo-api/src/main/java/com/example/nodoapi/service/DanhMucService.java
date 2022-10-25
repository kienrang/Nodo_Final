package com.example.nodoapi.service;

import com.example.nodoapi.entities.DanhMucEntity;
import com.example.nodoapi.pagination.exceptions.CustomException;
import com.example.nodoapi.request.FindRequet;

import java.util.List;

public interface DanhMucService {
    public DanhMucEntity insert(DanhMucEntity entity) throws CustomException;
    public DanhMucEntity update(Integer id,DanhMucEntity entity) throws CustomException;
    public DanhMucEntity delete(Integer id) throws CustomException;
    public List<DanhMucEntity> getAll();
    public List<DanhMucEntity> getFind(FindRequet requet);

    public DanhMucEntity getOne(Integer id) throws CustomException;


}
