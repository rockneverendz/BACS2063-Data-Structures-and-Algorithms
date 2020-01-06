package control;

import java.util.Scanner;
import model.Laptop;
import util.HashMapImpl;
import util.LinkedListImpl;

public class Hash {

    public static void main(String[] args) {
        LinkedListImpl<Laptop> LaptopList = new MockData().getLinkedList();
        HashMapImpl<String, Laptop> hashByName = new HashMapImpl<>();
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        final long START = System.nanoTime();
        for (Laptop laptop : LaptopList) {
            hashByName.put(laptop.getName(), laptop);
        }
        
        
        
//        System.out.print("Enter product name   : ");
//        String model = sc.nextLine();
        
        System.out.println(hashByName.get("MSI GL63 8RD-067"));
        final long END = System.nanoTime();
        
        System.out.println("Time taken : " + ((END - START) / 1e+9) + "seconds");
        
    }
}
