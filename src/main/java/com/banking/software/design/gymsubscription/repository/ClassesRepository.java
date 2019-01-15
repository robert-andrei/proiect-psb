package com.banking.software.design.gymsubscription.repository;

import com.banking.software.design.gymsubscription.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, String> {

    @Query(value = "SELECT distinct(c.class_name) FROM classes c", nativeQuery = true)
    Optional<List<String>> getAllClassnames();
}
