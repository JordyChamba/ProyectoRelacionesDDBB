package ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.model;

import jakarta.persistence.*;

@Entity
public class GradeOnetoMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentOnetoMany studentOnetoMany;

    // Constructor vacío
    public GradeOnetoMany() {
    }

    // Constructor con todos los campos
    public GradeOnetoMany(Long id, String courseName, double value, StudentOnetoMany studentOnetoMany) {
        this.id = id;
        this.courseName = courseName;
        this.value = value;
        this.studentOnetoMany = studentOnetoMany;
    }

    // Getters y Setters
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

    public StudentOnetoMany getStudentOnetoMany() {
        return studentOnetoMany;
    }

    public void setStudentOnetoMany(StudentOnetoMany studentOnetoMany) {
        this.studentOnetoMany = studentOnetoMany;
    }

    @Override
    public String toString() {
        return "GradeOnetoMany{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", value=" + value +
                ", studentOnetoMany=" + (studentOnetoMany != null ? studentOnetoMany.getName() : null) +
                '}';
    }
}
