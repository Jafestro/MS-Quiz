package az.big3.ms_quiz.service;

import az.big3.ms_quiz.client.trivia_api.model.Root;
import az.big3.ms_quiz.client.trivia_api.TriviaClient;
import az.big3.ms_quiz.entity.QuestionEntity;
import az.big3.ms_quiz.model.Quiz;
import az.big3.ms_quiz.model.QuizQuestion;
import az.big3.ms_quiz.model.Submit;
import az.big3.ms_quiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class QuizService {
    private final TriviaClient client;
    private final QuestionRepository repository;

    public QuizService(TriviaClient client, QuestionRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public Quiz getScienceQuestion() {
        return getQuestions(client.getScienceQuestion());
    }

    public Quiz getFilmQuestion() {
        return getQuestions(client.getFilmQuestion());
    }

    public Quiz getGeneralKnowledgeQuestion() {
        return getQuestions(client.getGeneralKnowledgeQuestion());
    }

    public Quiz getHistoryQuestion() {
        return getQuestions(client.getHistoryQuestion());
    }

    public Quiz getMusicQuestion() {
        return getQuestions(client.getMusicQuestion());
    }

    public List<Boolean> submit(List<Submit> submits) {
        List<Boolean> correctWrong = new ArrayList<>();
        for (Submit submit: submits) {
                var entity = repository.findById(submit.getQuestionId())
                        .orElseThrow(() -> new RuntimeException("Question_does_not_exist!"));
                if (entity.getCorrectAnswerIndex() == submit.getAnswerIndex())
                    correctWrong.add(Boolean.TRUE);
                else
                    correctWrong.add(Boolean.FALSE);
        }
        return correctWrong;
    }

    private Quiz getQuestions(List<Root> category) {
        List<QuizQuestion> questions = new ArrayList<>();
        for (Root question : category) {
            List<String> answers = new ArrayList<>(question.getIncorrectAnswers());
            answers.add(question.getCorrectAnswer());
            Collections.shuffle(answers);

            QuestionEntity entity = new QuestionEntity();
            entity.setId(question.getId());
            entity.setCorrectAnswerIndex(answers.indexOf(question.getCorrectAnswer()));
            if (repository.findById(entity.getId()).isPresent()){}
            else
                repository.save(entity);

            questions.add(new QuizQuestion(question.getId(), question.getQuestion(), answers));
        }
        return new Quiz(questions);
    }
}
