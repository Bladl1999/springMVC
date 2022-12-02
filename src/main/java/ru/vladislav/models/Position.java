package ru.vladislav.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private long salary;

    @OneToMany()
    @JoinColumn(name = "emploee_id")
    private Set<Emploee> emploee;

    public Position() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Set<Emploee> getEmploee() {
        return emploee;
    }

    public void setEmploee(Set<Emploee> emploee) {
        this.emploee = emploee;
    }
}
