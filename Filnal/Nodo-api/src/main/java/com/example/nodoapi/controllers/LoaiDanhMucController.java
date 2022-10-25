package com.example.nodoapi.controllers;

import com.example.nodoapi.entities.LoaiDanhMuc;
import com.example.nodoapi.pagination.exceptions.CustomException;
import com.example.nodoapi.mapper.LoaiDanhMucMapper;
import com.example.nodoapi.request.FindRequet;
import com.example.nodoapi.request.LoaiDanhMucRequest;
import com.example.nodoapi.response.LoaiDanhMucResponse;
import com.example.nodoapi.service.LoaiDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/loaidanhmuc")
@CrossOrigin("http://localhost:4200")
public class LoaiDanhMucController {
    @Autowired
    LoaiDanhMucService loaiDanhMucService;

    @GetMapping
    public LoaiDanhMucResponse list() throws CustomException {
        List<LoaiDanhMuc> list = this.loaiDanhMucService.getAll();
        if(list.size() ==0) {
            throw new CustomException(500, "Không có dữ liệu");
        }
        return new LoaiDanhMucResponse(LoaiDanhMucMapper.toListDTO(list));
    }

    @PostMapping("find")
    public LoaiDanhMucResponse find(@RequestBody FindRequet requet){
        System.out.println(requet.toString());
        List<LoaiDanhMuc> list = this.loaiDanhMucService.findLoaiDanhMuc(requet);
        return new LoaiDanhMucResponse(LoaiDanhMucMapper.toListDTO(list));
    }

    @PostMapping
    public LoaiDanhMucResponse add(@Valid @RequestBody LoaiDanhMucRequest request, BindingResult result) throws CustomException {
        if(result.hasErrors()) {
            throw new CustomException(500, "Dữ liệu không hợp lệ");
        }
        LoaiDanhMuc entity = new LoaiDanhMuc();
        entity.setData(request);
        this.loaiDanhMucService.insert(entity);
        return new LoaiDanhMucResponse(LoaiDanhMucMapper.toDTO(entity));
    }

    @PutMapping("{id}")
    public LoaiDanhMucResponse edit(@Valid @RequestBody LoaiDanhMucRequest request, BindingResult result, @PathVariable Integer id) throws CustomException {
        if(result.hasErrors()) {
            throw new CustomException(500, "Dữ liệu không hợp lệ!");
        }
        LoaiDanhMuc entity = new LoaiDanhMuc();
        entity.setData(request);
        entity.setId(id);
        this.loaiDanhMucService.update(id, entity);
        return new LoaiDanhMucResponse(LoaiDanhMucMapper.toDTO(entity));
    }
    @DeleteMapping("{id}")
    public LoaiDanhMucResponse del(@PathVariable Integer id) throws CustomException {
        LoaiDanhMuc entity = this.loaiDanhMucService.getOne(id);
        System.out.println("---------------" + entity.toString());
        this.loaiDanhMucService.delete(entity);
        return new LoaiDanhMucResponse(LoaiDanhMucMapper.toDTO(entity));
    }
}
