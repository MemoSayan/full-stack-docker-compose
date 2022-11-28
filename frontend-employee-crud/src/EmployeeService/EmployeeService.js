import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/employee/api/v1/'

class EmployeeService {

    getEmployees() {
        return axios.get(API_BASE_URL + 'employees');
    }

    createEmployee(employee) {
        return axios.post(API_BASE_URL + 'employeesCreate', employee);
    }

    getEmployeeById(id) {
        return axios.get(API_BASE_URL + 'employees/' + id);
    }

    updateEmployee(employee, id) {
        return axios.put(API_BASE_URL + 'employeesUpdate/' + id, employee);
    }

    deleteEmployee(employeeId) {
        return axios.delete(API_BASE_URL + 'employee/' + employeeId);
    }

}

export default new EmployeeService();