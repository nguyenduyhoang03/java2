package com.example.ui;

import com.example.controller.LoginController;
import com.example.entity.Users;
import java.io.IOException;
import java.util.Scanner;


public class LoginConsole {
    LoginController loginController = new LoginController();
    Users user = new Users();
    private final Scanner sc;
    public LoginConsole() throws IOException{
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("----Product Menu----");
        System.out.println("1.Login Statement");
        System.out.println("2.Login PreparedStatement");
        System.out.println("0.Exit");
        int choice = readInt(0,3);
        return choice;
    }
    public void start(){
            while (true){
                int choice = menu();
                switch (choice){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        loginStatement();
                        break;
                    case 2:
                        loginPreparedStatement();
                        break;
                    default:
                        throw new AssertionError();
                }
            }
    }
    private int readInt(int min,int max){
        int choice;
        while (true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max){
                    break;
                }
            }catch (NumberFormatException e){}
        }
        return choice;
    }
    private void loginStatement(){
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        String result = loginController.loginStatementController(user);
        System.out.println(result);
    }
    private void loginPreparedStatement(){
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        String result = loginController.loginPrepareStatementController(user);
        System.out.println(result);
    }

}
