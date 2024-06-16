package ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class StudentOnetoMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "studentOnetoMany", cascade = CascadeType.ALL)
    private List<GradeOnetoMany> grades;

    // Constructor vacío
    public StudentOnetoMany() {
    }

    // Constructor con todos los campos
    public StudentOnetoMany(Long id, String name, List<GradeOnetoMany> grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
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

    public List<GradeOnetoMany> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeOnetoMany> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StudentOnetoMany{id=").append(id);
        stringBuilder.append(", name='").append(name).append('\'');
        stringBuilder.append(", grades=").append(grades != null ? grades.toString() : "[]");
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}
