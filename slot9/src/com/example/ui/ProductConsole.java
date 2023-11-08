package com.example.ui;

import com.example.controller.ProductService;
import com.example.entity.Products;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductConsole {
    private final Scanner sc;
    ProductService productService = new ProductService();
    public ProductConsole(){
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("=====Products Menu=====");
        System.out.println("1.Add Product");
        System.out.println("2.Show All Product");
        System.out.println("3.Remove Product");
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
                    addProduct();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    removeProduct();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    private int readInt(int min, int max){
        int choice;
        while (true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max){
                    break;
                }
            }catch (NumberFormatException e){

            }
        }
        return choice;
    }
    private void addProduct(){
        System.out.println("Enter Product name: ");
        String name = sc.nextLine();
        System.out.println("Enter Product Description: ");
        String desc = sc.nextLine();
        System.out.println("Enter Product Price: ");
        Double price = readDouble(0,Double.MAX_VALUE);
        Products product = new Products(name,desc,price);
        ProductService.createProduct(product);
    }
    private void showAll(){
        System.out.println("---All Product---");
        System.out.println("ID\tName\tDesc\tPrice");
        ArrayList<Products> allProducts = productService.getAllProducts();

        allProducts.forEach((products) ->{
            System.out.println(products.getProductID() + "\t" + products.getProductName() +"\t"
            + products.getProductDesc() + "\t" + products.getProductPrice());
        });
    }
    private void removeProduct(){
        System.out.println("Enter ID Of Product: ");
        int id = readInt(0,Integer.MAX_VALUE);
        boolean result = productService.deleteProduct(id);
        if (result){
            System.out.println("Product was remove");
        }else {
            System.out.println("Product not found");
        }
    }
}
