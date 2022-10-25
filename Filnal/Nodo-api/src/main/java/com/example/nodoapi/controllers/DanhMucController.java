package com.example.nodoapi.controllers;


import com.example.nodoapi.entities.DanhMucEntity;
import com.example.nodoapi.exprorts.ExportExcel;
import com.example.nodoapi.pagination.exceptions.CustomException;
import com.example.nodoapi.mapper.DanhMucMapper;
import com.example.nodoapi.request.DanhMucRequest;
import com.example.nodoapi.request.FindRequet;
import com.example.nodoapi.response.DanhMucResponse;
import com.example.nodoapi.service.DanhMucService;
import com.example.nodoapi.service.LoaiDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/danhmuc")
@CrossOrigin("*")
public class DanhMucController {

    @Autowired
    DanhMucService danhMucService;
    @Autowired
    LoaiDanhMucService loaiDanhMucService;

    @GetMapping
    public DanhMucResponse list() throws CustomException {
        List<DanhMucEntity> list = danhMucService.getAll();
        if(list.size() ==0) {
            throw new CustomException(500, "Không có dữ liệu");
        }
        return new DanhMucResponse(DanhMucMapper.toListDTO(list));
    }
    @PostMapping("find")
    public DanhMucResponse find(@RequestBody FindRequet requet){
        System.out.println(requet);
        List<DanhMucEntity> list = this.danhMucService.getFind(requet);
        return new DanhMucResponse(DanhMucMapper.toListDTO(list));
    }
    @PostMapping
    public DanhMucResponse add(@Valid @RequestBody DanhMucRequest request, BindingResult result) throws CustomException{
       if(result.hasErrors()) {
           throw new CustomException(400,"Dữ liệu không hợp lệ!");
       }
       DanhMucEntity entity = new DanhMucEntity();
       entity.setData(request);
       this.danhMucService.insert(entity);
       return new DanhMucResponse(DanhMucMapper.toDTO(entity));
    }

    @PutMapping("{id}")
    public DanhMucResponse edit(@Valid @RequestBody DanhMucRequest request, BindingResult result, @PathVariable Integer id) throws CustomException{
        if(result.hasErrors()) {
            throw new CustomException(400, "Dữ liệu không hợp lệ!");
        }
        DanhMucEntity entity = new DanhMucEntity();
        entity.setId(id);
        entity.setData(request);
        this.danhMucService.update(id, entity);
        return new DanhMucResponse(DanhMucMapper.toDTO(entity));
    }

    @DeleteMapping("{id}")
    public Integer del(@PathVariable Integer id) throws CustomException {
        DanhMucEntity entity = this.danhMucService.getOne(id);
        if(entity.getId() == null ) {
            return -1;
        }
        this.danhMucService.delete(id);
        return 1;
    }

    @GetMapping("export")
    public void exportToExcel(HttpServletResponse response /*,@RequestBody List<DanhMucEntity> list*/) throws IOException
    {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=danhmuc" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        ExportExcel excelExporter = new ExportExcel(this.danhMucService.getAll()) {
        };
        excelExporter.export(response);
    }



}
