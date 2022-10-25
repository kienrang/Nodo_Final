package com.example.nodoapi.repository;

import com.example.nodoapi.entities.DanhMucEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMucEntity, Integer> {

    @Query("select e from DanhMucEntity e where e.ten like %:ten% and e.trangThai = :trangThai and e.ma like %:ma%")
    public List<DanhMucEntity> findDanhMucEntityByTenAndMaAndTrangThai(@Param("ten") String ten,@Param("trangThai") Integer trangThai,@Param("ma") String ma );

    @Query("select e from DanhMucEntity e where e.ten like %:ten% and e.trangThai = :trangThai")
    public List<DanhMucEntity> findDanhMucEntityByTenAndTrangThai(@Param("ten") String ten,@Param("trangThai") Integer trangThai);

    @Query("select e from DanhMucEntity e where e.ten like %:ten% and e.ma like %:ma%")
    public List<DanhMucEntity> findDanhMucEntityByTenAndMa(@Param("ten") String ten, @Param("ma") String ma );

    @Query("select e from DanhMucEntity e where e.ten like %:ten%")
    public List<DanhMucEntity> findDanhMucEntityByTen(@Param("ten") String ten);
//
    @Query("select e from DanhMucEntity e where e.ma like %:ma%")
    public List<DanhMucEntity> findDanhMucEntityByMa(@Param("ma") String ma );
//
    @Query("select e from DanhMucEntity e where e.trangThai = :trangThai")
    public List<DanhMucEntity> findDanhMucEntityByTrangThai(@Param("trangThai") Integer trangThai);

    @Query("select e from DanhMucEntity e where  e.trangThai = :trangThai and e.ma like %:ma%")
    public List<DanhMucEntity> findDanhMucEntityByMaAndTrangThai(@Param("trangThai") Integer trangThai,@Param("ma") String ma );
}
