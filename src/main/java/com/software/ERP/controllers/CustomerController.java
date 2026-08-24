package com.software.ERP.controllers;

import com.software.ERP.entities.Customer;
import com.software.ERP.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerRepo.findById(id).orElse(null);
    }


}
