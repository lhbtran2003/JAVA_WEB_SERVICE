package liliana.session_3.repository;

import liliana.session_3.dto.EmployeeDTO;
import liliana.session_3.entity.Employee;
import liliana.session_3.interfaceProjection.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByPhoneNumber(String phoneNumber);

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> findEmployeeBySalary(@Param("salary") double salary);

    @Query("SELECT new liliana.session_3.dto.EmployeeDTO(e.name,e.email,e.phoneNumber,e.salary) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTO();

    List<EmployeeInfo> findBy();
}
