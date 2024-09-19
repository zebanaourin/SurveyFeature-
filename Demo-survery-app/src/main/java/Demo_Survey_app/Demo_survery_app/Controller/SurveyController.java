package Demo_Survey_app.Demo_survery_app.Controller;


import Demo_Survey_app.Demo_survery_app.Entity.Response;
import Demo_Survey_app.Demo_survery_app.Entity.Survey;
import Demo_Survey_app.Demo_survery_app.Service.ResponseService;
import Demo_Survey_app.Demo_survery_app.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")  // Allow Angular frontend to access the API
@RequestMapping("/api/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private ResponseService responseService;

    // 1. Get Survey Questions
    @GetMapping("/{id}")
    public Survey getSurvey(@PathVariable Long id) {
        // Fetch the survey with its questions
        return surveyService.getSurvey(id);
    }

    // 2. Submit Answers
    @PostMapping("/{id}/submit")
    public ResponseEntity<Map<String, String>> submitSurvey(@PathVariable Long id, @RequestBody List<String> answers) {
        Survey survey = surveyService.getSurvey(id);

        if (answers.size() != survey.getQuestions().size()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Number of answers does not match the number of questions.");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        for (int i = 0; i < survey.getQuestions().size(); i++) {
            Response response = new Response();
            response.setAnswer(answers.get(i));
            response.setQuestion(survey.getQuestions().get(i));

            responseService.saveResponse(response);
        }

        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "Survey submitted successfully!");
        return ResponseEntity.ok(successResponse);
    }




    // 3. Get User's Responses (Results)
    @GetMapping("/{id}/results")
    public List<Response> getSurveyResults(@PathVariable Long id) {
        // Fetch all responses to the survey
        return responseService.getResponsesForSurvey(id);
    }



}
