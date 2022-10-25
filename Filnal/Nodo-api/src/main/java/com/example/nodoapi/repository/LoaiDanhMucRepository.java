package com.example.nodoapi.repository;

import com.example.nodoapi.entities.DanhMucEntity;
import com.example.nodoapi.entities.LoaiDanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface LoaiDanhMucRepository extends JpaRepository<LoaiDanhMuc, Integer> {
    @Query("select e from LoaiDanhMuc e where e.ten like %:ten% and e.trangThai = :trangThai and e.ma like %:ma%")
    public List<LoaiDanhMuc> findLoaiDanhMucEntityByTenAndMaAndTrangThai(@Param("ten") String ten, @Param("trangThai") Integer trangThai, @Param("ma") String ma );

    @Query("select e from LoaiDanhMuc e where e.ten like %:ten% and e.trangThai = :trangThai")
    public List<LoaiDanhMuc> findLoaiDanhMucEntityByTenAndTrangThai(@Param("ten") String ten,@Param("trangThai") Integer trangThai);

    @Query("select e from LoaiDanhMuc e where e.ten like %:ten% and e.ma like %:ma%")
    public List<LoaiDanhMuc> findLoaiDanhMucEntityByTenAndMa(@Param("ten") String ten, @Param("ma") String ma );

    @Query("select e from LoaiDanhMuc e where e.ten like %:ten%")
    public List<LoaiDanhMuc> findLoaiDanhMucEntityByTen(@Param("ten") String ten);
    //
    @Query("select e from LoaiDanhMuc e where e.ma like %:ma%")
    public List<LoaiDanhMuc> findLoaiDanhMucEntityByMa(@Param("ma") String ma );
    //
    @Query("select e from LoaiDanhMuc e where e.trangThai = :trangThai")
    public List<LoaiDanhMuc> findLoaiDanhMucMucEntityByTrangThai(@Param("trangThai") Integer trangThai);

    @Query("select e from LoaiDanhMuc e where e.trangThai = :trangThai and e.ma = :ma")
    List<LoaiDanhMuc> findLoaiDanhMucEntityByMaAndTrangThai(Integer trangThai, String ma);
}
