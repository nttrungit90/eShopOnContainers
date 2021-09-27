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
     * findCatalogItemPageable
     * @param pageable
     * @return
     */
    PaginatedItemsModel<CatalogItemDto> findCatalogItemPageable(Pageable pageable);

    /**
     * findCatalogItemByName
     * @param name
     * @param pageable
     * @return
     */
    PaginatedItemsModel<CatalogItemDto> findCatalogItemByNameStartingWith(String name, Pageable pageable);

    /**
     * Find by ids in
     * @param ids
     * @return
     */
    List<CatalogItemDto> findCatalogItemByIdIn(List<Long> ids);

    /**
     * Get by id
     * @param id
     * @return
     */
    CatalogItemDto findCatalogItemById(Long id);


    PaginatedItemsModel<CatalogItemDto> findCatalogItemByTypeIdAndBrandId(Long typeId, Long brandId, Pageable pageable);

    PaginatedItemsModel<CatalogItemDto> findCatalogItemByBrandId(Long brandId, Pageable pageable);

    PaginatedItemsModel<CatalogItemDto> findCatalogItemByTypeId(Long typeId, Pageable pageable);
}
