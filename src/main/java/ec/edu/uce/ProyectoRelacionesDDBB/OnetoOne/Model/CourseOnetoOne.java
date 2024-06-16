package ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Model;

import jakarta.persistence.*;

@Entity
public class CourseOnetoOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentOnetoOne studentOnetoOne;

    // Constructor vacío
    public CourseOnetoOne() {
    }

    // Constructor con todos los campos
    public CourseOnetoOne(Long id, String name, StudentOnetoOne studentOnetoOne) {
        this.id = id;
        this.name = name;
        this.studentOnetoOne = studentOnetoOne;
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

    public StudentOnetoOne getStudentOnetoOne() {
        return studentOnetoOne;
    }

    public void setStudentOnetoOne(StudentOnetoOne studentOnetoOne) {
        this.studentOnetoOne = studentOnetoOne;
    }

    @Override
    public String toString() {
        return "CourseOnetoOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentOnetoOne=" + (studentOnetoOne != null ? studentOnetoOne.getName() : null) +
                '}';
    }
}
