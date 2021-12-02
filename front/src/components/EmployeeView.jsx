import { render } from "@testing-library/react";
import React, { useState, useEffect } from "react";
import { useParams } from "react-router";
import EmployeeService from "../services/EmployeeService";


const EmployeeView = () => {

    const { id } = useParams()

    const initialState = {
        id: id,
        firstName: "",
        lastName: "",
        documentId: "",
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
                    documentId: data.documentId,
                    emailId: data.emailId,
                });
            });
        })

    }, [id])



  
    return (
        <div >
            <br />
            <br />
            <div></div>
            <h3 className="text-center title"> Detalles de empleado </h3>
            <br />
            <br />
            <div className="list-group list-group-flush contenedor">
                <div className="row">
                    <li className="list-group-item-black"   htmlFor="    ">Nombre: </li>
                    <div className="list-group-item">{ employee.firstName }</div>
                </div>
                <div className="row">
                    <li className="list-group-item-black" htmlFor="    ">Apellido: </li>
                    <div className="list-group-item">{ employee.lastName }</div>
                </div>
                <div className="row">
                    <li className="list-group-item-black" htmlFor="    ">Documento: </li>
                    <div className="list-group-item">{ employee.documentId }</div>
                </div>
                <div className="row">
                    <li className="list-group-item-black" htmlFor="    ">Correo: </li>
                    <div className="list-group-item">{ employee.emailId }</div>
                </div>
            </div>
        </div>
    )

}

export default EmployeeView;