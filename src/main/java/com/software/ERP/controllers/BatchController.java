package com.software.ERP.controllers;


import com.software.ERP.entities.Batch;
import com.software.ERP.repository.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    @Autowired
    private BatchRepo batchRepo;

    @GetMapping
    public List<Batch> getExpiringBatches(){
        return batchRepo.findByExpiryDateBefore(LocalDate.now().plusDays(30));
    }

    @GetMapping("/low-stock")
    public List<Batch> getLowStock() {
        return batchRepo.findByCurrentQuantityLessThan(10);
    }


}
