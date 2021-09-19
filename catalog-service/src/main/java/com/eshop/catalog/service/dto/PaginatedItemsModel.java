package com.eshop.catalog.service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author trung.nguyenthanh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginatedItemsModel<T> {

    private int pageIndex;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private List<T> data;

}
