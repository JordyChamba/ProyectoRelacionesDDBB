package ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.repository;

import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.model.StudentOnetoMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepositoryOnetoMany extends JpaRepository<StudentOnetoMany, Long> {

    @Query("SELECT s FROM StudentOnetoMany s JOIN FETCH s.grades")
    List<StudentOnetoMany> findAllWithGrades();
}

