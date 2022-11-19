package mx.com.ddd.spring.domain.services.employee.converter;

import mx.com.ddd.spring.domain.EmployeeDTO;
import mx.com.ddd.spring.domain.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
        List<EmployeeDTO> list = new ArrayList<>();
        for (int i = 0; i < employee.size(); i++) {
            Employee employeeEt = employee.get(i);
            EmployeeDTO employeeDTO  = toDto(employeeEt);
            list.add(employeeDTO);
        }
        return list;
    }

}
