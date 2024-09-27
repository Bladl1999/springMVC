package ru.vladislav.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "emploees")
public class Emploee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emploee_id")
    private long id;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Emploee_Project",
            joinColumns = { @JoinColumn(name = "emploee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") })
    private Set<Project> projects;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    public Emploee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
