package mx.com.ddd.spring.infrastructure.repository.employee;

import mx.com.ddd.spring.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
