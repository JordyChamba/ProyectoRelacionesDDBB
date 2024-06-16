package ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.repository;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.model.GradeManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeManyToOneRepository extends JpaRepository<GradeManyToOne, Long> {
}

