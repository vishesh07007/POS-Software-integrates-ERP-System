package com.software.ERP.controllers;


import com.software.ERP.entities.SaleInvoice;
import com.software.ERP.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;


    @PostMapping
    public SaleInvoice createSale(@RequestBody SaleInvoice saleInvoice) {
        return  saleService.createSale(saleInvoice);
    }

    @GetMapping
    public List<SaleInvoice> getAllSales() {
        return saleService.getAllSales();
    }





}
