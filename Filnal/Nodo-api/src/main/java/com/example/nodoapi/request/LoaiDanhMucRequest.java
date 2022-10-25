package com.example.nodoapi.request;

import com.example.nodoapi.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoaiDanhMucRequest {
    private String ten;
    private String ma;
    private Date ngayHieuLuc;
    private Date ngayHetHieuLuc;
    private int trangThai;
    private Date ngayTao;
    private Date ngayCapNhat;
    private User nguoiTao;
}
