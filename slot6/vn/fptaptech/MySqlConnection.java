package slot6.vn.fptaptech;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {
    public static Connection getMyConnection() throws SQLException {
        String hostName = "localhost";
        String DbName = "EmployeeManager";
        String username = "root";
        String password = "";
        //"jdbc:myqsql://localhost:3306/javaexample,username,password"
        String connectionURl = "jdbc:mysql//" + hostName + "3306/" + DbName;
        Connection connection = DriverManager.getConnection(connectionURl,username,password);
        return connection;
    }
    public static void createEmployeeTable() throws SQLException {
        //1.Tao connection'
        Connection connection = getMyConnection();
        Statement statement = connection.createStatement();
        //thuc thi cac chi thi voi database
        //create table
        statement.execute("drop table if exists employee");
        statement.execute("creare table employee(id varchar primary key,)" + "name varchar(50)"
                + "salary varchar(20)");
    }
}



