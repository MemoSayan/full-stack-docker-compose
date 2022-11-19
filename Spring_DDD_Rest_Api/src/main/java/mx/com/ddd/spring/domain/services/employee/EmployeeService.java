package mx.com.ddd.spring.domain.services.employee;

import mx.com.ddd.spring.domain.EmployeeDTO;
import mx.com.ddd.spring.domain.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    List<EmployeeDTO> findAll2();

}
