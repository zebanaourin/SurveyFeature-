package Demo_Survey_app.Demo_survery_app.Repository;


import Demo_Survey_app.Demo_survery_app.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}