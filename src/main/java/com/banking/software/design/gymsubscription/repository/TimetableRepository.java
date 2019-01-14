package com.banking.software.design.gymsubscription.repository;

import com.banking.software.design.gymsubscription.model.LoginSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<LoginSession, Long> {
}
