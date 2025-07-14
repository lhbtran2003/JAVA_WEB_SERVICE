package liliana.session_3;

import liliana.session_3.dto.EmployeeDTO;
import liliana.session_3.entity.Employee;
import liliana.session_3.interfaceProjection.EmployeeInfo;
import liliana.session_3.repository.EmployeeRepository;
import liliana.session_3.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Session3Application {

    public static void main(String[] args) {
        SpringApplication.run(Session3Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        return args -> {
//
//           employeeService.saveEmployee(new Employee(null,"haha","haha@gmail.com", "0192744722", 30, LocalDate.now()));
        };
    }

}
