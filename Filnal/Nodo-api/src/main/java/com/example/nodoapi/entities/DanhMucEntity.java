package com.example.nodoapi.entities;

import com.example.nodoapi.base.BaseEntity;
import com.example.nodoapi.request.DanhMucRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "danh_muc")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DanhMucEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "thu_tu")
    private int thuTu;
    @Column(name = "nhom")
    private String nhom;
    @Column(name = "trang_thai")
    private Integer trangThai;
    @ManyToOne
    @JoinColumn(name = "nguoi_cap_nhat")
    private User nguoiCapNhat;
    @ManyToOne
    @JoinColumn(name = "nguoi_tao")
    private User nguoiTao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "loai_danh_muc")
    private LoaiDanhMuc loaiDanhMuc;

    public void setData(DanhMucRequest request) {
        this.ten = request.getTen();
        this.ma = request.getMa();
        this.thuTu = request.getThuTu();
        this.trangThai = request.getTrangThai();
        this.nhom = request.getNhom();
        this.nguoiCapNhat = request.getNguoiCapNhat();
        this.nguoiTao = request.getNguoiTao();
        this.loaiDanhMuc = request.getLoaiDanhMuc();
    }
}
