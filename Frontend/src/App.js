import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import EmployeeList from "./components/EmployeeList";
import EmployeeForm from "./components/EmployeeForm";
import EmployeeUpdate from './components/EmployeeUpdate';
import EmployeeView from './components/EmployeeView';



function App() {

  return (
    <div>
      <div className="container">

        <Router>
          <Routes>
          <Route path="/employee/view/:id" element={<EmployeeView />} />
            <Route path="/employee/update/:id" element={<EmployeeUpdate />} />
            <Route path="/employee/add" element={<EmployeeForm />} />
            <Route path="/employees" element={<EmployeeList />} />            
            <Route path="/" element={<EmployeeList />} />
          </Routes>
        </Router>

        {/* <EmployeeForm />
        <div className="mt-5">
        <EmployeeList />
        </div> */}

      </div>      
    </div>
  );
}

export default App;
