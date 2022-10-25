package com.example.nodoapi.pagination;

import com.example.nodoapi.base.Filter;
import com.example.nodoapi.base.PaginationRequest;
import com.example.nodoapi.base.QueryOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiDanhMucPaginationRequest extends PaginationRequest {
    private String searchName;

    private String searchStatus;

    public List<Filter> getFilters() {
        List<Filter> list = new ArrayList<>();
        if (searchName != null && !searchName.isEmpty()) {
            list.add(new Filter("name", QueryOperator.LIKE, searchName, null));
        }
        if (searchStatus != null && !searchStatus.isEmpty()) {
            list.add(new Filter("active", QueryOperator.EQUALS, searchStatus, null));
        }
        return list;
    }
}
