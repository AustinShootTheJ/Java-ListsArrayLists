package com.AustinShootTheJ;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    // creates a scanner for user input.
    private static Scanner scanner = new Scanner(System.in);
    // creates a groceryList object for us to work with.
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
       // a check for the user to exit our program.
        boolean quit = false;
        // user input to select a method.
        int choice = 0;
        // initial call of our instructions.
        printInstructions();
        // while loop calls our methods according to user input.
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            // clears the scanner buffer.
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstructions();
                    break;

                case 1:
                    groceryList.printGroceryList();
                    break;

                case 2:
                    addItem();
                    break;

                case 3:
                    modifyItem();
                    break;

                case 4:
                    removeItem();
                    break;

                case 5:
                    searchForItem();
                    break;

                case 6:
                    processArrayList();
                    break;

                case 7:
                    quit = true;
                    break;

            }

        }
    }
    // prints options to the console.
    public static void printInstructions(){
        System.out.println("\n Press ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    // calls the addGroceryItem method on our groceryList object.
    public static void addItem(){
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    // takes input from the user and passes them into our modifyGroceryItem method on our GroceryList object.
    public static void modifyItem(){
        System.out.println("Enter item name: ");
        String itemNo = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    // takes user input to pass into our removeGroceryItem method.
    public static void removeItem(){
        System.out.println("Enter item name: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    // takes user input and passes it into the onFile method of our GroceryList object.
    public static void searchForItem(){
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Found " + searchItem + " in our grocery list");

        }else {
            System.out.println(searchItem + " is not in the shopping list.");
        }
    }


    // coppies our arrayList in various ways. 
    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        // The following converts an array list to an array!
        //  String[] myArray = new String[groceryList.getGroceryList().size()];
       //  myArray = groceryList.getGroceryList().toArray(myArray);

    }

}
