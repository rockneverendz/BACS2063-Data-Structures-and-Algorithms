package control;

import java.util.Scanner;
import model.Laptop;
import util.LinkedListImpl;
import util.TreeMap;

public class TreeSearch {

    public static void main(String[] args) {
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
}
