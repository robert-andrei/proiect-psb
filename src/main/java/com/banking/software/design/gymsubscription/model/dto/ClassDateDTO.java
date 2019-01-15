package com.banking.software.design.gymsubscription.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ClassDateDTO {

    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime time;

    public ClassDateDTO(Long id, String name, LocalDateTime date, LocalDateTime time) {
        this.id = id;
        this.name = name;
        this.date = time.toLocalDate();
        this.time = time.toLocalTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
