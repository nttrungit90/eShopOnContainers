package com.eshop.catalog.web.model;

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
public class PaginatedItemsViewModel<T> {

    private int pageIndex;

    private int pageSize;

    private int count;

    private List<T> data;

}
