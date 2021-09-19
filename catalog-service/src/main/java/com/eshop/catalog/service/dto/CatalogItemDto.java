package com.eshop.catalog.service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author trung.nguyenthanh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogItemDto {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String pictureFileName;

    private String pictureUri;

    private CatalogTypeDto catalogType;

    private CatalogBrandDto catalogBrand;

    /**
     * Quantity in stock
     */
    private int availableStock;

    /**
     * Available stock at which we should reorder
     */
    private int restockThreshold;

    /**
     * Maximum number of units that can be in-stock at any time
     * (due to physicial/logistical constraints in warehouses)
     */
    private int maxStockThreshold;

    /**
     * True if item is on reorder
     */
    private boolean onReorder;

}
