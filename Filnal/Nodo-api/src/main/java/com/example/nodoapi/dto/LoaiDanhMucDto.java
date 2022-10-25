package com.example.nodoapi.dto;

import com.example.nodoapi.entities.DanhMucEntity;
import com.example.nodoapi.entities.LoaiDanhMuc;
import com.example.nodoapi.entities.User;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class LoaiDanhMucDto {
    private int id;
    private String ma;
    private String ten;
    private Date ngayHieuLuc;
    private Date ngayHetHieuLuc;
    private int trangThai;
    private Date ngayTao;
    private Date ngayCapNhat;
    private User nguoiTao;
    private List<DanhMucEntity> listDM;
}
