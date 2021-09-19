package com.eshop.catalog.service.dto;

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
public class CatalogTypeDto {

    private Long id;

    private String type;
}
