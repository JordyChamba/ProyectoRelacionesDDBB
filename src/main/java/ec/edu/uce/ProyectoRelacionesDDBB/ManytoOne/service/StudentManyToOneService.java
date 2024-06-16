package ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.service;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.model.StudentManyToOne;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.repository.StudentManyToOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManyToOneService {

    private final StudentManyToOneRepository studentManyToOneRepository;

    @Autowired
    public StudentManyToOneService(StudentManyToOneRepository studentManyToOneRepository) {
        this.studentManyToOneRepository = studentManyToOneRepository;
    }

    public StudentManyToOne saveStudent(StudentManyToOne studentManyToOne) {
        return studentManyToOneRepository.save(studentManyToOne);
    }

    public List<StudentManyToOne> getAllStudents() {
        return studentManyToOneRepository.findAll();
    }

    public StudentManyToOne getStudentById(Long id) {
        return studentManyToOneRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentManyToOneRepository.deleteById(id);
    }

    public List<StudentManyToOne> getAllStudentsWithGrades() {
        return studentManyToOneRepository.findAllWithGrades();
    }
}

