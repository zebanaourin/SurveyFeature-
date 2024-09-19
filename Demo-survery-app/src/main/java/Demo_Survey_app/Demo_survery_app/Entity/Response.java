package Demo_Survey_app.Demo_survery_app.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;  // The answer provided by the user

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;  // Which question this response belongs to

    // Getters and Setters
}
