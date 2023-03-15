package az.big3.ms_quiz.client.trivia_api;

import az.big3.ms_quiz.client.trivia_api.model.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "trivia-api",
        url = "https://the-trivia-api.com/api")
public interface TriviaClient {
    @GetMapping("/questions?categories=science&limit=10")
    List<Root> getScienceQuestion();
    @GetMapping("/questions?categories=film_and_tv&limit=10")
    List<Root> getFilmQuestion();
    @GetMapping("/questions?categories=general_knowledge&limit=10")
    List<Root> getGeneralKnowledgeQuestion();
    @GetMapping("/questions?categories=history&limit=10")
    List<Root> getHistoryQuestion();
    @GetMapping("/questions?categories=music&limit=10")
    List<Root> getMusicQuestion();
}
