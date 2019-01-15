package com.banking.software.design.gymsubscription.repository;

import com.banking.software.design.gymsubscription.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
