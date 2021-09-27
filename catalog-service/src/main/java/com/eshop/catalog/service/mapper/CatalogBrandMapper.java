package com.eshop.catalog.service.mapper;

import com.eshop.catalog.domain.model.CatalogBrand;
import com.eshop.catalog.service.dto.CatalogBrandDto;
import org.mapstruct.Mapper;

@Mapper
public interface CatalogBrandMapper {

    CatalogBrand catalogBrandDtoToCatalogBrand(CatalogBrandDto catalogBrandDto);

    CatalogBrandDto catalogBrandToCatalogBrandDto(CatalogBrand catalogBrand);

}
