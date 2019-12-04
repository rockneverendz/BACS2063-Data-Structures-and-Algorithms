package model;

public class CPU {

    public String model;
    public int cores;
    public double clockSpeed;
    public String brand;

    public CPU() {
    }

    public CPU(String model, int cores, double clockSpeed, String brand) {
        this.model = model;
        this.cores = cores;
        this.clockSpeed = clockSpeed;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "CPU{" + "model=" + model + ", cores=" + cores + ", clockSpeed=" + clockSpeed + ", brand=" + brand + '}';
    }
}
