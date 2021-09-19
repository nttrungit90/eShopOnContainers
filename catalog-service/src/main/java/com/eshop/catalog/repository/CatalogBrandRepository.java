package com.eshop.catalog.repository;

import com.eshop.catalog.domain.model.CatalogBrand;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trung.nguyenthanh
 */
public interface CatalogBrandRepository extends JpaRepository<CatalogBrand,Long> {
}
