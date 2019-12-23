package model;

import java.util.Objects;
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
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.model);
        hash = 89 * hash + this.cores;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.clockSpeed) ^ (Double.doubleToLongBits(this.clockSpeed) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.brand);
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
        final CPU other = (CPU) obj;
        if (this.cores != other.cores) {
            return false;
        }
        if (Double.doubleToLongBits(this.clockSpeed) != Double.doubleToLongBits(other.clockSpeed)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CPU{" + "model=" + model + ", cores=" + cores + ", clockSpeed=" + clockSpeed + ", brand=" + brand + '}';
    }

    public static class FilterProcessor implements IFilter<CPU> {

        private String model;

        private int mincores;

        private int maxCores;

        private double minClockSpeed;
        private double maxClockSpeed;

        private String brand;

        public FilterProcessor() {
            this.model = null;
            this.mincores = 0;
            this.maxCores = 0;
            this.minClockSpeed = 0;
            this.maxClockSpeed = 0;
            this.brand = null;
        }
        
        public FilterProcessor(String model, int mincores, int maxCores, double minClockSpeed, double maxClockSpeed, String brand) {
            this.model = model;
            this.mincores = mincores;
            this.maxCores = maxCores;
            this.minClockSpeed = minClockSpeed;
            this.maxClockSpeed = maxClockSpeed;
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
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
