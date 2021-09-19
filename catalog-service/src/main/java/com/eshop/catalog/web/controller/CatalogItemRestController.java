package com.eshop.catalog.web.controller;

import java.util.List;

import com.eshop.catalog.service.CatalogItemService;
import com.eshop.catalog.service.dto.CatalogItemDto;
import com.eshop.catalog.service.dto.PaginatedItemsModel;
import com.eshop.catalog.infra.configurationproperties.CatalogSettings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final CatalogSettings catalogSettings;

    @GetMapping(path = "/items")
    PaginatedItemsModel<CatalogItemDto> loadCatalogItemPage(
        @RequestParam(name = "ids", required = false) List<Long> ids,

        @PageableDefault(page = 0, size = 20)
        @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Direction.ASC),
            @SortDefault(sort = "id", direction = Direction.DESC)
        })
        Pageable pageable) {

        PaginatedItemsModel<CatalogItemDto>  paginatedItemsModel = catalogItemService.loadCatalogItemPage(ids, pageable);

        changeUriPlaceholder(paginatedItemsModel.getData());

        return paginatedItemsModel;

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
