package control;

import model.Laptop;
import model.Laptop.SortLaptopByModel;
import model.Laptop.SortLaptopByPrice;
import util.ArrayImpl;

public class Sort {

    public static void main(String[] args) {
        Laptop[] LaptopList = new MockData().laptops;
        ArrayImpl array = new ArrayImpl();
        
        // Print the unsorted array
//        System.out.println("Unsorted");
//        System.out.println(ArrayImpl.toString(LaptopList));

        
        final long START = System.nanoTime();
        // Print the array sorted by price
        System.out.println("Sorting by Price");
        array.sort(LaptopList, new SortLaptopByPrice());
        ArrayImpl.toString(LaptopList);
        final long END = System.nanoTime();
        
        System.out.println("Time taken : " + ((END - START) / 1e+9) + "seconds");
        
        // Print the array sorted by model name
//        System.out.println("Sorting by model name");
//        array.sort(LaptopList, new SortLaptopByModel());
//        System.out.println(ArrayImpl.toString(LaptopList));
    }
    
}
