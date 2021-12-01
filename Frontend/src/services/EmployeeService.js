
const HOST_API = 'http://localhost:8080/api/v1/';

class EmployeeService {

    // funcion asincrona para obtener la promesa de todos los empleados
    async getEmployees() {
        return fetch(HOST_API + '/employees')
        .catch(error => {
            console.log('Error: ', error);
        })
    }

}

export default new EmployeeService();