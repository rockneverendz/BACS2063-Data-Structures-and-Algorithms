/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.lang.System.exit;
import java.util.Scanner;
import model.CPU;
import model.GPU;
import model.Laptop;
import util.ArrayImpl;
import util.DupeImpl;
import util.FilterImpl;
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
        String cont;



        do {

            System.out.println("--------------------------------");
            System.out.println("Product - Laptops Searchh Engine");
            System.out.println("--------------------------------");
            System.out.println("Menu :");

            System.out.println("1. Filter");
            System.out.println("2. Duplicate Check");
            System.out.println("3. Binary Tree Search");
            System.out.println("4. Indexing/Hashing");
            System.out.println("5. Merge Sort");
            System.out.println("0. to Exit");

            System.out.print("Please select your choice(1-5):");
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

            System.out.println("Continue? (Y/N):");
            cont = sc.nextLine();

        } while ("Y".equals(cont));
    }

    public static void Sort() {

        Laptop[] LaptopList = new MockData().laptops;
        ArrayImpl array = new ArrayImpl();
        Scanner sc = new Scanner(System.in);
        int choice;

        // Print the unsorted array
        System.out.println("Unsorted");
        System.out.println(ArrayImpl.toString(LaptopList));

        System.out.println("Sort By: ");
        System.out.println("-------------");
        System.out.println("1. Price");
        System.out.println("2. Model Name");
        System.out.print("Please select (1/2): ");
        choice = sc.nextInt();

        if (choice == 1) {
            // Print the array sorted by price
            System.out.println("Sorting by Price");
            array.sort(LaptopList, new Laptop.SortLaptopByPrice());
            System.out.println(ArrayImpl.toString(LaptopList));
        } else {
            // Print the array sorted by model name
            System.out.println("Sorting by model name");
            array.sort(LaptopList, new Laptop.SortLaptopByModel());
            System.out.println(ArrayImpl.toString(LaptopList));
        }

    }

    public static void TreeSearch() {
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

    public static void Hash() {
        LinkedListImpl<Laptop> LaptopList = new MockData().getLinkedList();
        HashMapImpl<String, Laptop> hashByName = new HashMapImpl<>();
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        for (Laptop laptop : LaptopList) {
            hashByName.put(laptop.getName(), laptop);
        }

        System.out.print("Enter Product/Laptop name   : ");
        String model = sc.nextLine();

        System.out.println(hashByName.get(model));
    }

    public static void Filter() {
        LinkedListImpl<Laptop> LaptopList = new MockData().getLinkedList();
        LinkedListImpl<Laptop> result = new LinkedListImpl();
        FilterImpl<Laptop> filterImpl;
        String temp;
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        String model = null;
        int minMemory = 0;
        int maxMemory = 0;
        int minStorage = 0;
        int maxStorage = 0;
        double minDisplay = 0;
        double maxDisplay = 0;
        double minWeight = 0;
        double maxWeight = 0;
        String color = null;

        //CPU variables
        String CPUmodel = null;
        int CPUminCores = 0;
        int CPUmaxCores = 0;
        double CPUminClockSpeed = 0;
        double CPUmaxClockSpeed = 0;
        String CPUbrand = null;

        //GPU variables
        String GPUmodel = null;
        int GPUminMemory = 0;
        int GPUmaxMemory = 0;
        String GPUbrand = null;

        System.out.println("Leave blank to skip");
        System.out.print("Enter minimum memory (4/8/16)   : ");
        minMemory = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter processor name : ");
        CPUmodel = "".equals(temp = sc.nextLine()) ? null : temp;
        System.out.print("Enter graphics name  : ");
        GPUmodel = "".equals(temp = sc.nextLine()) ? null : temp;
        System.out.print("Enter color          : ");
        color = "".equals(temp = sc.nextLine()) ? null : temp;

        CPU.FilterProcessor filterProcessor = new CPU.FilterProcessor(
                CPUmodel,
                CPUminCores,
                CPUmaxCores,
                CPUminClockSpeed,
                CPUmaxClockSpeed,
                CPUbrand
        );

        GPU.FilterGraphics filterGraphics = new GPU.FilterGraphics(
                GPUmodel,
                GPUminMemory,
                GPUmaxMemory,
                GPUbrand
        );

        Laptop.FilterLaptop filterLaptop = new Laptop.FilterLaptop(
                model,
                filterProcessor,
                filterGraphics,
                minMemory,
                maxMemory,
                minStorage,
                maxStorage,
                minDisplay,
                maxDisplay,
                minWeight,
                maxWeight,
                color
        );

        filterImpl = new FilterImpl<>(LaptopList.iterator(), filterLaptop);

        while (filterImpl.hasNext()) {
            result.add(filterImpl.next());
        }

        System.out.println(result.toString());

    }

    public static void DuplicateCheck() {
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

    public static void TestEfficiency() {
        final long START = System.nanoTime();

        Sort();
        final long END = System.nanoTime();

        System.out.println("Time taken: " + ((END - START / 1e+9) + " seconds"));
    }

}
