import React, { Component } from 'react';
import '../index.css';
import axios from 'axios';

const baseUrl="http://localhost:3001/usuarios";

 class Login extends Component {

    state={
        form:{
            username: '',
            password:''
        }
    }

    handleChange= async e=>{
        await this.setState({
            form:{
                ...this.state.form,
            [e.target.name]: e.target.value
            }
        })
        console.log(this.state.form);
    }

    iniciarSesion=async()=>{
        await axios.get(baseUrl,{params: {username: this.state.form.username, password: this.state.form.password}})
        .then(response=>{
            return response.data;
        })
        .then(response=>{
            if(response.length>0){
                var respuesta=response[0];
                
                alert(`bienvenido ${respuesta.username}`);
                window.location.href="http://localhost:3000/employees"
            }else {
                alert('el usuario o la contraseña no son correctas');
            }
        })
        .catch(error=>{
            console.log(error);
        })
    }


    render() {
        return (
    <div className="containerPrincipal">
        <div className="containerSecundario">
          <div className="form-group">
            <label>Usuario: </label>
            <br />
            <br/>
            <input
              type="text"
              className="form-control"
              name="username"
              onChange={this.handleChange}
            />
            <br />
            <label>Contraseña: </label>
            <br />
            <br/>
            <input
              type="password"
              className="form-control"
              name="password"
              onChange={this.handleChange}
            />
            <br />
            <button className="btn btn-primary btn-ver" onClick={()=> this.iniciarSesion()}>Iniciar Sesión</button>
          </div>
        </div>
      </div>
        );
    }
}

export default Login;