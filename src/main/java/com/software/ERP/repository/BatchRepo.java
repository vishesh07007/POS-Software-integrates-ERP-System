package com.software.ERP.repository;

import com.software.ERP.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BatchRepo extends JpaRepository<Batch, Long> {

    List<Batch> findByMedicineId(Long medicineId);              // stock of a medicine
    List<Batch> findByExpiryDateBefore(LocalDate date);         // expiring medicines
    List<Batch> findByCurrentQuantityLessThan(Integer quantity); // low stock alert

}
