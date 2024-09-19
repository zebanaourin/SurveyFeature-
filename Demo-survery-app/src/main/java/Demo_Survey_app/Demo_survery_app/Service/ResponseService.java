package Demo_Survey_app.Demo_survery_app.Service;


import Demo_Survey_app.Demo_survery_app.Entity.Response;
import Demo_Survey_app.Demo_survery_app.Repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    // Save a response
    public void saveResponse(Response response) {
        responseRepository.save(response);
    }

    // Get all responses for a survey
    public List<Response> getResponsesForSurvey(Long surveyId) {
        return responseRepository.findByQuestion_SurveyId(surveyId);
    }
}

