import React, { useState } from "react";
import { useNavigate } from "react-router";
import EmployeeService from "../services/EmployeeService";

const Login = () => {

  const initialState = {
    userAdmin: "",
    passwordAdmin: "",
  }

  const [admin, setAdmin] = useState(initialState);
  let navigate = useNavigate();

  const handleInputChange = (event) => {
    setAdmin({
      ...admin,
      [event.target.name]: event.target.value
    });
  }

  const iniciarSesion = (event) => {
    event.preventDefault();
    setAdmin({
      ...admin,
      userAdmin: event.target.value,
      passwordAdmin: event.target.value
    });

    EmployeeService.consultAdmin(admin).then(response => {
      response.json().then(data => {
        if (data == true) {
          navigate("/employees", { replace: true });
        }
      })
    });

  }

  const handleCancel = (event) => {
    navigate("/employees", { replace: true });
  }


  return (

    <div className="mt-3">

      <div className="mb-4 text-center col-auto"><h3 className="title">Administrador</h3></div>

      <div className="row h-100 justify-content-center align-items-center">
        <div className="col-auto">
          <form action="" className="form-horizontal justify-content-center" onSubmit={iniciarSesion}>

            <div className="form-group ">
              <div className="mb-2">
                <input type="text" className="form-control" name="userAdmin" placeholder="Usuario"
                  onChange={handleInputChange}
                />
              </div>
            </div>

            <div className="form-group">
              <div className="mb-2">
                <input type="password" className="form-control" name="passwordAdmin" placeholder="Contraseña"
                  onChange={handleInputChange}
                />
              </div>
            </div>

            <div className="form-group">
              <div className="text-center">
                <button type="submit" className="btn btn-primary btn-ver">Ingresar</button>
                <button style={{ marginLeft: "10px" }} className="btn btn-primary btn-del" onClick={() => handleCancel()}>Cancelar</button>
              </div>
            </div>

          </form>
        </div>
      </div>

    </div>
  )
}

export default Login;