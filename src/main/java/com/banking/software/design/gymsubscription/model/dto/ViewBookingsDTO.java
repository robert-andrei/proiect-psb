package com.banking.software.design.gymsubscription.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class ViewBookingsDTO {

    private String name;
    private String className;
    private LocalDate date;
    private LocalTime time;

    public ViewBookingsDTO(String name, String className, LocalDateTime date, LocalDateTime time) {
        this.name = name;
        this.className = className;
        this.date = date.toLocalDate();
        this.time = time.toLocalTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ViewBookingsDTO that = (ViewBookingsDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(className, that.className) && Objects.equals(date, that.date) && Objects
                .equals(time, that.time);
    }

    @Override public int hashCode() {
        return Objects.hash(name, className, date, time);
    }

    @Override public String toString() {
        return "ViewBookingsDTO{" + "name='" + name + '\'' + ", className='" + className + '\'' + ", date=" + date + ", time=" + time + '}';
    }
}
