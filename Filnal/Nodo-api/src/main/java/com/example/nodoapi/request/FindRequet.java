package com.example.nodoapi.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindRequet {
    private Integer trangThai;
    private String ten;
    private String ma;
}
