package az.big3.ms_quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsQuizApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsQuizApplication.class, args);
    }

}
