import React, { useState, useEffect } from "react";
import { useParams } from "react-router";
import EmployeeService from "../services/EmployeeService";


const EmployeeView = () => {

    const { id } = useParams()

    const initialState = {
        id: id,
        firstName: "",
        lastName: "",
        emailId: "",
    }

    const [employee, setEmployee] = useState(initialState);

    useEffect(() => {
        EmployeeService.getEmployeeById(id).then(response => {
            response.json().then(data => {
                setEmployee({
                    ...employee,
                    firstName: data.firstName,
                    lastName: data.lastName,
                    emailId: data.emailId,
                });
            });
        })

    }, [id])

    return (
        <div>
            <br />
            <div className="card col-md-6 offset-md-3"></div>
            <h3 className="text-center"> Detalles de empleado </h3>
            <div className="card-body">
                <div className="row">
                    <label htmlFor="">Nombre: </label>
                    <div>{ employee.firstName }</div>
                </div>
                <div className="row">
                    <label htmlFor="">Apellido: </label>
                    <div>{ employee.lastName }</div>
                </div>
                <div className="row">
                    <label htmlFor="">Correo: </label>
                    <div>{ employee.emailId }</div>
                </div>
            </div>
        </div>
    )
}

export default EmployeeView;