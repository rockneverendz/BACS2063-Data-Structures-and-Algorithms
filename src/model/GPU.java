package model;

import java.util.Objects;
import util.IFilter;

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
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.model);
        hash = 31 * hash + this.memory;
        hash = 31 * hash + Objects.hashCode(this.brand);
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
        final GPU other = (GPU) obj;
        if (this.memory != other.memory) {
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
        return "GPU{" + "model=" + model + ", memory=" + memory + ", brand=" + brand + '}';
    }

    public static class FilterGraphics implements IFilter<GPU> {

        private final String model;

        private final int minMemory;
        private final int maxMemory;

        private final String brand;

        public FilterGraphics() {
            this.model = null;
            this.minMemory = 0;
            this.maxMemory = 0;
            this.brand = null;
        }

        public FilterGraphics(String model, int minMemory, int maxMemory, String brand) {
            this.model = model;
            this.minMemory = minMemory;
            this.maxMemory = maxMemory;
            this.brand = brand;
        }

        @Override
        public boolean matches(GPU element) {
            if (model != null && !model.equals(element.model)) {
                return false;
            }

            if (minMemory != 0 && !(minMemory <= element.memory)) {
                return false;
            }

            if (maxMemory != 0 && !(element.memory <= maxMemory)) {
                return false;
            }

            if (brand != null && !model.equals(element.brand)) {
                return false;
            }

            return true;
        }
    }
}
