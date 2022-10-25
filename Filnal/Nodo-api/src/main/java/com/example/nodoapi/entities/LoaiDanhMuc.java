package com.example.nodoapi.entities;

import com.example.nodoapi.base.BaseEntity;
import com.example.nodoapi.request.LoaiDanhMucRequest;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_danh_muc")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiDanhMuc extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ten")
    private String ten;
    @Column(name = "ma")
    private String ma;
    @Column(name = "trang_thai")
    private int trangThai;
    @ManyToOne
    @JoinColumn(name = "nguoi_tao")
    private User nguoiTao;

    @OneToMany(mappedBy = "loaiDanhMuc", fetch = FetchType.EAGER)
    private List<DanhMucEntity> listDm;

    public void setData(LoaiDanhMucRequest request) {
        this.ten = request.getTen();
        this.ma = request.getMa();
        this.trangThai = request.getTrangThai();
        this.nguoiTao = request.getNguoiTao();
    }
}
