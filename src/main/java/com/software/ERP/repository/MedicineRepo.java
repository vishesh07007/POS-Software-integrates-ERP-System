package com.software.ERP.repository;

import com.software.ERP.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Long> {

    List<Medicine> findByNameContainingIgnoreCase(String name);

    List<Medicine> findByCategory(String category);

    List<Medicine> findByManufacturer(String manufacturer);

    Medicine findByCode(String code);

}
