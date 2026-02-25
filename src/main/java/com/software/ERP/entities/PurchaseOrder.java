package com.software.ERP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private Double totalAmount;

    @ManyToOne
    private Supplier supplier;  // who you bought from

    @OneToMany(mappedBy = "purchaseOrder")
    private List<PurchaseOrderItem> items;
}
