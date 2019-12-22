package model;

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
    public String toString() {
        return "GPU{" + "model=" + model + ", memory=" + memory + ", brand=" + brand + '}';
    }

    public static class FilterGraphics implements IFilter<GPU> {

        private final String model;

        private final int minMemory;
        private final int maxMemory;

        private final String brand;

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
