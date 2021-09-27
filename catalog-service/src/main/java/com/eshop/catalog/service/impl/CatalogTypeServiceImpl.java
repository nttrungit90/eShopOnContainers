package com.eshop.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.eshop.catalog.repository.CatalogTypeRepository;
import com.eshop.catalog.service.CatalogTypeService;
import com.eshop.catalog.service.dto.CatalogTypeDto;
import com.eshop.catalog.service.mapper.CatalogTypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author trung.nguyenthanh
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CatalogTypeServiceImpl implements CatalogTypeService {

    private final CatalogTypeRepository catalogTypeRepository;

    private final CatalogTypeMapper catalogTypeMapper;

    @Override
    public List<CatalogTypeDto> findAllCatalogType() {
        return catalogTypeRepository.findAll().stream()
            .map(catalogTypeMapper::catalogTypeToCatalogTypeDto)
            .collect(Collectors.toList());
    }
}
