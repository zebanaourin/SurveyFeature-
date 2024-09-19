package Demo_Survey_app.Demo_survery_app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;  // Title of the survey

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<Question> questions;  // Survey contains multiple questions

    // Getters and Setters
}