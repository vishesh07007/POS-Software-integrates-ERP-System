package com.software.ERP.repository;

import com.software.ERP.entities.SaleInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleInvoiceRepo extends JpaRepository<SaleInvoice, Long> {
    SaleInvoice findByInvoiceNumber(String invoiceNumber);
    List<SaleInvoice> findByCustomerId(Long customerId);
    List<SaleInvoice> findBySaleDate(LocalDate saleDate);


}
