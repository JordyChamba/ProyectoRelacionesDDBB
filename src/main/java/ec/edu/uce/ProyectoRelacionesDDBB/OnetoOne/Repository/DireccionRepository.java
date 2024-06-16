package ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Repository;


import ec.edu.uce.ProyectoRelacionesDDBB.OnetoOne.Model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
