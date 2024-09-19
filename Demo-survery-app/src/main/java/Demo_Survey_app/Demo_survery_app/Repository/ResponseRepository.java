package Demo_Survey_app.Demo_survery_app.Repository;

import Demo_Survey_app.Demo_survery_app.Entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findByQuestion_SurveyId(Long surveyId);  // Find all responses for a specific survey
}