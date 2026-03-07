package com.software.ERP.repository;

import com.software.ERP.entities.SaleInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleInvoiceRepo extends JpaRepository<SaleInvoice, Long> {
    SaleInvoice findByInvoiceNumber(String invoiceNumber);
    List<SaleInvoice> findByCustomerId(Long customerId);
    List<SaleInvoice> findBySaleDate(LocalDate saleDate);


}
