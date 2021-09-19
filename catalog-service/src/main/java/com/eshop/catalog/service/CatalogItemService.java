package com.eshop.catalog.service;

import java.util.List;

import com.eshop.catalog.service.dto.CatalogItemDto;
import com.eshop.catalog.service.dto.PaginatedItemsModel;
import org.springframework.data.domain.Pageable;

/**
 * @author trung.nguyenthanh
 */
public interface CatalogItemService {

    /**
     * loadCatalogItemPage
     * If ids is not empty, query with ids and paging
     * If ids is empty, query with paging
     * @param ids
     * @param pageable
     * @return
     */
    PaginatedItemsModel<CatalogItemDto> loadCatalogItemPage(List<Long> ids, Pageable pageable);
}
