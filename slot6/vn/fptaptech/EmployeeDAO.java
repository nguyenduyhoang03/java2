package slot6.vn.fptaptech;

import java.sql.SQLException;

public interface EmployeeDAO {
    //return 1 employee
    public Employee getEmployeeId(String id) throws SQLException;
    //return 1 list employees
    //public ArrayList<Employee> getAllEmployee()
    public void getAllEmployee() throws SQLException;
    public Employee addEmployee(Employee e) throws SQLException;
    public Employee delEmployee(String id) throws SQLException;
    public Employee updateEmployee(String id, String name) throws SQLException;
}
