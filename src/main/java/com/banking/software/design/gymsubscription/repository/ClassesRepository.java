package com.banking.software.design.gymsubscription.repository;

import com.banking.software.design.gymsubscription.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, String> {
}
