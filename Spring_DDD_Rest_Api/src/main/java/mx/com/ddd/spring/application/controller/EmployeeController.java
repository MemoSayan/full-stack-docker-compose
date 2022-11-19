package mx.com.ddd.spring.application.controller;

import mx.com.ddd.spring.domain.EmployeeDTO;
import mx.com.ddd.spring.domain.model.Employee;
import mx.com.ddd.spring.domain.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.ClientEndpoint;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDTO> index() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
        EmployeeDTO employeeDTOcurrent = employeeService.findById(id);
        employeeDTOcurrent.setName(employeeDTO.getName());
        employeeDTOcurrent.setEmail(employeeDTO.getEmail());
        employeeDTOcurrent.setPhone(employeeDTO.getPhone());
        employeeDTOcurrent.setImageUrl(employeeDTO.getImageUrl());
        employeeDTOcurrent.setJobTitle(employeeDTO.getJobTitle());
        return employeeService.save(employeeDTO);
    }

    @DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable Long id ){
        employeeService.delete(id);
    }


}
