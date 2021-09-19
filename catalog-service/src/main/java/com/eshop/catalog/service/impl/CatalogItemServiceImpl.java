package com.eshop.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.eshop.catalog.domain.model.CatalogItem;
import com.eshop.catalog.repository.CatalogItemRepository;
import com.eshop.catalog.service.CatalogItemService;
import com.eshop.catalog.service.dto.CatalogItemDto;
import com.eshop.catalog.service.dto.PaginatedItemsModel;
import com.eshop.catalog.service.mapper.CatalogItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author trung.nguyenthanh
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CatalogItemServiceImpl implements CatalogItemService {

    private final CatalogItemRepository catalogItemRepository;

    private final CatalogItemMapper catalogItemMapper;

    @Override
    public PaginatedItemsModel<CatalogItemDto> loadCatalogItemPage(List<Long> ids, Pageable pageable) {

        Page<CatalogItem> catalogItemPage;
        if(CollectionUtils.isEmpty(ids)) {
            catalogItemPage = catalogItemRepository.findAll(pageable);
        } else {
            catalogItemPage = catalogItemRepository.findByIdIn(ids, pageable);
        }

        List<CatalogItemDto> catalogItemDtos = catalogItemPage.get()
            .map(catalogItemMapper::catalogItemToCatalogItemDto)
            .collect(Collectors.toList());

        return PaginatedItemsModel.<CatalogItemDto>builder()
            .totalElements(catalogItemPage.getTotalElements())
            .totalPages(catalogItemPage.getTotalPages())
            .pageIndex(pageable.getPageNumber())
            .pageSize(pageable.getPageSize())
            .data(catalogItemDtos)
            .build();

    }

}
