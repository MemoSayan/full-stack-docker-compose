import React, {Component, useState} from 'react';
import EmployeeService from "../EmployeeService/EmployeeService";

function showError(mensaje) {
    const formulario = document.querySelector('#form');
    console.log(formulario);
    const error = document.createElement('P');
    error.textContent = mensaje;
    console.error(error);
    error.classList.add('error');
    formulario.appendChild(error);

    setTimeout(() => {
        error.remove();
    }, 5000)

}


class CreateEmployeeComponent extends Component {
    datos;


    constructor(props) {
        super(props);
        this.state = {
            name: '',
            email: '',
            jobTitle: '',
            phone: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeJobTitleHandler = this.changeJobTitleHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
    }

    saveOrUpdateEmployee = (event) => {
        event.preventDefault();
        let employee = {
            name: this.state.name,
            email: this.state.email,
            jobTitle: this.state.jobTitle,
            phone: this.state.phone
        };
        //console.log('employee : ' + JSON.stringify(employee));
        if (this.state.name === '' || this.state.email === '') {
            showError('Name and Email are required')
            return;
        }

        EmployeeService.createEmployee(employee).then(rest => {
            this.props.history.push('/employees');
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

    cancel() {
        this.props.history.push('/employees');
    }

    render() {
        return (
            <div>
                <br></br>

                <div className="card col-md-6 offset-md-3 offset-md-3">
                    <h3 className="text-center">Add Employee</h3>

                    <div className="card-body">
                        <form id="form">
                            <div className="form-group">
                                <label> Name </label>
                                <input id="name" placeholder="Name" name="Name" className="form-control" type="text"
                                       value={this.state.name} onChange={this.changeNameHandler}/>
                            </div>
                            <div className="form-group">
                                <label> Email </label>
                                <input placeholder="Email" id="name" name="email" className="form-control" type="email"
                                       value={this.state.email} onChange={this.changeEmailHandler}/>

                            </div>
                            <div className="form-group">
                                <label> Jobtitle </label>
                                <input placeholder="Jobtitle" name="jobtitle" className="form-control" type="text"
                                       value={this.state.jobTitle} onChange={this.changeJobTitleHandler}/>
                            </div>
                            <div className="form-group">
                                <label> Phone </label>
                                <input placeholder="Phone" id="phone" name="phone" className="form-control"
                                       type="number"
                                       value={this.state.phone} onChange={this.changePhoneHandler}/>
                            </div>
                            <button className="btn btn-success" onClick={this.saveOrUpdateEmployee}>Save</button>
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

export default CreateEmployeeComponent
