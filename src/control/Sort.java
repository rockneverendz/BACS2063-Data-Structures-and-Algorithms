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
        System.out.println("Unsorted");
        System.out.println(ArrayImpl.toString(LaptopList));

        // Print the array sorted by price
        System.out.println("Sorting by Price");
        array.sort(LaptopList, new SortLaptopByPrice());
        System.out.println(ArrayImpl.toString(LaptopList));
        
        // Print the array sorted by model name
        System.out.println("Sorting by model name");
        array.sort(LaptopList, new SortLaptopByModel());
        System.out.println(ArrayImpl.toString(LaptopList));
    }
    
}
