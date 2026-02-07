package com.software.ERP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id", nullable = false)
    private PurchaseOrder purchaseOrder ;

    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine medicine;

    @Column(nullable = false)
    private String batchNumber;  // From supplier

    private LocalDate expiryDate;  // From supplier

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double purchasePrice;  // Per unit cost

    @Column(nullable = false)
    private Double sellingPrice;  // MRP for this batch

    private Double gstPercentage;

    private Double itemTotal;  // quantity * purchasePrice




}
