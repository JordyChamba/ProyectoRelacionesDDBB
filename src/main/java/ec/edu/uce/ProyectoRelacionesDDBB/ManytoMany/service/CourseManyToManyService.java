package ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.service;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.model.CourseManyToMany;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.repository.CourseManyToManyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseManyToManyService {
    @Autowired
    private CourseManyToManyRepository courseManyToManyRepository;

    public List<CourseManyToMany> getAllCourses() {
        return courseManyToManyRepository.findAll();
    }

    public CourseManyToMany getCourseById(Long id) {
        return courseManyToManyRepository.findById(id).orElse(null);
    }

    public CourseManyToMany createCourse(CourseManyToMany courseManyToMany) {
        return courseManyToManyRepository.save(courseManyToMany);
    }

    public void deleteCourse(Long id) {
        courseManyToManyRepository.deleteById(id);
    }
}
