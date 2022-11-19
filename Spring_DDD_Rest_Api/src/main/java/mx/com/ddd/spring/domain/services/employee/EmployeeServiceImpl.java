package mx.com.ddd.spring.domain.services.employee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mx.com.ddd.spring.domain.EmployeeDTO;
import mx.com.ddd.spring.domain.model.Employee;
import mx.com.ddd.spring.domain.services.employee.converter.Converter;
import mx.com.ddd.spring.infrastructure.repository.employee.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Converter convertir;


    /**
     * Query: Finds All Employees.
     *
     * @return all {@link Employee}s of the Company.
     **/
    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return convertir.toDtoList(employeeList);

    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        LOGGER.info(".. ::save .. ", employeeDTO);
        Employee employee = convertir.toEntity(employeeDTO);
        employeeRepository.save(employee);
        return employeeDTO;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return convertir.toDto(employee);
    }

}
