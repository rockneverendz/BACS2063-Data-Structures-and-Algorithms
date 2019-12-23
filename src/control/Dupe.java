package control;

import model.Laptop;
import util.DupeImpl;

import util.LinkedListImpl;

public class Dupe {

    public static void main(String[] args) {
        Laptop[] temp = new MockData().laptops;
        LinkedListImpl<Laptop> LaptopList = new MockData().getLinkedList();
        LinkedListImpl<Laptop> result = new LinkedListImpl();
        DupeImpl<Laptop> dupeChecker;
        
        for (int i = 0; i < temp.length; i++) {
            LaptopList.add(temp[i]);
        }
        
        
        System.out.println("With duplicates");
        System.out.println(LaptopList);
        
        final long START = System.nanoTime();
        dupeChecker = new DupeImpl(LaptopList.iterator());
        
        while (dupeChecker.hasNext()) {
            result.add(dupeChecker.next());
        }
        
        final long END = System.nanoTime();

        System.out.println("Without duplicates");
        System.out.println(result.toString());
        
        
        
        System.out.println("Time taken : " + ((END - START) / 1e+9) + "seconds");

    }
}
