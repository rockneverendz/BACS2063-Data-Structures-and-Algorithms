package model;

public class GPU {

    private String model;
    private int memory;
    private String brand;

    public GPU() {
    }

    public GPU(String model, int memory, String brand) {
        this.model = model;
        this.memory = memory;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "GPU{" + "model=" + model + ", memory=" + memory + ", brand=" + brand + '}';
    }
}
