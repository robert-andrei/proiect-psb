package com.banking.software.design.gymsubscription.repository;

import com.banking.software.design.gymsubscription.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    @Query(value = "SELECT * from timetable t where date(t.date_and_time) = cast(:date AS date)", nativeQuery = true)
    Optional<List<Timetable>> getClassesOnDate(@Param("date") String date);

    @Query(value = "SELECT * from timetable t where t.class_name = :classname", nativeQuery = true)
    Optional<List<Timetable>> getDateForClass(@Param("classname") String classname);
}
