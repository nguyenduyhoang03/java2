package controller;

import Service.Service;
import model.Book;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    Service managerLibrary = new Service();
    Scanner sc = new Scanner(System.in);

    public void addBook()throws SQLException{
        Book book = new Book();
        System.out.println("Enter ID: ");
        book.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Name: ");
        book.setName(sc.nextLine());
        System.out.println("Enter Author: ");
        book.setAuthor(sc.nextLine());
        System.out.println("Enter Quantity");
        book.setQuantity(sc.nextInt());
        managerLibrary.addBook(book);
    }
    public void searchById() throws SQLException{
        System.out.println("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Book book = managerLibrary.searchById(id);
        System.out.println(book);
    }
    public void searchByName()throws SQLException{
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        Book book = managerLibrary.searchByName(name);
        System.out.println(book);
    }
    public void getAllBook()throws SQLException{
        System.out.println(managerLibrary.getAllbBook());
    }
    public void updateStatusBorrow()throws SQLException{
        System.out.println("Enter ticketID: ");
        int ticketID = sc.nextInt();
        System.out.println("Is Returned ?: ");
        boolean isReturned = sc.nextBoolean();
        managerLibrary.updateStatusBorrow(ticketID,isReturned);
    }
}
