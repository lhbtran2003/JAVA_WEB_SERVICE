package liliana.session_2;

import liliana.session_2.repository.ex4.MovieRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Session2Application {

    public static void main(String[] args) {
        SpringApplication.run(Session2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return args -> {
            boolean isExist = movieRepository.existByTitle("b");
            System.out.println("Exist: " + isExist);
        };
    }

}
