package ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Model;

import jakarta.persistence.*;

@Entity
public class StudentOnetoOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "studentOnetoOne", cascade = CascadeType.ALL)
    private CourseOnetoOne courseOnetoOne;

    // Constructor vacío
    public StudentOnetoOne() {
    }

    // Constructor con todos los campos
    public StudentOnetoOne(Long id, String name, CourseOnetoOne courseOnetoOne) {
        this.id = id;
        this.name = name;
        this.courseOnetoOne = courseOnetoOne;
    }

    // Getters y Setters
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

    public CourseOnetoOne getCourseOnetoOne() {
        return courseOnetoOne;
    }

    public void setCourseOnetoOne(CourseOnetoOne courseOnetoOne) {
        this.courseOnetoOne = courseOnetoOne;
    }

    @Override
    public String toString() {
        return "StudentOnetoOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseOnetoOne=" + (courseOnetoOne != null ? courseOnetoOne.getName() : null) +
                '}';
    }
}
