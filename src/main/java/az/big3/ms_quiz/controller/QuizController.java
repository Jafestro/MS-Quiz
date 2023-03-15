package az.big3.ms_quiz.controller;

import az.big3.ms_quiz.client.trivia_api.TriviaClient;
import az.big3.ms_quiz.client.trivia_api.model.Root;


import az.big3.ms_quiz.model.Quiz;
import az.big3.ms_quiz.model.Submit;
import az.big3.ms_quiz.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/science")
    public Quiz getScienceQuestion(){
        return service.getScienceQuestion();
    }

    @GetMapping("/film")
    public Quiz getFilmQuestion() {
        return service.getFilmQuestion();
    }

    @GetMapping("/general")
    public Quiz getGeneralKnowledgeQuestion() {
        return service.getGeneralKnowledgeQuestion();
    }

    @GetMapping("/history")
    public Quiz getHistoryQuestion() {
        return service.getHistoryQuestion();
    }

    @GetMapping("/music")
    public Quiz getMusicQuestion() {
        return service.getMusicQuestion();
    }

    @PostMapping("/submit")
    public List<Boolean> submit(@RequestBody List<Submit> submit){
        return service.submit(submit);
    }
}
