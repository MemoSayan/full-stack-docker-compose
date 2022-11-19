package mx.com.ddd.spring.infrastructure.repository.employee;

public class EmployeeNotFoundException extends  RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
