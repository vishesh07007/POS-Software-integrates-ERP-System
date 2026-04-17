package com.software.ERP.service;


import com.software.ERP.entities.Batch;
import com.software.ERP.entities.SaleInvoice;
import com.software.ERP.entities.SaleItem;
import com.software.ERP.repository.BatchRepo;
import com.software.ERP.repository.SaleInvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private SaleInvoiceRepo saleInvoiceRepo;

    public SaleInvoice createSale(SaleInvoice invoice){


        invoice.setInvoiceNumber("INV-" + System.currentTimeMillis());
        invoice.setSaleDate(LocalDate.now());

        double total = 0;

        for (SaleItem item : invoice.getItems()) {

            Batch batch = batchRepo.findByMedicineId(item.getMedicine().getId()).get(0);

            batch.setCurrentQuantity(batch.getCurrentQuantity() - item.getQuantity());
            batchRepo.save(batch);

            item.setBatch(batch);
            item.setSaleInvoice(invoice);

            item.calculateSubtotal();
            total = total + item.getTotalAmount();
        }
        invoice.setTotalAmount(total);
        return saleInvoiceRepo.save(invoice);


    }




}
