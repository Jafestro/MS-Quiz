package az.big3.ms_quiz.client.trivia_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root{
    public String category;
    public String id;
    public String correctAnswer;
    public ArrayList<String> incorrectAnswers;
    public String question;
    public ArrayList<String> tags;
    public String type;
    public String difficulty;
    public ArrayList<Object> regions;
    public boolean isNiche;
}
