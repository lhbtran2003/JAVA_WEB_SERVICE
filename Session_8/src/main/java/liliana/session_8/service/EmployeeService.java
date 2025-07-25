package liliana.session_8.service;

import liliana.session_8.dto.response.ApiResponse;
import liliana.session_8.entity.Employee;
import liliana.session_8.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeService {
     private final EmployeeRepository employeeRepository;
     private final CloudinaryService cloudinaryService;

     public ApiResponse<List<Employee>> getAllEmployees() {
      return ApiResponse.<List<Employee>>builder()
              .data(employeeRepository.findAll())
              .message("Danh sách nhân viên")
              .status(true)
              .build();
     }

     public ApiResponse<Employee> getEmployeeById(Long id) {
         return employeeRepository.findById(id)
                 .map(employee -> ApiResponse.<Employee>builder()
                         .data(employee)
                         .message("Nhân viên theo id = "+id)
                         .build())
                 .orElse(ApiResponse.<Employee>builder()
                         .data(null)
                         .status(false)
                         .message("Không tìm thấy nhân viên với id = "+id)
                         .build());
     }

     public ApiResponse<Employee> createEmployee(Employee employee) {
         return ApiResponse.<Employee>builder()
                 .data(employeeRepository.save(employee))
                 .message("Thêm thành công nhân viên")
                 .status(true)
                 .build();
     }

     public ApiResponse<Employee> updateEmployee(Long id, Employee employee) throws NoSuchElementException {
         Employee existEmployee = employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);

         existEmployee.setAddress(employee.getAddress());
         existEmployee.setFullName(employee.getFullName());
         existEmployee.setPosition(employee.getPosition());
         existEmployee.setSalary(employee.getSalary());
         return ApiResponse.<Employee>builder()
                 .data(employeeRepository.save(existEmployee))
                 .status(true)
                 .message("Cập nhật thành công nhân viên có id = " + id)
                 .build();
     }

     public ApiResponse<Void> deleteEmployee(Long id) {
         employeeRepository.deleteById(id);
         return ApiResponse.<Void>builder().status(true).build();
     }
}
