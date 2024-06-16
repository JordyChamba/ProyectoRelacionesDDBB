package ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.service;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.model.StudentManyToMany;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.repository.StudentManyToManyRepository;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.repository.CourseManyToManyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManyToManyService {

    @Autowired
    private StudentManyToManyRepository studentManyToManyRepository;

    @Autowired
    private CourseManyToManyRepository courseManyToManyRepository;

    public List<StudentManyToMany> getAllStudents() {
        return studentManyToManyRepository.findAll();
    }

    public StudentManyToMany getStudentById(Long id) {
        return studentManyToManyRepository.findById(id).orElse(null);
    }

    public StudentManyToMany createStudent(StudentManyToMany studentManyToMany) {
        // Guardar los cursos asociados si no existen en la base de datos
        studentManyToMany.getCourses().forEach(course -> {
            if (course.getId() == null) {
                course = courseManyToManyRepository.save(course);
            }
        });
        // Guardar el estudiante
        return studentManyToManyRepository.save(studentManyToMany);
    }

    public void deleteStudent(Long id) {
        studentManyToManyRepository.deleteById(id);
    }

    public List<StudentManyToMany> getAllStudentsWithCourses() {
        return studentManyToManyRepository.findAllWithCourses();
    }
}
