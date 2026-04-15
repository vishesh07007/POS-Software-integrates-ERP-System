package com.software.ERP.repository;

import com.software.ERP.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    Optional<Customer> findByPhone(String phone);
    List<Customer> findByNameContainingIgnoreCase(String name);

}
