
const HOST_API = 'http://localhost:8080/api/v1/';

class EmployeeService {

    // funcion asincrona para obtener la promesa de todos los empleados
    async getEmployees() {
        return fetch(HOST_API + '/employees')
        .catch(error => {
            console.log('Error: ', error);
        })
    }

    async saveEmployee (employee) {
        return fetch(HOST_API + '/employees', {
            method: 'POST',
            body: JSON.stringify(employee),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .catch(error => console.error('Error: ', error))
    }

    async getEmployeeById(employeeId) {
        return fetch(HOST_API + '/employees/' + employeeId)
        .catch(error => console.error('Error: ', error))
    }

    async updateEmployee (employeeId, employee) {
        return fetch(HOST_API + '/employee/' + employeeId, {
            method: 'PUT',
            body: JSON.stringify(employee),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .catch(error => console.error('Error: ', error))
    }

    async deleteEmployee (employeeId) {
        return fetch(HOST_API + '/employees/' + employeeId, {
            method: 'DELETE'
        })
        .catch(error => console.error('Error: ', error))
    }

}

export default new EmployeeService();