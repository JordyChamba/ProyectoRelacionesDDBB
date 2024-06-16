package ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.repository;

import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.model.GradeOnetoMany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepositoryOnetoMany extends JpaRepository<GradeOnetoMany, Long> {
}
