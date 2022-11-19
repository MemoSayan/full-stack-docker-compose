package mx.com.ddd.spring.infrastructure;

import mx.com.ddd.spring.domain.EmployeeDTO;
import mx.com.ddd.spring.domain.model.Employee;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    Employee employee;

    public EmployeeDTO toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO dto = new EmployeeDTO();
        BeanUtils.copyProperties(employee, dto);
        return dto;
    }

    public Employee toEntity(EmployeeDTO employee) {
        if (employee == null) {
            return null;
        }
        Employee entity = new Employee();
        BeanUtils.copyProperties(employee, entity);
        return entity;
    }

    public List<EmployeeDTO> toDtoList(List<Employee> employee) {
        if (employee == null) {
            return null;
        }

        List<EmployeeDTO> listDestination = new ArrayList<>();

        for (int i = 0; i < listDestination.size(); i++) {
            BeanUtils.copyProperties(employee.get(i), listDestination.get(i));
        }

        return listDestination;
    }


}
