import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

import EmployeeService from "../services/EmployeeService";

const EmployeeForm = () => {
  const initialState = {
    firstName: "",
    lastName: "",
    documentId: "",
    emailId: "",
  };

  const [employee, setEmployee] = useState(initialState);

  let navigate = useNavigate();

  const handleInputChange = (event) => {
    setEmployee({
      ...employee,
      [event.target.name]: event.target.value,
    });
  };

  const saveEmployee = (event) => {
    event.preventDefault();

    setEmployee({
      firstName: event.target.firstName.value,
      lastName: event.target.lastName.value,
      doumentId: event.target.documentId.value,
      emailId: event.target.emailId.value,
    });

    EmployeeService.saveEmployee(employee).then((response) => {
      if (response.ok) {
        response.json().then((data) => {
          setEmployee(initialState);
          navigate("/employees/isAdmin", { replace: true });
        });
      }
    });
  };

  const handleCancel = (event) => {
    navigate("/employees/isAdmin", { replace: true });
  };

  return (
    <div className="mt-3">
      <div className="mb-4 text-center col-auto">
        <h3 className="title">Agregar empleado</h3>
      </div>

      <div className="row h-100 justify-content-center align-items-center">
        <div className="col-auto">
          <form
            action=""
            className="form-horizontal justify-content-center"
            onSubmit={saveEmployee}
          >
            <div className="form-group ">
              <div className="mb-2">
                <input type="text" className="form-control" name="firstName" placeholder="Nombre"
                  value={employee.firstName} onChange={handleInputChange} required
                />
              </div>
            </div>

            <div className="form-group">
              <div className="mb-2">
                <input type="text" className="form-control" name="lastName" placeholder="Apellido"
                  value={employee.lastName} onChange={handleInputChange} required
                />
              </div>
            </div>

            <div className="form-group ">
              <div className="mb-2">
                <input type="text" className="form-control" name="documentId" placeholder="Documento"
                  value={employee.documentId} onChange={handleInputChange} required
                />
              </div>
            </div>

            <div className="form-group">
              <div className="mb-2">
                <input type="email" className="form-control" name="emailId" placeholder="Correo"
                  value={employee.emailId} onChange={handleInputChange} required
                />
              </div>
            </div>

            <div className="form-group">
              <div className="text-center">
                <button type="submit" className="btn btn-primary btn-ver">
                  Agregar
                </button>
                <button
                  style={{ marginLeft: "10px" }}
                  className="btn btn-primary btn-del"
                  onClick={() => handleCancel()}
                >
                  Cancelar
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default EmployeeForm;
