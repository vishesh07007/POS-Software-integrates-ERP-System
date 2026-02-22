package com.software.ERP.controllers;

import com.software.ERP.repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class medicineController {

    @Autowired
    private MedicineRepo medicineRepository;



}
