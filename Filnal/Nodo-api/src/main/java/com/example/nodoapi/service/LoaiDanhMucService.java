package com.example.nodoapi.service;

import com.example.nodoapi.base.Filter;
import com.example.nodoapi.entities.LoaiDanhMuc;
import com.example.nodoapi.request.FindRequet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface LoaiDanhMucService {
    public LoaiDanhMuc insert(LoaiDanhMuc request);
    public LoaiDanhMuc update(Integer id, LoaiDanhMuc entity);
    public LoaiDanhMuc delete(LoaiDanhMuc id);

    public LoaiDanhMuc getOne(Integer id);
    public List<LoaiDanhMuc> getAll();
    public List<LoaiDanhMuc> findLoaiDanhMuc(FindRequet requet);
    Page<LoaiDanhMuc> paginate(int page, int limit, List<Filter> whereParams, Map<String, String> sortBy);
}
