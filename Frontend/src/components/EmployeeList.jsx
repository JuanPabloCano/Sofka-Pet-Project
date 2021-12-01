import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import EmployeeService from "../services/EmployeeService";

function EmployeeList() {

    const [employees, setEmployees] = useState([]);
    let navigate = useNavigate();

    useEffect(() => {
        getEmployees();
    }, [])
    
    const getEmployees = () => {
        EmployeeService.getEmployees().then(response => {
            if(response.ok) {
                response.json().then(data => {
                    setEmployees(data);
                })
            }
        })
    }

    const addEmployee = () => {
        navigate("/employee/add", {replace: true});
    }

    return (
        <div className="mt-5">
            <div className="mb-4 text-center col-auto"><h3>Lista de empleados</h3></div>

            <div className="row">
                <button className="btn btn-primary" onClick={() => {addEmployee()}}> Agregar empleado </button>
            </div>

            <table className="table table-bordered">
                <thead>
                    <tr className="text-center">
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map((employee) => {
                            return (
                                <tr className="text-center" key={employee.id}>
                                    <td>{employee.id}</td>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.emailId}</td>
                                    <td>
                                    <div className="text-center">
                                        <button className="btn btn-light">Edit</button>
                                        <button style={{marginLeft: "10px"}} className="btn btn-dark">Delete</button>
                                    </div>
                                    </td>
                                </tr>
                            )
                        })
                    }

                </tbody>
            </table>
        </div>
    )
}

export default EmployeeList;