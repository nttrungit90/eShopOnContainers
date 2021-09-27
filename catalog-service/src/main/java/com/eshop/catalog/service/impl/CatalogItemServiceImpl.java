package com.eshop.catalog.service.impl;

import java.util.List;
import java.util.Optional;
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
    public PaginatedItemsModel<CatalogItemDto> findCatalogItemPageable(Pageable pageable) {

        Page<CatalogItem> catalogItemPage = catalogItemRepository.findAll(pageable);

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

    @Override
    public PaginatedItemsModel<CatalogItemDto> findCatalogItemByNameStartingWith(String name, Pageable pageable) {
        Page<CatalogItem> catalogItemPage = catalogItemRepository.findByNameStartingWith(name, pageable);

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

    @Override
    public List<CatalogItemDto> findCatalogItemByIdIn(List<Long> ids) {
        List<CatalogItem> catalogItems = catalogItemRepository.findByIdIn(ids);

        return catalogItems.stream()
            .map(catalogItemMapper::catalogItemToCatalogItemDto)
            .collect(Collectors.toList());
    }

    @Override
    public CatalogItemDto findCatalogItemById(Long id) {

        Optional<CatalogItem> catalogItemOpt = catalogItemRepository.findById(id);
        return catalogItemOpt.map(catalogItemMapper::catalogItemToCatalogItemDto).orElse(null);

    }

    @Override
    public  PaginatedItemsModel<CatalogItemDto> findCatalogItemByTypeIdAndBrandId(Long typeId, Long brandId, Pageable pageable) {
        //Page<CatalogItem> catalogItemPage = catalogItemRepository.findByCatalogTypeIdAndCatalogBrandId(typeId, brandId, pageable);

        Page<CatalogItem> catalogItemPage = catalogItemRepository.findByCatalogTypeIdAndCatalogBrandIdV2(typeId, brandId, pageable);
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

    @Override
    public PaginatedItemsModel<CatalogItemDto> findCatalogItemByBrandId(Long brandId, Pageable pageable) {
        //Page<CatalogItem> catalogItemPage = catalogItemRepository.findByCatalogBrandId(brandId, pageable);
        Page<CatalogItem> catalogItemPage = catalogItemRepository.findByCatalogTypeIdAndCatalogBrandIdV2(null, brandId, pageable);

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

    @Override
    public PaginatedItemsModel<CatalogItemDto> findCatalogItemByTypeId(Long typeId, Pageable pageable) {
        //Page<CatalogItem> catalogItemPage = catalogItemRepository.findByCatalogTypeId(typeId, pageable);
        Page<CatalogItem> catalogItemPage = catalogItemRepository.findByCatalogTypeIdAndCatalogBrandIdV2(typeId, null, pageable);

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
