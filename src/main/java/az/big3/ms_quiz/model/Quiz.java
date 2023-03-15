package az.big3.ms_quiz.model;


import az.big3.ms_quiz.model.QuizQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {
    private List<QuizQuestion> questions;
}
