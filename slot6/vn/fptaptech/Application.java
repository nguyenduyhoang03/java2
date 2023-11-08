package slot6.vn.fptaptech;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
        int choice, num;
        Employeelmpl dao = new Employeelmpl();
        Employee e;//default null
        do{
            System.out.println("==========Menu============");
            System.out.println("1.Get Employee By Id");
            System.out.println("2.Add Employee");
            System.out.println("3.Update Employee");
            System.out.println("4.Delete Employee");
            System.out.println("5.Get All Employee");
            System.out.println("6.Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter the ID Of Employee: ");
                    String id1 = sc.next();
                    e = dao.getEmployeeById(id1);
                    break;
                case 2:
                    System.out.println("Enter employee details: ");
                    String id2 = sc.next();
                    System.out.println("Enter employee name: ");
                    String name = sc.next();
                    System.out.println("Enter salary: ");
                    String salary = sc.next();
                    Employee e1 = new Employee(id2,name,salary);
                    e = dao.addEmployee(e1);
                    break;
                case 3:
                    System.out.println("Enter the ID to change: ");
                    String id3 = sc.next();
                    System.out.println("Enter the new name: ");
                    String name1 = sc.next();
                    e = dao.updateEmployee(id3,name1);
                    break;
                case 4:
                    System.out.println("Enter the ID to delete: ");
                    String id4 = sc.next();
                    e = dao.delEmployee(id4);
                    break;
                case 5:
                    System.out.println("Employee Data: ");
                    System.out.println("===================================");
                    System.out.printf("|5%s|%-10s|\n","ID","Name","Salary");
                    System.out.println("====================================");
                    dao.getAllEmployee();
                    System.out.println("====================================");
                    break;
                case 6:
                    exit(0);
                default:
                    System.out.println("Wrong input...!");
                    break;
            }
            System.out.println("Enter 6 to continue...!");
            num = sc.nextInt();
        }while (num == 6);
    }
}
