package ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class StudentManyToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "studentManyToOne", cascade = CascadeType.ALL)
    private List<GradeManyToOne> grades;

    // Constructores, getters y setters

    public StudentManyToOne() {
    }

    public StudentManyToOne(Long id, String name, List<GradeManyToOne> grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
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

    public List<GradeManyToOne> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeManyToOne> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "StudentManyToOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

