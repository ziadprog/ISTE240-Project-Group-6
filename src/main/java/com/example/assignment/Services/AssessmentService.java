//Name: Ziad Abdelrahman
//ID: 764002985

package com.example.assignment.Services;


import com.example.assignment.model.SelfAssessment;
import com.example.assignment.Repositories.AssessmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssessmentService {

    private final AssessmentRepository assessmentRepository;

    public AssessmentService(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    public List<SelfAssessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    public SelfAssessment getAssessmentById(Long id) {
        return assessmentRepository.findById(id).orElse(null);
    }

    public List<SelfAssessment> searchByUsername(String username) {
        return assessmentRepository.findByUsernameContaining(username);
    }

    public SelfAssessment createAssessment(SelfAssessment assessment) {
        return assessmentRepository.save(assessment);
    }

    public SelfAssessment updateAssessment(Long id, SelfAssessment assessment) {
        assessment.setId(id);
        return assessmentRepository.save(assessment);
    }

    public void deleteAssessment(Long id) {
        assessmentRepository.deleteById(id);
    }
}
