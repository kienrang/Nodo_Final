package com.example.nodoapi.base;

import com.example.nodoapi.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Column(updatable = false)
    @CreationTimestamp
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ngayTao;
    @Column(updatable = false)
    @CreationTimestamp
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ngayCapNhat;
    @Column(updatable = false)
    @CreationTimestamp
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ngayHieuLuc;
    @Column(updatable = false)
    @CreationTimestamp
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ngayHetHieuLuc;
}
