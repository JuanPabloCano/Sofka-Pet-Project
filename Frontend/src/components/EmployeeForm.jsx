import React from "react";


const EmployeeForm = () => {
  return (
    <div className="mt-3">

      <div className="mb-4 text-center col-auto"><h3>Agregar empleado</h3></div>

      <div className="row h-100 justify-content-center align-items-center">
        <div className="col-auto">
          <form action="" className="form-horizontal justify-content-center">
            
            <div className="form-group ">
              <div className="mb-2">
                <input type="text" className="form-control" id="inputFirstName" placeholder="First Name" />
              </div>
            </div>

            <div className="form-group">
              <div className="mb-2">
                <input type="text" className="form-control" id="inputLastName" placeholder="Last Name" />
              </div>
            </div>

            <div className="form-group">
              <div className="mb-2">
                <input type="email" className="form-control" id="inputEmail" placeholder="Email" />
              </div>
            </div>

            <div className="form-group">
              <div className="text-center">
                <button type="submit" className="btn btn-primary">Sign in</button>
              </div>
            </div>

          </form>
        </div>
      </div>
      
    </div>
  );
}

export default EmployeeForm;