package ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.repository;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.model.StudentManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentManyToOneRepository extends JpaRepository<StudentManyToOne, Long> {

    @Query("SELECT DISTINCT s FROM StudentManyToOne s LEFT JOIN FETCH s.grades")
    List<StudentManyToOne> findAllWithGrades();
}
