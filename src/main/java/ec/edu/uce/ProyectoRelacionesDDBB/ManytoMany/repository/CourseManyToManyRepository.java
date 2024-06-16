package ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.repository;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoMany.model.CourseManyToMany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyRepository extends JpaRepository<CourseManyToMany, Long> {
}

