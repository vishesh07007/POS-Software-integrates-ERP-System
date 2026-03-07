package com.software.ERP.repository;


import com.software.ERP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);  // for login
    User findByPhone(String phone);
    List<User> findByRole(String role);    // get all admins, pharmacists etc

}
