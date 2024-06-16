package ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.model;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StudentManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Student_Course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private Set<CourseManyToMany> courses = new HashSet<>();

    // Constructor
    public StudentManyToMany() {
    }

    public StudentManyToMany(String name) {
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

    public Set<CourseManyToMany> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseManyToMany> courses) {
        this.courses = courses;
    }

    // toString
    @Override
    public String toString() {
        return "StudentManyToMany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}