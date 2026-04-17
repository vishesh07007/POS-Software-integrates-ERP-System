package com.software.ERP.service;


import com.software.ERP.entities.SaleInvoice;
import com.software.ERP.repository.BatchRepo;
import com.software.ERP.repository.SaleInvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private SaleInvoiceRepo saleInvoiceRepo;

    // 1. Get all sales
    public List<SaleInvoice> getAllSales() {
        return saleInvoiceRepo.findAll();
    }

    // 2. Get sale by ID
    public SaleInvoice getSaleById(Long id) {
        return saleInvoiceRepo.findById(id).orElse(null);
    }



}
