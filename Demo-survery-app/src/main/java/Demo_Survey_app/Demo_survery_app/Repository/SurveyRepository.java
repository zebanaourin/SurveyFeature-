package Demo_Survey_app.Demo_survery_app.Repository;

import Demo_Survey_app.Demo_survery_app.Entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
