package ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Service;

import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Model.StudentOnetoOne;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Model.CourseOnetoOne;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Repository.StudentRepositoryOneToOne;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Repository.CourseRepositoryOneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceOneToOne {

    @Autowired
    private StudentRepositoryOneToOne studentRepositoryOneToOne;

    @Autowired
    private CourseRepositoryOneToOne courseRepositoryOneToOne;

    // Crear un nuevo estudiante
    public StudentOnetoOne createStudent(StudentOnetoOne studentOnetoOne) {
        return studentRepositoryOneToOne.save(studentOnetoOne);
    }

    // Obtener todos los estudiantes
    public List<StudentOnetoOne> getAllStudents() {
        return studentRepositoryOneToOne.findAll();
    }

    // Añadir un curso a un estudiante
    public StudentOnetoOne addCourseToStudent(Long studentId, Long courseId) {
        StudentOnetoOne studentOnetoOne = studentRepositoryOneToOne.findById(studentId).orElseThrow();
        CourseOnetoOne courseOnetoOne = courseRepositoryOneToOne.findById(courseId).orElseThrow();
        studentOnetoOne.setCourseOnetoOne(courseOnetoOne);
        courseOnetoOne.setStudentOnetoOne(studentOnetoOne);
        studentRepositoryOneToOne.save(studentOnetoOne);
        courseRepositoryOneToOne.save(courseOnetoOne);
        return studentOnetoOne;
    }
}
