package com.example.nodoapi.response;

import com.example.nodoapi.base.BaseResponse;
import com.example.nodoapi.dto.LoaiDanhMucDto;
import lombok.Data;

import java.util.List;

@Data
public class LoaiDanhMucResponse extends BaseResponse<LoaiDanhMucDto> {
    public LoaiDanhMucResponse() {
        super();
    }

    public LoaiDanhMucResponse(LoaiDanhMucDto data) {
        super(data);
    }

    public LoaiDanhMucResponse(List<LoaiDanhMucDto> data) {
        super(data);
    }

    public LoaiDanhMucResponse(int status, String message, Object data) {
        super(status, message, data);
    }

}
