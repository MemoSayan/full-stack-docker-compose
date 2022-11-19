package mx.com.ddd.spring.domain.services.employee;

import mx.com.ddd.spring.domain.EmployeeDTO;
import mx.com.ddd.spring.domain.model.Employee;
import mx.com.ddd.spring.infrastructure.Converter;
import mx.com.ddd.spring.infrastructure.repository.employee.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;


    private Converter convertir;

    /**
     * Query: Finds All Employees.
     *
     * @return all {@link Employee}s of the Company.
     **/
    @Override
    public List<Employee> findAll() {
        findAll2();
        return employeeRepository.findAll();
    }

    public EmployeeDTO toDtoservice(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO dto = new EmployeeDTO();
        BeanUtils.copyProperties(employee, dto);
        return dto;
    }

    public List<EmployeeDTO> toDtoList(List<Employee> employee) {
        if (employee == null) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<>();
        for (int i = 0; i < employee.size(); i++) {
            Employee employeeEt = employee.get(i);
            EmployeeDTO employeeDTO  = toDtoservice(employeeEt);
            list.add(employeeDTO);
            LOGGER.info("employeeEt... " + list.toString());
        }
        return list;
    }

    @Override
    public List<EmployeeDTO> findAll2() {
        List<Employee> employeeList = employeeRepository.findAll();
        LOGGER.info("employee out... " + toDtoList(employeeList));
        return toDtoList(employeeList);

    }

}
