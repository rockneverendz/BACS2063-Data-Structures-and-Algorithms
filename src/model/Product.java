package model;

public class Product {

    protected String name;
    protected Double price;
    protected int stock;
    protected String brand;

    public Product() {
    }

    public Product(String name, Double price, int stock, String brand) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", stock=" + stock + ", brand=" + brand + '}';
    }
}
