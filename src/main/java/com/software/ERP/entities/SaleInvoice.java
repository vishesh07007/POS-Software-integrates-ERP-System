package com.software.ERP.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true)
    private String invoiceNumber;

    @ManyToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private LocalDate saleDate;

    @Column(nullable = false)
    private Double totalAmount;

    private String paymentMode;  // CASH, CARD, UPI

   @OneToMany(mappedBy = "saleInvoice", cascade = CascadeType.ALL)
    private List<SaleItem> items = new ArrayList<>();
   
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
