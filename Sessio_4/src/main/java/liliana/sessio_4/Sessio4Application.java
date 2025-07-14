package liliana.sessio_4;

import liliana.sessio_4.entity.ex1.Book;
import liliana.sessio_4.service.ex1.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sessio4Application {

    public static void main(String[] args) {
        SpringApplication.run(Sessio4Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookService bookService) {
        return args -> {
            for (Book book : bookService.findAll(0)) {
                System.out.println(book);
            };
        };
    }

}
