package com.eshop.catalog.repository;

import java.util.List;

import com.eshop.catalog.domain.model.CatalogItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    /**
     *
     * @param typeId
     * @param brandId
     * @param pageable
     * @return
     */
    Page<CatalogItem> findByCatalogTypeIdAndCatalogBrandId(Long typeId, Long brandId, Pageable pageable);

    /**
     * findByCatalogTypeIdAndCatalogBrandIdV2
     * @param typeId
     * @param brandId
     * @param pageable
     * @return
     */
    @Query("SELECT c FROM CatalogItem c WHERE (:typeId is null or c.catalogType.id = :typeId) and "
        + "(:brandId is null or c.catalogBrand.id = :brandId)")
    Page<CatalogItem> findByCatalogTypeIdAndCatalogBrandIdV2(@Param("typeId") Long typeId,
        @Param("brandId") Long brandId, Pageable pageable);


    /**
     *
     * @param typeId
     * @param pageable
     * @return
     */
    Page<CatalogItem> findByCatalogTypeId(Long typeId, Pageable pageable);

    /**
     *
     * @param brandId
     * @param pageable
     * @return
     */
    Page<CatalogItem> findByCatalogBrandId(Long brandId, Pageable pageable);

}
