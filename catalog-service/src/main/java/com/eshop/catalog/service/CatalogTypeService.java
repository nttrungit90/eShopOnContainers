package com.eshop.catalog.service;

import java.util.List;

import com.eshop.catalog.service.dto.CatalogTypeDto;

/**
 * @author trung.nguyenthanh
 */
public interface CatalogTypeService {
    /**
     * Find all catalog type
     * @return
     */
    List<CatalogTypeDto> findAllCatalogType();
}
