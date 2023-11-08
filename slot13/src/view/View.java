package view;

import controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
    public static void main(String[] args) throws SQLException {
        boolean flag = false;
        Controller controller = new Controller();
        Scanner sc = new Scanner(System.in);
        while (!flag){
            System.out.println("----Library Management----");
            System.out.println("1. Add Book");
            System.out.println("2. Search By ID");
            System.out.println("3. Search By Name");
            System.out.println("4. Update Status Borrow");
            System.out.println("5. View All Book");
            System.out.println("6. Exit");
            System.out.println("--------------------------");
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    controller.addBook();
                case 2:
                    controller.searchById();
                case 3:
                    controller.searchByName();
                case 4:
                    controller.updateStatusBorrow();
                case 5:
                    controller.getAllBook();
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong select");
            }
        }
    }

}
