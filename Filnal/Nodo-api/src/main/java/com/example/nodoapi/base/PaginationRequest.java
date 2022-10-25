package com.example.nodoapi.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationRequest implements Serializable {
    @NotNull(message = "limit không được để trống")
    @Digits(integer = 3, fraction = 0, message = "limit không hợp lệ")
    @Positive(message = "limit phải là số lớn hơn 0")

    private BigDecimal limit;
    @NotNull(message = "page không được để trống")
    @Digits(integer = 3, fraction = 0, message = "page không hợp lệ")
    @Positive(message = "page phải là số lớn hơn 0")
    private BigDecimal page;
    private String searchText;
    private String orderBy;

    public Map<String, String> getOrders() {
        Map<String, String> fields = new HashMap<>();
        if (orderBy != null && !orderBy.isEmpty()) {
            String[] splits = orderBy.split(",");
            for (String s : splits) {
                String[] f = s.split(":");
                if (f.length == 1) {
                    fields.put(f[0], "ASC");
                } else {
                    if ("DESC".equals(f[1].toUpperCase())) {
                        fields.put(f[0], "DESC");
                    } else {
                        fields.put(f[0], "ASC");
                    }
                }
            }
        }
        return fields;
    }

    public List<Filter> getFilters() {
        return new ArrayList<>();
    }

    public Integer getLimit() {
        return this.limit.intValue();
    }

    public Integer getPage() {
        return this.page.intValue() - 1;
    }
}
