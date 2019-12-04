package model;

public class Laptop extends Product {

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
    public String toString() {
        return "Laptop{" + "model=" + model + ", Processor=" + Processor + ", Graphics=" + Graphics + ", memory=" + memory + ", storage=" + storage + ", display=" + display + ", weight=" + weight + ", color=" + color + '}';
    }
}
