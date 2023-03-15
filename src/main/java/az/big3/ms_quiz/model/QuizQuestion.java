package az.big3.ms_quiz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizQuestion {
    private String id;
    private String question;
    private List<String> answers;
    //private int correctAnswerIndex;
}
