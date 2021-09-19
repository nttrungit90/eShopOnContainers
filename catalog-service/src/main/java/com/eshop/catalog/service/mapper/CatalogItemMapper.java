package com.eshop.catalog.service.mapper;

import com.eshop.catalog.domain.model.CatalogBrand;
import com.eshop.catalog.domain.model.CatalogItem;
import com.eshop.catalog.domain.model.CatalogType;
import com.eshop.catalog.service.dto.CatalogBrandDto;
import com.eshop.catalog.service.dto.CatalogItemDto;
import com.eshop.catalog.service.dto.CatalogTypeDto;
import org.mapstruct.Mapper;

@Mapper
public interface CatalogItemMapper {

    CatalogItemDto catalogItemToCatalogItemDto(CatalogItem catalogItem);

    CatalogItem catalogItemDtoToCatalogItem(CatalogItemDto catalogItemDto);

    CatalogBrand catalogBrandDtoToCatalogBrand(CatalogBrandDto catalogBrandDto);

    CatalogBrandDto catalogBrandToCatalogBrandDto(CatalogBrand catalogBrand);

    CatalogType catalogTypeDtoToCatalogType(CatalogTypeDto catalogTypeDto);

    CatalogTypeDto catalogTypeToCatalogTypeDto(CatalogType catalogType);
}
