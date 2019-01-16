package com.banking.software.design.gymsubscription.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "username", nullable = false, length = 30)
    @Length(min = 5, max = 30)
    private String username;

    @Column(name = "password", nullable = false, length = 32)
    @Length(min = 5, max = 32)
    private String password;

    @Column(name = "name", nullable = false, length = 50)
    @Length(max = 50)
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Booking> bookings = new HashSet<>();

    public Customer() {
    }

    public Customer(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getCustomername() {
        return username;
    }

    public void setCustomername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(username, customer.username) && Objects.equals(password, customer.password) && Objects.equals(name, customer.name);
    }

    @Override public int hashCode() {
        return Objects.hash(username, password, name);
    }

    @Override public String toString() {
        return "Customer{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + '}';
    }
}
