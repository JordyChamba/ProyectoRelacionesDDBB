package ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Repository;

import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Model.CourseOnetoOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositoryOneToOne extends JpaRepository<CourseOnetoOne, Long> {
}
