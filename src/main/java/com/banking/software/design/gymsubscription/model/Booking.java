package com.banking.software.design.gymsubscription.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    @Id
    @Column(columnDefinition = "bigserial", name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edge_id_generator")
    protected Long id;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "customer")
    private Customer customer;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "timetable")
    private Timetable timetable;

    public Booking() {
    }

    public Booking(Customer customer, Timetable timetable) {
        this.customer = customer;
        this.timetable = timetable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(customer, booking.customer) && Objects.equals(timetable, booking.timetable);
    }

    @Override public int hashCode() {
        return Objects.hash(id, customer, timetable);
    }

    @Override public String toString() {
        return "Booking{" + "id=" + id + ", customer=" + customer + ", timetable=" + timetable + '}';
    }
}
