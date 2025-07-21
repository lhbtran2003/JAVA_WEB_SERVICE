package liliana.session_6.service;

import liliana.session_6.dto.request.AddEmployeeRequest;
import liliana.session_6.dto.request.UpdateEmployeeRequest;
import liliana.session_6.dto.response.DataResponse;
import liliana.session_6.entity.Employee;
import liliana.session_6.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements GenericService<Employee, Integer, UpdateEmployeeRequest, AddEmployeeRequest> {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DataResponse<Employee> create(AddEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setEmail(request.getEmail());
        return DataResponse.<Employee>builder().key("employee").data(employeeRepository.save(employee)).build();
    }

    @Override
    public DataResponse<Employee> update(Integer id, UpdateEmployeeRequest request) {
        if (!employeeRepository.existsById(id)) {
            return null; // mốt ném exception ra đây
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
         employeeRepository.deleteById(id);
    }

    @Override
    public DataResponse<Employee> findById(Integer id) {
        return DataResponse.<Employee>builder().key("employee").data(employeeRepository.findById(id).get()).build();
    }

    @Override
    public DataResponse<List<Employee>> findAll() {
        return DataResponse.<List<Employee>>builder().key("employee").data(employeeRepository.findAll()).build();
    }
}
