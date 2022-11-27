package mx.com.ddd.spring.application.controller;

import mx.com.ddd.spring.domain.EmployeeDTO;
import mx.com.ddd.spring.domain.services.employee.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;


//@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/employee/api/v1")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
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

    /**
     * create method with validation example
     *
     * @param employeeDTO
     * @param result
     * @return {@link EmployeeDTO}
     */
    @PostMapping("/employeesCreate")
    public ResponseEntity<?> create(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult result) {
        LOGGER.info("EmployeeDTO {}, result {}" , employeeDTO , result);
        EmployeeDTO newEmployeeDTO = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> err.getField() + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            newEmployeeDTO = employeeService.save(employeeDTO);
        } catch (DataAccessException e) {
            response.put("message", "Error inserting into database");
            response.put("error", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Employee created successfully");
        response.put("employee", newEmployeeDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping("/employeesUpdate/{id}")
    public EmployeeDTO update(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTOcurrent = employeeService.findById(id);
        employeeDTOcurrent.setName(employeeDTO.getName());
        employeeDTOcurrent.setEmail(employeeDTO.getEmail());
        employeeDTOcurrent.setPhone(employeeDTO.getPhone());
        employeeDTOcurrent.setJobTitle(employeeDTO.getJobTitle());
        return employeeService.save(employeeDTO);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }


}
