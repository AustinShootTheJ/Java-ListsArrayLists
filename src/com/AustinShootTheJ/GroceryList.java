package com.AustinShootTheJ;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();


    // adds an item to the arraylist using the built in add() method of the ArrayList class.
    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    // getter for the arraylist
    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    // prints out the size of the arraylist and then loops through the list printing its contents.
    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i = 0; i<groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    // takes two arguments the first is a current item input by the user and the second is an item that they wish to replace the first item with.
    // the currentItem is passed to findItem which returns the index of an item in an arraylist. Since the function returns -1 if the item is
    // not found we place a condition of >=0 for our check of position. Else the item was not found and not replacement can be made. If it
    // is found we call the overloaded modifyGroceryItem which takes two arguments position and newItem and pass the index and our user input.
    public void modifyGroceryItem(String currentItem, String newItem){
        int position = findItem(currentItem);
        if(position >= 0){
            modifyGroceryItem(position,newItem);
        }
    }

    // takes two arguments position and new item passed internally from the GroceryList class. Called from the above public method,
    // this method takes a passed index and string and sets the item at the index to our new string using the set method of the ArrayList class.
    private void modifyGroceryItem(int position, String newItem){

        groceryList.set(position,newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    // public method takes a string argument of an item input by our user and sets an int of position equal to the index result of
    // findItem called on our entered item. findItem returns the index of an ArrayList item and returns -1 if the item is not present.
    // we perform a check of position >= 0 to see if an item was found and if so we call the overloaded removeGroceryList internal method
    // on our item to remove it from the ArrayList.
    public void removeGroceryItem(String item){
        int position = findItem(item);
        if(position >= 0){
            removeGroceryItem(position);
        }
    }

    // uses the built in remove method of the ArrayList class to remove an item at the index received from the position argument.
    private void removeGroceryItem(int position){
        groceryList.remove(position);
    }

    // uses the built in indexOf() method of the ArrayList class to find the index of a String argument. Returns -1 if the
    // string is not found.
    private int findItem(String searchItem){
    return groceryList.indexOf(searchItem);

    }

    // similar to the findItem method except it only validates that an item is on the list. It calls findItem and
    // checks against the returned int. if the int is >= 0 then an item was found else it was not.
    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position >=0){
            return true;
        }
        return false;

    }

}
