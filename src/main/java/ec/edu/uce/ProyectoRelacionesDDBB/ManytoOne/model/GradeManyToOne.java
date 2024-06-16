package ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.model;

import jakarta.persistence.*;

@Entity
public class GradeManyToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentManyToOne studentManyToOne;

    // Constructores, getters y setters

    public GradeManyToOne() {
    }

    public GradeManyToOne(Long id, String courseName, double value, StudentManyToOne studentManyToOne) {
        this.id = id;
        this.courseName = courseName;
        this.value = value;
        this.studentManyToOne = studentManyToOne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public StudentManyToOne getStudentManyToOne() {
        return studentManyToOne;
    }

    public void setStudentManyToOne(StudentManyToOne studentManyToOne) {
        this.studentManyToOne = studentManyToOne;
    }

    @Override
    public String toString() {
        return "GradeManyToOne{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", value=" + value +
                ", studentManyToOne=" + (studentManyToOne != null ? studentManyToOne.getName() : null) +
                '}';
    }
}

