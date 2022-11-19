package mx.com.ddd.spring.application.controller;

import mx.com.ddd.spring.domain.EmployeeDTO;
import mx.com.ddd.spring.domain.model.Employee;
import mx.com.ddd.spring.domain.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDTO> index() {
        return employeeService.findAll2();
    }
}
