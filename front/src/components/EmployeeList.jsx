import { faAd, faPlus, faSearch } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import EmployeeService from "../services/EmployeeService";

function EmployeeList() {
    const [employees, setEmployees] = useState([]);
    const [employeesFilter, setEmployeesFilter] = useState([]);



    const [busqueda, setBusqueda] = useState("");


    let navigate = useNavigate();

    useEffect(() => {
        getEmployees();
    }, []);


    const getEmployees = () => {
        EmployeeService.getEmployees().then((response) => {
            if (response.ok) {
                response.json().then((data) => {
                    setEmployees(data);
                    setEmployeesFilter(data);
                });
            }
        });
    };

    const addEmployee = () => {
        navigate("/employee/add", { replace: true });
    };

    const editEmployee = (id) => {
        navigate(`/employee/update/${id}`, { replace: true });
    };

    const deleteEmployee = (id) => {
        EmployeeService.deleteEmployee(id).then((response) => {
            setEmployees(employees.filter((employee) => employee.id !== id));
        });
    };


    const viewEmployee = (id) => {
        navigate(`/employee/view/${id}`, { replace: true });
    };

    const handleInputChange = (event) => {
        setBusqueda(event.target.value);
        filter(event.target.value);
    };

    const filter = (term) => {
        let searchResult = employeesFilter.filter((elemento) => {
            if (
                elemento.firstName.toLowerCase().includes(term.toLowerCase()) ||
                elemento.lastName.toLowerCase().includes(term.toLowerCase())
            ) {
                return elemento;
            }
        });
        setEmployees(searchResult);
    };

    return (
        <div className="mt-5">
            <div className="mb-4 text-center col-auto">
                <h3 className="title">Lista de empleados</h3>
            </div>

            <div className="row prueba">
                <button
                    className="btn btn-primary btn-inicio"
                    onClick={() => {
                        addEmployee();
                    }}
                >
                    {" "}
                    Agregar empleado <FontAwesomeIcon icon={faPlus} />
                </button>
            </div>

            {/* Barra de búsqueda */}
            <div className="App">
                <div className="containerInput">
                    <input
                        type="text"
                        className="form-control inputBuscar prueba"
                        value={busqueda}
                        placeholder="Buscar por nombre/documento"
                        onChange={handleInputChange}
                    />
                    <button className="btn btn-suceses">
                        <FontAwesomeIcon icon={faSearch} />
                    </button>

                </div>
            </div>

            <div className="table-responsive">
                <table className="table table-bordered">
                    <thead>
                        <tr className="text-center">
                            <th scope="col">Documento</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {employees.map((employee) => {
                            return (
                                <tr className="text-center" key={employee.id}>
                                    <td>{employee.documentId}</td>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.emailId}</td>
                                    <td>
                                        <div className="text-center">
                                            <button
                                                className="btn btn-light btn-edit"
                                                onClick={() => editEmployee(employee.id)}
                                            >
                                                Editar
                                            </button>
                                            <button
                                                style={{ marginLeft: "10px" }}
                                                className="btn btn-dark btn-del"
                                                onClick={() => deleteEmployee(employee.id)}
                                            >
                                                Eliminar
                                            </button>
                                            <button
                                                style={{ marginLeft: "10px" }}
                                                className="btn btn-dark btn-ver"
                                                onClick={() => viewEmployee(employee.id)}
                                            >
                                                Ver
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            );
                        })}
                    </tbody>
                </table>
                {
                    employees.length === 0 && <div><h1>No hay Registros</h1>
                    </div>
                }
            </div>
        </div>
    );
}

export default EmployeeList;
