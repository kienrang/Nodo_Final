package com.example.nodoapi.request;

import com.example.nodoapi.entities.LoaiDanhMuc;
import com.example.nodoapi.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanhMucRequest {
    private String ma;
    private String ten;
    private int thuTu;
    private String nhom;
    private int trangThai;
    private User nguoiCapNhat;
    private User nguoiTao;
    private LoaiDanhMuc loaiDanhMuc;
}
