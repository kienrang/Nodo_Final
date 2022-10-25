package com.example.nodoapi.response;

import com.example.nodoapi.base.BaseResponse;
import com.example.nodoapi.dto.DanhMucDto;

import java.util.List;

public class DanhMucResponse extends BaseResponse<DanhMucDto> {
    public DanhMucResponse() {
        super();
    }

    public DanhMucResponse(DanhMucDto data) {
        super(data);
    }

    public DanhMucResponse(List<DanhMucDto> data) {
        super(data);
    }
}
