package com.software.ERP.repository;

import com.software.ERP.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface BatchRepo extends JpaRepository<Batch, Long> {

    List<Batch> findByMedicineId(Long medicineId);              // stock of a medicine
    List<Batch> findByExpiryDateBefore(LocalDate date);         // expiring medicines
    List<Batch> findByCurrentQuantityLessThan(Integer quantity); // low stock alert

}
