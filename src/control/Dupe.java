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
        
        dupeChecker = new DupeImpl(LaptopList.iterator());
        
        while (dupeChecker.hasNext()) {
            result.add(dupeChecker.next());
        }

        System.out.println("Without duplicates");
        System.out.println(result.toString());

    }
}
