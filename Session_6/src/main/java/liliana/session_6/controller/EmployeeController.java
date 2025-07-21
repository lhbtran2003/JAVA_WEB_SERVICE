package liliana.session_6.controller;

import liliana.session_6.dto.request.AddEmployeeRequest;
import liliana.session_6.dto.request.UpdateEmployeeRequest;
import liliana.session_6.dto.response.DataResponse;
import liliana.session_6.entity.Employee;
import liliana.session_6.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Employee>>> getEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Employee>> addEmployee(@RequestBody AddEmployeeRequest employee) {
        return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<Employee>> updateEmployee(@RequestBody UpdateEmployeeRequest employee, @PathVariable int id) {
        return new ResponseEntity<>(employeeService.update(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse<Employee>> deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
