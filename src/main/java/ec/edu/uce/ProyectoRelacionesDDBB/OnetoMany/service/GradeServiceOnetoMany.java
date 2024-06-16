package ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.service;

import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.model.GradeOnetoMany;
import ec.edu.uce.ProyectoRelacionesDDBB.OnetoMany.repository.GradeRepositoryOnetoMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GradeServiceOnetoMany {

    private final GradeRepositoryOnetoMany gradeRepository;

    @Autowired
    public GradeServiceOnetoMany(GradeRepositoryOnetoMany gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void saveGrade(GradeOnetoMany grade) {
        gradeRepository.save(grade);
    }
}
