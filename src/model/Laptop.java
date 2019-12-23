package model;

import java.util.Objects;
import model.CPU.FilterProcessor;
import model.GPU.FilterGraphics;
import util.IComparable;
import util.IComparator;
import util.IFilter;

public class Laptop
        extends Product
        implements IComparable<Laptop> {

    private String model;
    private CPU Processor;
    private GPU Graphics;
    private int memory;
    private int storage;
    private double display;
    private double weight;
    private String color;

    public Laptop() {
    }

    public Laptop(String model) {
        this.model = model;
    }

    public Laptop(String name, String brand, double price, int stock, String model, CPU Processor, GPU Graphics, int memory, int storage, double display, double weight, String color) {

        super(name, price, stock, brand);
        this.model = model;
        this.Processor = Processor;
        this.Graphics = Graphics;
        this.memory = memory;
        this.storage = storage;
        this.display = display;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CPU getProcessor() {
        return Processor;
    }

    public void setProcessor(CPU Processor) {
        this.Processor = Processor;
    }

    public GPU getGraphics() {
        return Graphics;
    }

    public void setGraphics(GPU Graphics) {
        this.Graphics = Graphics;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getDisplay() {
        return display;
    }

    public void setDisplay(double display) {
        this.display = display;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.model);
        hash = 79 * hash + Objects.hashCode(this.Processor);
        hash = 79 * hash + Objects.hashCode(this.Graphics);
        hash = 79 * hash + this.memory;
        hash = 79 * hash + this.storage;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.display) ^ (Double.doubleToLongBits(this.display) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Laptop other = (Laptop) obj;
        if (this.memory != other.memory) {
            return false;
        }
        if (this.storage != other.storage) {
            return false;
        }
        if (Double.doubleToLongBits(this.display) != Double.doubleToLongBits(other.display)) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.Processor, other.Processor)) {
            return false;
        }
        if (!Objects.equals(this.Graphics, other.Graphics)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "%-50s %-20s %20s %20s %-20s %-20s %-20s %20s %20s %20s %20s %-20s",
                name, brand, price, stock, model, Processor.getModel(), Graphics.getModel(), memory, storage, display, weight, color);
    }

    @Override
    public int compareTo(Laptop o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class SortLaptopByPrice implements IComparator<Laptop> {

        @Override
        public int compare(Laptop origin, Laptop target) {
            return origin.getPrice().compareTo(target.getPrice());
        }
    }
    
    public static class SortLaptopByModel implements IComparator<Laptop> {

        @Override
        public int compare(Laptop origin, Laptop target) {
            return origin.getModel().compareTo(target.getModel());
        }
    }

    public static class FilterLaptop implements IFilter<Laptop> {

        private String model;

        private FilterProcessor processorFilter;
        private FilterGraphics graphicsFilter;

        private int minMemory;
        private int maxMemory;

        private int minStorage;
        private int maxStorage;

        private double minDisplay;
        private double maxDisplay;

        private double minWeight;
        private double maxWeight;

        private String color;

        public FilterLaptop() {
            this.model = null;
            this.processorFilter = new FilterProcessor();
            this.graphicsFilter = new FilterGraphics();
            this.minMemory = 0;
            this.maxMemory = 0;
            this.minStorage = 0;
            this.maxStorage = 0;
            this.minDisplay = 0;
            this.maxDisplay = 0;
            this.minWeight = 0;
            this.maxWeight = 0;
            this.color = null;
        }

        public FilterLaptop(String model, FilterProcessor processorFilter, FilterGraphics graphicsFilter, int minMemory, int maxMemory, int minStorage, int maxStorage, double minDisplay, double maxDisplay, double minWeight, double maxWeight, String color) {
            this.model = model;
            this.processorFilter = processorFilter;
            this.graphicsFilter = graphicsFilter;
            this.minMemory = minMemory;
            this.maxMemory = maxMemory;
            this.minStorage = minStorage;
            this.maxStorage = maxStorage;
            this.minDisplay = minDisplay;
            this.maxDisplay = maxDisplay;
            this.minWeight = minWeight;
            this.maxWeight = maxWeight;
            this.color = color;
        }

        public FilterProcessor getProcessorFilter() {
            return processorFilter;
        }

        public void setProcessorFilter(FilterProcessor processorFilter) {
            this.processorFilter = processorFilter;
        }

        @Override
        public boolean matches(Laptop element) {
            if (model != null && !model.equals(element.model)) {
                return false;
            }

            if (processorFilter != null && !processorFilter.matches(element.Processor)) {
                return false;
            }

            if (graphicsFilter != null && !graphicsFilter.matches(element.Graphics)) {
                return false;
            }

            if (minMemory != 0 && !(minMemory <= element.memory)) {
                return false;
            }

            if (maxMemory != 0 && !(element.memory <= maxMemory)) {
                return false;
            }

            if (minStorage != 0 && !(minStorage <= element.storage)) {
                return false;
            }

            if (maxStorage != 0 && !(element.storage <= maxStorage)) {
                return false;
            }

            if (minDisplay != 0 && !(minDisplay <= element.display)) {
                return false;
            }

            if (maxDisplay != 0 && !(element.display <= maxDisplay)) {
                return false;
            }

            if (minWeight != 0 && !(minWeight <= element.weight)) {
                return false;
            }

            if (maxWeight != 0 && !(element.weight <= maxWeight)) {
                return false;
            }

            if (color != null && !color.equals(element.color)) {
                return false;
            }

            return true;
        }
    }
}
