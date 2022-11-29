package ru.vladislav.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long id;

    @Column
    private String name;

    //N...N
    @ManyToOne()
    @JoinColumn(name="cutomer_id", nullable=false)
    private Customer customer;

    //N....1
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Emploee_Project",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "emploee_id") })
    @JoinColumn(name = "emploee_id")
    private Set<Emploee> emploees;

    public Project() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Emploee> getEmploees() {
        return emploees;
    }

    public void setEmploees(Set<Emploee> emploees) {
        this.emploees = emploees;
    }
}
