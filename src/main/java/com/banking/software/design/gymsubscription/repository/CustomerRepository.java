package com.banking.software.design.gymsubscription.repository;

import com.banking.software.design.gymsubscription.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
