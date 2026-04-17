package com.software.ERP.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sale_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false)
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "sale_invoice_id", nullable = false)
    private SaleInvoice saleInvoice;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;  // Track which batch was sold

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double sellingPrice;  // Price of one unit

    @Column(nullable = false)
    private Double gstPercentage;  // e.g., 12.0 or 18.0

    private Double gstAmount;      // calculated GST amount

    private Double totalAmount;    // subtotal + gstAmount

    private Double subtotal;  // quantity * sellingPrice

    @PrePersist
    @PreUpdate

    public void calculateSubtotal() {
        // Calculate subtotal (price × quantity)
        this.subtotal = this.quantity * this.sellingPrice;

        // Calculate GST amount
        this.gstAmount = this.subtotal * (this.gstPercentage / 100);

        // Calculate total (subtotal + GST)
        this.totalAmount = this.subtotal + this.gstAmount;
    }


}
