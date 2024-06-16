package ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.service;

import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.model.StudentOnetoMany;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.repository.StudentRepositoryOnetoMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceOnetoMany {

    private final StudentRepositoryOnetoMany studentRepository;

    @Autowired
    public StudentServiceOnetoMany(StudentRepositoryOnetoMany studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentOnetoMany> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentOnetoMany getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id));
    }

    public void saveStudent(StudentOnetoMany student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentOnetoMany> getAllStudentsWithGrades() {
        return studentRepository.findAllWithGrades();
    }
}
