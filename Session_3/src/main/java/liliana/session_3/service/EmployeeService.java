package liliana.session_3.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import liliana.session_3.dto.EmployeeDTO;
import liliana.session_3.entity.Employee;
import liliana.session_3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> findAllWithPageAndSort(int pageNumber, int pageSize, String sortField, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortField);
        Pageable pageable = PageRequest.of(pageNumber,pageSize, sort);
        return employeeRepository.findAll(pageable);
    }

    public Employee findWithPhoneNumber(String phoneNumber) {
        return employeeRepository.findByPhoneNumber(phoneNumber);
    }

    public List<EmployeeDTO> findAllEmployeeDTO() {
        return employeeRepository.findAllEmployeeDTO();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee with id " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }
}
