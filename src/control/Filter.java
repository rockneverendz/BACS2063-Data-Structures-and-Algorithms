package control;

import java.util.Scanner;
import model.CPU.FilterProcessor;
import model.GPU.FilterGraphics;
import model.Laptop;
import model.Laptop.FilterLaptop;

import util.FilterImpl;
import util.LinkedListImpl;

public class Filter {

    public static void main(String[] args) {
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
        System.out.print("Enter laptop brand   : ");
        model = "".equals(temp = sc.nextLine()) ? null : temp;
        System.out.print("Enter processor name : ");
        CPUmodel = "".equals(temp = sc.nextLine()) ? null : temp;
        System.out.print("Enter graphics name  : ");
        GPUmodel = "".equals(temp = sc.nextLine()) ? null : temp;
        System.out.print("Enter color          : ");
        color = "".equals(temp = sc.nextLine()) ? null : temp;
 
        FilterProcessor filterProcessor = new FilterProcessor(
                CPUmodel,
                CPUminCores,
                CPUmaxCores,
                CPUminClockSpeed,
                CPUmaxClockSpeed,
                CPUbrand
        );

        FilterGraphics filterGraphics = new FilterGraphics(
                GPUmodel,
                GPUminMemory,
                GPUmaxMemory,
                GPUbrand
        );

        FilterLaptop filterLaptop = new FilterLaptop(
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
}
