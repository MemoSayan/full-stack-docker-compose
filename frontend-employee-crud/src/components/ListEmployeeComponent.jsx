import React, {Component} from 'react';
import EmployeeService from "../EmployeeService/EmployeeService";

class ListEmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: [],
        }
        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);

    }

    componentDidMount() {
        EmployeeService.getEmployees().then((rest) => {
            this.setState({employees: rest.data})
        });
    }

    addEmployee(employee) {
        this.props.history.push('/add-employee');
    }

    editEmployee(id) {
        this.props.history.push(`/update-employee/${id}`);
    }

    deleteEmployee(id) {
        EmployeeService.deleteEmployee(id).then(rest => {
            this.setState({employees: this.state.employees.filter(employee => employee.id !== id)});
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Employees</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addEmployee}>New Employee</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered ">


                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>JobTitle</th>
                            <th>Phone</th>
                            <th> Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.employees.map(
                                employee =>
                                    <tr key={employee.id}>
                                        <td>{employee.name}</td>
                                        <td>{employee.email}</td>
                                        <td>{employee.jobTitle}</td>
                                        <td>{employee.phone}</td>
                                        <td>
                                            <button onClick={() => this.editEmployee(employee.id)}
                                                    className="btn btn-info">Update
                                            </button>
                                            <button style={{marginLeft: "10px"}}
                                                    onClick={() => this.deleteEmployee(employee.id)}
                                                    className="btn btn-danger">Delete
                                            </button>
                                        </td>

                                    </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListEmployeeComponent;
