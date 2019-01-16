package com.banking.software.design.gymsubscription.model;

import com.banking.software.design.gymsubscription.util.Difficulty;
import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "classes")
@Check(constraints = "difficulty >= 0 AND difficulty <= 5")
public class Classes {

    @Id
    @Column(name = "class_name", updatable = false, nullable = false, length = 25)
    @Length(max = 25)
    private String className;

    @Column(name = "coach_name", length = 40)
    @Length(max = 40)
    private String coachName;

    @Column(name = "description", length = 100)
    @Length(max = 100)
    private String description;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Timetable timetable;

    public Classes() {
    }

    public Classes(String name, String coachName, String description, Difficulty difficulty) {
        this.className = name;
        this.coachName = coachName;
        this.description = description;
        this.difficulty = difficulty;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String name) {
        this.className = name;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Classes classes = (Classes) o;
        return Objects.equals(className, classes.className) && Objects.equals(coachName, classes.coachName) && Objects.equals(description, classes.description)
                && difficulty == classes.difficulty;
    }

    @Override public int hashCode() {
        return Objects.hash(className, coachName, description, difficulty);
    }

    @Override public String toString() {
        return "Classes{" + "className='" + className + '\'' + ", coachName='" + coachName + '\'' + ", description='" + description + '\'' + ", difficulty=" + difficulty
                + '}';
    }
}
