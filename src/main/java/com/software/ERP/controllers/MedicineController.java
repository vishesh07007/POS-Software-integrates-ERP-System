package com.software.ERP.controllers;

import com.software.ERP.entities.Medicine;
import com.software.ERP.repository.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")

public class MedicineController {

    @Autowired
    private MedicineRepo medicineRepo;

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineRepo.findAll();
    }

    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    @GetMapping("/{id}")
    public Medicine getMedicine(@PathVariable Long id){
        return medicineRepo.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Medicine> searchByName(@RequestParam String name){
        return medicineRepo.findByNameContainingIgnoreCase(name);
    }

    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable Long id){
        medicineRepo.deleteById(id);
        return "Deleted medicine: " + id;
    }


}
