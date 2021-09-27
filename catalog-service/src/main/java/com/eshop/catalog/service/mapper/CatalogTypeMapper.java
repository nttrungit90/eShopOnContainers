package com.eshop.catalog.service.mapper;

import com.eshop.catalog.domain.model.CatalogType;
import com.eshop.catalog.service.dto.CatalogTypeDto;
import org.mapstruct.Mapper;

@Mapper
public interface CatalogTypeMapper {

    CatalogType catalogTypeDtoToCatalogType(CatalogTypeDto catalogTypeDto);

    CatalogTypeDto catalogTypeToCatalogTypeDto(CatalogType catalogType);
}
