package com.software.ERP.service;


import com.software.ERP.entities.Medicine;
import com.software.ERP.repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;

    public List<Medicine> findAll(){
        return medicineRepo.findAll();

    }

    public Medicine getMedicine(Long id){
        return medicineRepo.findById(id).orElse(null);
    }

    public Medicine addMedicine(Medicine medicine){

        Medicine existingMedicine = medicineRepo.findByCode(medicine.getCode());
        if(existingMedicine != null){
            throw new RuntimeException("Medicine with code " + medicine.getCode() + " already exists");
        }

        medicine.setName(medicine.getName().toUpperCase());

        return medicineRepo.save(medicine);
    }



}
