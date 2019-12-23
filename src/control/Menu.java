/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.lang.System.exit;
import java.util.Scanner;
import model.Laptop;
import util.ArrayImpl;
import util.HashMapImpl;
import util.LinkedListImpl;
import util.TreeMap;

/**
 *
 * @author usert
 */
public class Menu {

    public static void main(String[] args) {

        int choice;

        System.out.println("--------------------------------");
        System.out.println("Product - Laptops Searchh Engine");
        System.out.println("--------------------------------");
        System.out.println("Menu :");

        System.out.println("1. Filter");
        System.out.println("2. Duplicate Check");
        System.out.println("3. Binary Tree Search");
        System.out.println("4. Hashing");
        System.out.println("5. Merge Sort");

        System.out.print("Please select your choice(1-4):");
        Scanner sc = new Scanner(System.in);
        choice = Integer.parseInt(sc.nextLine());

        do {
            switch (choice) {
                case 0:
                    exit(0);
                    break;

                case 1:

                    Filter();
                    break;

                case 2:
                    DuplicateCheck();
                    break;

                case 3:
                    TreeSearch();
                    break;

                case 4:
                    Hash();
                    break;

                case 5:
                    Sort();
                    break;

                default:
                    System.out.print("Error please enter again: ");
                    choice = Integer.parseInt(sc.nextLine());

            }
        } while (choice < 0 || choice > 5);

    }

    public static void Sort() {

        Laptop[] LaptopList = new MockData().laptops;
        ArrayImpl array = new ArrayImpl();

        // Print the unsorted array
        System.out.println("Unsorted");
        System.out.println(ArrayImpl.toString(LaptopList));

        // Print the array sorted by price
        System.out.println("Sorting by Price");
        array.sort(LaptopList, new Laptop.SortLaptopByPrice());
        System.out.println(ArrayImpl.toString(LaptopList));

        // Print the array sorted by model name
        System.out.println("Sorting by model name");
        array.sort(LaptopList, new Laptop.SortLaptopByModel());
        System.out.println(ArrayImpl.toString(LaptopList));

    }
    
    public static void TreeSearch(){
        LinkedListImpl<Laptop> LaptopList = new MockData().getLinkedList();
        TreeMap<String, LinkedListImpl<Laptop>> brandTree = new TreeMap<>();
       
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        
        /*
        case 1 : list exists
            add laptop
        case 2 : list doesn't exists
            add laptop into new list
        */
        LinkedListImpl<Laptop> result;
        for (Laptop laptop : LaptopList) {
            result = brandTree.get(laptop.getBrand());
            if (result != null) {
                result.add(laptop);
            } else {
                LinkedListImpl<Laptop> newList = new LinkedListImpl();
                brandTree.put(laptop.getBrand(), newList);
            }
        }

        System.out.print("Enter laptop brand : ");
        String brand = sc.nextLine();

        System.out.println(brandTree.get(brand));
    }
    
    public static void Hash(){
        LinkedListImpl<Laptop> LaptopList = new MockData().getLinkedList();
        HashMapImpl<String, Laptop> hashByName = new HashMapImpl<>();
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        for (Laptop laptop : LaptopList) {
            hashByName.put(laptop.getName(), laptop);
        }
        
        System.out.print("Enter laptop model   : ");
        String model = sc.nextLine();
        
        System.out.println(hashByName.get(model));
    }
    
    public static void Filter(){
        System.out.println("Filter in prgress...");
    }
    
    public static void DuplicateCheck(){
        System.out.println("Dupe in progress...");
    }
    
    
    

}
