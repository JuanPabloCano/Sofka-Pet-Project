import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router";

import EmployeeService from "../services/EmployeeService";

const EmployeeUpdate = () => {

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

    let navigate = useNavigate();

    const handleInputChange = (event) => {
        setEmployee({
            ...employee,
            [event.target.name]: event.target.value
        });
    }

    const updateEmployee = (event) => {
        event.preventDefault();

        setEmployee({
            ...employee,
            firstName: event.target.firstName.value,
            lastName: event.target.lastName.value,
            emailId: event.target.emailId.value,
        });

        EmployeeService.updateEmployee(employee.id, employee).then(response => {
            response.json().then(data => {
                navigate('/employees');
            })
        })    
    }

    const handleCancel = (event) => {
        navigate("/employees", { replace: true });
    }

    return (
        <div className="mt-3">

            <div className="mb-4 text-center col-auto"><h3>Modificar empleado</h3></div>

            <div className="row h-100 justify-content-center align-items-center">
                <div className="col-auto">
                    <form action="" className="form-horizontal justify-content-center" onSubmit={updateEmployee}>

                        <div className="form-group ">
                            <div className="mb-2">
                                <input type="text" className="form-control" name="firstName" placeholder="First Name"
                                    value={employee.firstName} onChange={handleInputChange}
                                />
                            </div>
                        </div>

                        <div className="form-group">
                            <div className="mb-2">
                                <input type="text" className="form-control" name="lastName" placeholder="Last Name"
                                    value={employee.lastName} onChange={handleInputChange}
                                />
                            </div>
                        </div>

                        <div className="form-group">
                            <div className="mb-2">
                                <input type="email" className="form-control" name="emailId" placeholder="Email"
                                    value={employee.emailId} onChange={handleInputChange}
                                />
                            </div>
                        </div>

                        <div className="form-group">
                            <div className="text-center">
                                <button type="submit" className="btn btn-primary">Actualizar</button>
                                <button style={{ marginLeft: "10px" }} className="btn btn-primary" onClick={() => handleCancel()}>Cancelar</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>

        </div>
    );
}

export default EmployeeUpdate;