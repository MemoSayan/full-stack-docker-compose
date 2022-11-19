package mx.com.ddd.spring.domain.services.employee;

import mx.com.ddd.spring.domain.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO save(EmployeeDTO employeeDTO);

    void delete(Long id);

    EmployeeDTO findById(Long id);

}
