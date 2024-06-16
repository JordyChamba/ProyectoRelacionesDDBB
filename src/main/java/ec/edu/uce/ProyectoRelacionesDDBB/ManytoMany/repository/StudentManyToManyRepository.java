package ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.repository;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.model.StudentManyToMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentManyToManyRepository extends JpaRepository<StudentManyToMany, Long> {

    @Query("SELECT DISTINCT s FROM StudentManyToMany s JOIN FETCH s.courses")
    List<StudentManyToMany> findAllWithCourses();
}
