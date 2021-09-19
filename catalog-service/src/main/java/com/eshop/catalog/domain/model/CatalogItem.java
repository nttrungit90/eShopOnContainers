package com.eshop.catalog.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eshop.catalog.domain.exception.CatalogDomainException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author trung.nguyenthanh
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Catalog")
@Entity
public class CatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String pictureFileName;

    @Transient
    private String pictureUri;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CatalogTypeId", nullable = false)
    private CatalogType catalogType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CatalogBrandId", nullable = false)
    private CatalogBrand catalogBrand;

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

    /**
     * Decrements the quantity of a particular item in inventory and ensures the restockThreshold hasn't
     * been breached. If so, a RestockRequest is generated in CheckThreshold.
     *
     * If there is sufficient stock of an item, then the integer returned at the end of this call should be the same as quantityDesired.
     * In the event that there is not sufficient stock available, the method will remove whatever stock is available and return that quantity to the client.
     * In this case, it is the responsibility of the client to determine if the amount that is returned is the same as quantityDesired.
     * It is invalid to pass in a negative number.
     * @param quantityDesired quantity desired
     * @return int: Returns the quantity that has been added to stock
    **/
    public int removeStock(int quantityDesired) {
        if (availableStock == 0) {
            throw new CatalogDomainException(String.format("Empty stock, product item %s is sold out", name));
        }

        if (quantityDesired <= 0) {
            throw new CatalogDomainException("Item units desired should be greater than zero");
        }

        // If there is sufficient stock of an item, then the integer
        //      returned at the end of this call should be the same as quantityDesired.
        // In the event that there is not sufficient stock available,
        //      the method will remove whatever stock is available and return that quantity to the client.
        int removed = Math.min(quantityDesired, availableStock);

        availableStock -= removed;

        return removed;
    }

    /**
     * Increments the quantity of a particular item in inventory.
     * @param quantity quantity to add
     * @return int: Returns the quantity that has been added to stock
    **/
    public int addStock(int quantity)
    {
        int original = availableStock;

        // The quantity that the client is trying to add to stock is greater than what can be physically accommodated in the Warehouse
        if ((availableStock + quantity) > maxStockThreshold) {
            // For now, this method only adds new units up maximum stock threshold. In an expanded version of this application, we
            //could include tracking for the remaining units and store information about overstock elsewhere.
            availableStock += (maxStockThreshold - availableStock);

        } else {
            availableStock += quantity;
        }

        onReorder = false;

        return availableStock - original;
    }

}
