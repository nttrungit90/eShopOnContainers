package com.eshop.catalog.service;

import java.util.List;

import com.eshop.catalog.service.dto.CatalogBrandDto;

/**
 * @author trung.nguyenthanh
 */
public interface CatalogBrandService {
    /**
     * Find all catalog brand
     * @return
     */
    List<CatalogBrandDto> findAllCatalogBrand();
}
