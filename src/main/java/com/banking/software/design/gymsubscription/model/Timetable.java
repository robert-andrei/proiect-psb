package com.banking.software.design.gymsubscription.model;

import com.banking.software.design.gymsubscription.util.LocalDateTimeConverter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timetable_id", updatable = false, nullable = false)
    private Long timetableId;

    @Column(name = "class_name", nullable = false, length = 25)
    @Length(max = 25)
    private String className;

    @Column(name = "date_and_time")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime dateAndTime;

    @OneToMany(mappedBy = "timetable",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                orphanRemoval = true)
    private Set<Classes> classes;

    @OneToMany(mappedBy = "timetable",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();

    public Timetable() {
    }

    public Timetable(String className, LocalDateTime dateAndTime) {
        this.className = className;
        this.dateAndTime = dateAndTime;
    }

    public Long getId() {
        return timetableId;
    }

    public void setId(Long timetableId) {
        this.timetableId = timetableId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(timetableId, timetable.timetableId) && Objects.equals(className, timetable.className) && Objects.equals(dateAndTime, timetable.dateAndTime);
    }

    @Override public int hashCode() {
        return Objects.hash(timetableId, className, dateAndTime);
    }

    @Override public String toString() {
        return "Timetable{" + "timetableId=" + timetableId + ", className='" + className + '\'' + ", dateAndTime=" + dateAndTime + '}';
    }
}
