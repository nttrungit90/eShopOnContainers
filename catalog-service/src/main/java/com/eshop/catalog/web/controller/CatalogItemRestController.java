package com.eshop.catalog.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.eshop.catalog.infra.configurationproperties.CatalogSettings;
import com.eshop.catalog.service.CatalogBrandService;
import com.eshop.catalog.service.CatalogItemService;
import com.eshop.catalog.service.CatalogTypeService;
import com.eshop.catalog.service.dto.CatalogBrandDto;
import com.eshop.catalog.service.dto.CatalogItemDto;
import com.eshop.catalog.service.dto.CatalogTypeDto;
import com.eshop.catalog.service.dto.PaginatedItemsModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author trung.nguyenthanh
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/catalog")
@RestController
public class CatalogItemRestController {

    private final CatalogItemService catalogItemService;

    private final CatalogTypeService catalogTypeService;

    private final CatalogBrandService catalogBrandService;

    private final CatalogSettings catalogSettings;

    // localhost:6101/api/v1/catalog/items/[ids=1&ids=2]
    @GetMapping(path = "/items")
    ResponseEntity getItems(
        @RequestParam(name = "ids", required = false) List<Long> ids,

        @PageableDefault(page = 0, size = 10)
        @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Direction.ASC),
            @SortDefault(sort = "id", direction = Direction.DESC)
        }) Pageable pageable) {

        if(CollectionUtils.isEmpty(ids)) {
            PaginatedItemsModel<CatalogItemDto>  paginatedItemsModel = catalogItemService.findCatalogItemPageable(pageable);
            changeUriPlaceholder(paginatedItemsModel.getData());
            return ResponseEntity.ok(paginatedItemsModel);

        } else {
            List<CatalogItemDto> catalogItemDtos = catalogItemService.findCatalogItemByIdIn(ids);
            changeUriPlaceholder(catalogItemDtos);
            return ResponseEntity.ok(catalogItemDtos);
        }

    }

    // localhost:6101/api/v1/catalog/items/1
    @GetMapping(path = "/items/{id}")
    CatalogItemDto getItemById(@PathVariable Long id) {

        CatalogItemDto itemDto = catalogItemService.findCatalogItemById(id);

        fillProductUrl(itemDto, catalogSettings.getPicBaseUrl(), catalogSettings.isAzureStorageEnabled());

        return itemDto;

    }

    // localhost:6101/api/v1/catalog/items/withname/.NET Bot
    @GetMapping(path = "/items/withname/{name}")
    PaginatedItemsModel<CatalogItemDto> getItemsWithName(
        @PathVariable(name = "name") @Valid @NotEmpty(message = "name should not be empty") String name,

        @PageableDefault(page = 0, size = 10)
        @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Direction.ASC),
            @SortDefault(sort = "id", direction = Direction.DESC)
        }) Pageable pageable) {

        PaginatedItemsModel<CatalogItemDto>  paginatedItemsModel = catalogItemService.findCatalogItemByNameStartingWith(
            name, pageable);

        changeUriPlaceholder(paginatedItemsModel.getData());

        return paginatedItemsModel;

    }

    // localhost:6101/api/v1/catalog/items/type/1/brand/1[?pageSize=3&pageIndex=10]
    @GetMapping(path = "/items/type/{typeId}/brand/{brandId}")
    PaginatedItemsModel<CatalogItemDto> getItemsByTypeIdAndBrandId(
        @PathVariable(name = "typeId") @Valid @NotNull(message = "type id should not be null") Long typeId,
        @PathVariable(name = "brandId") @NotNull(message = "brand id should not be null") Long brandId,

        @PageableDefault(page = 0, size = 10)
        @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Direction.ASC),
            @SortDefault(sort = "id", direction = Direction.DESC)
        }) Pageable pageable) {

        PaginatedItemsModel<CatalogItemDto>  paginatedItemsModel = catalogItemService.findCatalogItemByTypeIdAndBrandId(
            typeId, brandId, pageable);

        changeUriPlaceholder(paginatedItemsModel.getData());

        return paginatedItemsModel;

    }

    // localhost:6101/api/v1/catalog/items/type/1/brand[?pageSize=3&pageIndex=10]
    @GetMapping(path = "/items/type/{typeId}/brand")
    PaginatedItemsModel<CatalogItemDto> getItemsByTypeId(
        @PathVariable(name = "typeId") @Valid @NotNull(message = "type id should not be null") Long typeId,

        @PageableDefault(page = 0, size = 10)
        @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Direction.ASC),
            @SortDefault(sort = "id", direction = Direction.DESC)
        }) Pageable pageable) {

        PaginatedItemsModel<CatalogItemDto>  paginatedItemsModel = catalogItemService.findCatalogItemByTypeId(typeId, pageable);

        changeUriPlaceholder(paginatedItemsModel.getData());

        return paginatedItemsModel;

    }

    // localhost:6101/api/v1/catalog/items/type/all/brand/1[?pageSize=3&pageIndex=10]
    @GetMapping(path = "/items/type/all/brand/{brandId}")
    PaginatedItemsModel<CatalogItemDto> getItemsByBrandId(
        @PathVariable(name = "brandId") @Valid @NotNull(message = "brand id should not be null") Long brandId,

        @PageableDefault(page = 0, size = 10)
        @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Direction.ASC),
            @SortDefault(sort = "id", direction = Direction.DESC)
        }) Pageable pageable) {

        PaginatedItemsModel<CatalogItemDto>  paginatedItemsModel = catalogItemService.findCatalogItemByBrandId(brandId, pageable);

        changeUriPlaceholder(paginatedItemsModel.getData());

        return paginatedItemsModel;

    }

    // localhost:6101/api/v1/catalog/catalogtypes
    @GetMapping(path = "/catalogtypes")
    List<CatalogTypeDto> getAllCatalogType() {

        return catalogTypeService.findAllCatalogType();
    }

    // localhost:6101/api/v1/catalog/catalogbrands
    @GetMapping(path = "/catalogbrands")
    List<CatalogBrandDto> getAllCatalogBrand() {

        return catalogBrandService.findAllCatalogBrand();
    }


    private List<CatalogItemDto> changeUriPlaceholder(List<CatalogItemDto> items) {

        for(CatalogItemDto item : items) {
            fillProductUrl(item, catalogSettings.getPicBaseUrl(), catalogSettings.isAzureStorageEnabled());
        }

        return items;
    }

    private void fillProductUrl(CatalogItemDto item, String picBaseUrl, boolean azureStorageEnabled) {
        if (item != null) {
            String productUrl = azureStorageEnabled
                ? picBaseUrl + item.getPictureFileName()
                : picBaseUrl.replace("[0]", item.getId().toString());

            item.setPictureUri(productUrl);
        }
    }

}
