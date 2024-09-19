package Demo_Survey_app.Demo_survery_app.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;  // The question itself

    @ManyToOne
    @JoinColumn(name = "survey_id")
    @JsonBackReference
    private Survey survey;  // Link back to the Survey

    // Getters and Setters
}
