package com.eshop.catalog.repository;

import java.util.List;

import com.eshop.catalog.domain.model.CatalogItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author trung.nguyenthanh
 */
public interface CatalogItemRepository extends JpaRepository<CatalogItem,Long> {

    /**
     * Find by id in ids
     * @param ids
     * @return
     */
    List<CatalogItem> findByIdIn(List<Long> ids);

    /**
     * Find by name start with
     * @param name
     * @return
     */
    Page<CatalogItem> findByNameStartingWith(String name, Pageable pageable);

}
