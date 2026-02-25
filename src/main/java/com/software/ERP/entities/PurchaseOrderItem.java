package com.software.ERP.entities;

import com.software.ERP.entities.Medicine;
import com.software.ERP.entities.PurchaseOrder;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PurchaseOrder purchaseOrder;  // which order

    @ManyToOne
    private Medicine medicine;  // which medicine

    private Integer quantity;
    private Double purchasePrice;
    private Double sellingPrice;
    private String batchNumber;
    private LocalDate expiryDate;
    private Double gstPercentage;
    private Double itemTotal;

    @PrePersist
    @PreUpdate
    protected void calculateItemTotal() {
        this.itemTotal = this.quantity * this.purchasePrice;
    }
}