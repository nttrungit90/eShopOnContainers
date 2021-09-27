package com.eshop.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.eshop.catalog.repository.CatalogBrandRepository;
import com.eshop.catalog.service.CatalogBrandService;
import com.eshop.catalog.service.dto.CatalogBrandDto;
import com.eshop.catalog.service.mapper.CatalogBrandMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author trung.nguyenthanh
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CatalogBrandServiceImpl implements CatalogBrandService {

    private final CatalogBrandRepository catalogBrandRepository;

    private final CatalogBrandMapper catalogBrandMapper;

    @Override
    public List<CatalogBrandDto> findAllCatalogBrand() {
        return catalogBrandRepository.findAll().stream()
            .map(catalogBrandMapper::catalogBrandToCatalogBrandDto)
            .collect(Collectors.toList());
    }
}
