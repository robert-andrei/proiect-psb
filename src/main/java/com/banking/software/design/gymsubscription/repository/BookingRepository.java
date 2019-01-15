package com.banking.software.design.gymsubscription.repository;

import com.banking.software.design.gymsubscription.model.Booking;
import com.banking.software.design.gymsubscription.model.Customer;
import com.banking.software.design.gymsubscription.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM booking b where b.customer = :customer and b.timetable = :timetable", nativeQuery = true)
    Optional<Booking> getBookingByCustomerAndTimetable(@Param("customer") Customer customer, @Param("timetable") Timetable timetable);
}
