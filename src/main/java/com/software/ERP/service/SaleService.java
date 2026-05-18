package com.software.ERP.service;

import com.software.ERP.entities.Batch;
import com.software.ERP.entities.SaleInvoice;
import com.software.ERP.entities.SaleItem;
import com.software.ERP.repository.BatchRepo;
import com.software.ERP.repository.SaleInvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;  

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private SaleInvoiceRepo saleInvoiceRepo;

    @Transactional
    public SaleInvoice createSale(SaleInvoice invoice) {

        invoice.setInvoiceNumber("INV-" + System.currentTimeMillis());
        invoice.setSaleDate(LocalDate.now());

        double total = 0;

        for (SaleItem item : invoice.getItems()) {

            List<Batch> batches = batchRepo.findByMedicineId(item.getMedicine().getId());

            if (batches.isEmpty()) {
                throw new RuntimeException("No stock found for medicine: " + item.getMedicine().getName());
            }

            Batch batch = batches.get(0);

            if (batch.getCurrentQuantity() < item.getQuantity()) {
                throw new RuntimeException("Not enough stock! Available: " +
                        batch.getCurrentQuantity() + ", Requested: " + item.getQuantity());
            }

            if (batch.getExpiryDate().isBefore(LocalDate.now())) {
                throw new RuntimeException("Batch is expired! Expiry date: " + batch.getExpiryDate());
            }

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

    public List<SaleInvoice> getAllSales() {
        return saleInvoiceRepo.findAll();
    }
}