package ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.service;

import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.model.GradeManyToOne;
import ec.edu.uce.ProyectoRelacionesDDBB.ManytoOne.repository.GradeManyToOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GradeManyToOneService {

    private final GradeManyToOneRepository gradeManyToOneRepository;

    @Autowired
    public GradeManyToOneService(GradeManyToOneRepository gradeManyToOneRepository) {
        this.gradeManyToOneRepository = gradeManyToOneRepository;
    }

    public GradeManyToOne saveGrade(GradeManyToOne gradeManyToOne) {
        return gradeManyToOneRepository.save(gradeManyToOne);
    }

    public List<GradeManyToOne> getAllGrades() {
        return gradeManyToOneRepository.findAll();
    }

    public GradeManyToOne getGradeById(Long id) {
        return gradeManyToOneRepository.findById(id).orElse(null);
    }

    public void deleteGrade(Long id) {
        gradeManyToOneRepository.deleteById(id);
    }
}

