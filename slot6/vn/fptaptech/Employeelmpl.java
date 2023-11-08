package slot6.vn.fptaptech;
import java.sql.*;
public class Employeelmpl implements EmployeeDAO{
    Employee e = new Employee();
    @Override
    public Employee getEmployeeById(String id) throws SQLException {
        Connection connection = MySqlConnection.getMyConnection();
        String query = "select * from employee where id = " + id;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            String Id = rs.getString(1);
            e.setId(id); // id cua Employee se co gia tri
            String name = rs.getString(2);
            e.setName(name);
            String sal = rs.getString(3);
            e.setSalary(sal);
            System.out.println("        Employee Data           ");
            System.out.println("================================");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Salary: " +sal);
        }
        return e;
    }

    @Override
    public void getAllEmployee() throws SQLException {
        String query = "select * from Employee";
        Connection connection = MySqlConnection.getMyConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            String id = rs.getString(1);
            e.setId(id);
            String name = rs.getString(2);
            e.setName(name);
            String salary = rs.getString(3);
            e.setSalary(salary);
            System.out.printf("|5%s|%-10s|%-10s|\n", id, name, salary);
        }
    }

    @Override
    public Employee addEmployee(Employee e) throws SQLException {
        Connection connection = MySqlConnection.getMyConnection();
        PreparedStatement ps = connection.prepareStatement("insert in to Employee values(?,?,?)");
        ps.setString(1,e.getId());
        ps.setString(2,e.getName());
        ps.setString(3,e.getSalary());
        int newCount = ps.executeUpdate();
        if(newCount > 0) {
            System.out.println("Employee add success");
        }else {
            System.out.println("Employee add fail");
        }
        return null;
    }

    @Override
    public Employee delEmployee(String id) throws SQLException {
        Connection connection = MySqlConnection.getMyConnection();
        String sql = "delete from employee where id = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,id);

        int i = ps.executeUpdate();
        if (i > 0 ){
            System.out.println("Data deleted successfully !");
        }else {
            System.out.println("Fail to delete data !");
        }
        return null;
    }

    @Override
    public Employee updateEmployee(String id, String name) throws SQLException {
        Connection connection = MySqlConnection.getMyConnection();
        String sql = "Update Employee set name = ? where id = ?";
        PreparedStatement ps= connection.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,id);

        int i = ps.executeUpdate();
        if (i > 0) {
            System.out.println("An existsing user was updated successfully !");
        }else {
            System.out.println("Fail to update data !");
        }
        return null;
    }
}
