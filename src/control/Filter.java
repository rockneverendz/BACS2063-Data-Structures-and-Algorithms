package control;

import java.util.Iterator;
import model.CPU.FilterProcessor;
import model.GPU.FilterGraphics;
import model.Laptop;
import model.Laptop.FilterLaptop;

import util.FilterImpl;
import util.LinkedListImpl;

public class Filter {

    public static void main(String[] args) {
        /*
        get user filter criteria
        make a filter out of the requirements
        use filter through the datalist
        return filtered result
         */
        //Laptop variables
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
        int GPUmaxMemory = 2;
        String GPUbrand = null;

        FilterProcessor fp = new FilterProcessor(
                CPUmodel,
                CPUminCores,
                CPUmaxCores,
                CPUminClockSpeed,
                CPUmaxClockSpeed,
                CPUbrand
        );

        FilterGraphics fg = new FilterGraphics(
                GPUmodel,
                GPUminMemory,
                GPUmaxMemory,
                GPUbrand
        );

        FilterLaptop fl = new FilterLaptop(
                model,
                fp,
                fg,
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
        
        MockData md = new MockData();
        LinkedListImpl<Laptop> ll = md.getLinkedList();
        LinkedListImpl<Laptop>  llresult = new LinkedListImpl();
        Iterator lli = ll.iterator();

        FilterImpl<Laptop> filterImpl = new FilterImpl<>(lli, fl);

        while (filterImpl.hasNext()){
            llresult.add(filterImpl.next());
        }
        
        System.out.println(llresult.toString());
    }
}
