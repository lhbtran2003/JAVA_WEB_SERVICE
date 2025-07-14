package liliana.session_3.controller;

import liliana.session_3.entity.Employee;
import liliana.session_3.service.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "ex9/add-employee";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping
    public String listEmployees(Model model,
                                @RequestParam(required = false, defaultValue = "0") int currentPage,
                                @RequestParam(required = false, defaultValue = "asc") String sortDirection,
                                @RequestParam(required = false, defaultValue = "id") String sortBy,
                                @RequestParam(required = false, defaultValue = "") String keyword) {
        List<Employee> employees;
        if (keyword != null && !keyword.isEmpty()) {
            Employee employee = employeeService.findWithPhoneNumber(keyword);
            employees = (employee != null) ? List.of(employee) : List.of();
            model.addAttribute("employees", employees );
        } else {
            employees = employeeService.findAllWithPageAndSort(currentPage, 2, sortBy, sortDirection).getContent();
        }
        model.addAttribute("employees", employees);
        return "ex9/list-employees";
    }
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isEmpty()) {
            return "redirect:/404";
        }
        model.addAttribute("employeeId", employee.get().getId());
        model.addAttribute("employee",employee.get());
        return "ex9/edit-employee";
    }
    @PostMapping("/edit/{id}")
    public String editEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isEmpty()) {
            return "redirect:/404";
        }
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
