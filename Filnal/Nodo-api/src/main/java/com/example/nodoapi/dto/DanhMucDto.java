package com.example.nodoapi.dto;

import com.example.nodoapi.entities.DanhMucEntity;
import com.example.nodoapi.entities.LoaiDanhMuc;
import com.example.nodoapi.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanhMucDto {
    private Integer id;
    private String ma;
    private String ten;
    private int thuTu;
    private String nhom;
    private Integer trangThai;
    private User nguoiCapNhat;
    private User nguoiTao;
    private LoaiDanhMuc loaiDanhMuc;
    private Date ngayHieuLuc;
    private Date ngayHetHieuLuc;
    private Date ngayTao;
    private Date ngayCapNhat;
    private List<DanhMucEntity> listDm;
}
