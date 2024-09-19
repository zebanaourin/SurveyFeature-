package Demo_Survey_app.Demo_survery_app.Service;

import Demo_Survey_app.Demo_survery_app.Entity.Survey;
import Demo_Survey_app.Demo_survery_app.Repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    // Retrieve the survey
    public Survey getSurvey(Long id) {
        return surveyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Survey not found"));
    }
}

