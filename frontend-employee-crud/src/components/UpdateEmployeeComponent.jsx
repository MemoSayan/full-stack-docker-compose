import React, {Component} from 'react';
import EmployeeService from "../EmployeeService/EmployeeService";

class UpdateEmployeeComponent extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id: this.props.match.params.id,
            name: '',
            email: '',
            jobTitle: '',
            phone: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeJobTitleHandler = this.changeJobTitleHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.updateEmployee = this.updateEmployee.bind(this);
    }

    componentDidMount() {
        EmployeeService.getEmployeeById(this.state.id).
        then((rest ) =>{
           let employee = rest.data;
           this.setState({
               name: employee.name,
               email: employee.email,
               jobTitle: employee.jobTitle,
               phone: employee.phone,
           });
        });
    }
    updateEmployee = (event) => {
        event.preventDefault();
        let employee = {
            id: this.state.id,
            name: this.state.name,
            email: this.state.email,
            jobTitle: this.state.jobTitle,
            phone: this.state.phone,
        };
        console.log('employee : ' + JSON.stringify(employee, this.state.id));
        EmployeeService.updateEmployee(employee, this.state.id).then( rest => {
            this.props.history.push('/employees')
        });
    }


    changeNameHandler = (event) => {
        this.setState({name: event.target.value});
    }
    changeEmailHandler = (event) => {
        this.setState({email: event.target.value});
    }
    changeJobTitleHandler = (event) => {
        this.setState({jobTitle: event.target.value});
    }
    changePhoneHandler = (event) => {
        this.setState({phone: event.target.value});
    }

    cancel(){
        this.props.history.push('/employees' );
    }
    render() {
        return (
            <div>
                <br></br>

                <div className="card col-md-6 offset-md-3 offset-md-3">
                    <h3 className="text-center">Update Employee</h3>

                    <div className="card-body">
                        <form>
                            <div className="form-group">
                                <label> Name </label>
                                <input placeholder="Name" name="Name" className="form-control"
                                       value={this.state.name} onChange={this.changeNameHandler}/>
                            </div>
                            <div className="form-group">
                                <label> Email  </label>
                                <input placeholder="Email" name="email" className="form-control"
                                       value={this.state.email} onChange={this.changeEmailHandler}/>
                            </div>
                            <div className="form-group">
                                <label> Jobtitle  </label>
                                <input placeholder="Jobtitle" name="jobtitle" className="form-control"
                                       value={this.state.jobTitle} onChange={this.changeJobTitleHandler}/>
                            </div>
                            <div className="form-group">
                                <label> Phone  </label>
                                <input placeholder="Phone" name="phone" className="form-control"
                                       value={this.state.phone} onChange={this.changePhoneHandler}/>
                            </div>
                            <button className="btn btn-success" onClick={this.updateEmployee}>Save</button>
                            <button className="btn btn-danger" onClick={this.cancel.bind(this)}
                                    style={{marginLeft: "10px"}}>Cancel
                            </button>
                        </form>
                    </div>
                </div>
            </div>

        );
    }
}

export default UpdateEmployeeComponent;