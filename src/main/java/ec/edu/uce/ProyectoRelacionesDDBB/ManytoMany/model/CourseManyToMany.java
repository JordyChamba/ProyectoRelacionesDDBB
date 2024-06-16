package ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CourseManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Course_Student_ManyToMany",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private Set<StudentManyToMany> students = new HashSet<>();

    // Constructor
    public CourseManyToMany() {
    }

    public CourseManyToMany(String name) {
        this.name = name;
    }

    // Getters and Setters
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

    public Set<StudentManyToMany> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentManyToMany> students) {
        this.students = students;
    }

    // toString
    @Override
    public String toString() {
        return "CourseManyToMany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
