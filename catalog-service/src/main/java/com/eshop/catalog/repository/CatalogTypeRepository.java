package com.eshop.catalog.repository;

import com.eshop.catalog.domain.model.CatalogType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trung.nguyenthanh
 */
public interface CatalogTypeRepository extends JpaRepository<CatalogType,Long> {
}
