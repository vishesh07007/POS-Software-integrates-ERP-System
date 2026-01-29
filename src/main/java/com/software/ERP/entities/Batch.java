package com.software.ERP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "Batch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private Medicine medicine;

    private String batchNumber;

    private LocalDate expiryDate;

    @Column(nullable = false)
    private Integer currentQuantity;  // Current stock

    @Column(nullable = false)
    private Integer initialQuantity;  // Original quantity received

    private Double costPrice;

    private Double sellingPrice;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
