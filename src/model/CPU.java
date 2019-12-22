package model;

import util.IFilter;

public class CPU {

    private String model;
    private int cores;
    private double clockSpeed;
    private String brand;

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

    public static class FilterProcessor implements IFilter<CPU> {

        private final String model;

        private final int mincores;

        private final int maxCores;

        private final double minClockSpeed;
        private final double maxClockSpeed;

        private final String brand;
        
        public FilterProcessor(String model, int mincores, int maxCores, double minClockSpeed, double maxClockSpeed, String brand) {
            this.model = model;
            this.mincores = mincores;
            this.maxCores = maxCores;
            this.minClockSpeed = minClockSpeed;
            this.maxClockSpeed = maxClockSpeed;
            this.brand = brand;
        }

        @Override
        public boolean matches(CPU element) {
            if (model != null && !model.equals(element.model)) {
                return false;
            }

            if (mincores != 0 && !(mincores <= element.cores)) {
                return false;
            }

            if (maxCores != 0 && !(element.cores >= maxCores)) {
                return false;
            }

            if (minClockSpeed != 0 && !(minClockSpeed <= element.clockSpeed)) {
                return false;
            }

            if (maxClockSpeed != 0 && !(element.clockSpeed >= maxClockSpeed)) {
                return false;
            }

            if (brand != null && !model.equals(element.brand)) {
                return false;
            }

            return true;
        }
    }
}
