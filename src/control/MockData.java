package control;

import model.CPU;
import model.GPU;
import model.Laptop;
import util.LinkedListImpl;

public class MockData {
//Variables declaration

    CPU processors[] = {
        new CPU("AMD A6", 500, 2.7, "AMD "), //0
        new CPU("AMD A8", 2, 2.7, "AMD "),
        new CPU("AMD A9", 2, 2.7, "AMD "),
        new CPU("AMD A10", 2, 2.9, "AMD"),
        new CPU("AMD A12", 2, 2.9, "AMD"),
        new CPU("AMD E1", 2, 2.9, "AMD"), //5
        new CPU("AMD E2", 2, 2.9, "AMD"),
        new CPU("Intel Celeron", 2, 3.0, "Intel"), //7
        new CPU("Intel Pentium", 2, 3.0, "Intel"),
        new CPU("Intel Core i3", 2, 3.0, "Intel"),
        new CPU("Intel Core i5", 2, 4.2, "Intel"), //10
        new CPU("Intel Core i7", 2, 4.2, "Intel"),
        new CPU("Intel Core i9", 2, 4.8, "Intel")
    };        //12

    GPU graphics[] = {
        new GPU("GeForce RTX", 4, "Nvidia"), //0
        new GPU("GeForce GTX", 3, "Nvidia"),
        new GPU("Radeon Vega", 4, "AMD"),
        new GPU("Radeon RX", 4, "AMD"), //3
        new GPU("Radeon R9", 3, "AMD"),
        new GPU("Radeon R7", 2, "AMD"),
        new GPU("Radeon R5", 2, "AMD")
    };       //6

    Laptop laptops[] = {
        new Laptop("Asus ZenBook 14", "Asus", 2099.00, 42, "ZenBook 14", processors[7], graphics[6], 4, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus ZenBook Flip 14", "Asus", 3500.00, 56, "ZenBook Flip 14", processors[8], graphics[6], 4, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus VivoBook 14 X403", "Asus", 3559.00, 61, "ROG Zephyrus G GA502", processors[10], graphics[6], 4, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus ROG Zephyrus M GU502", "Asus", 3299.00, 24, "VivoBook 14 X403", processors[9], graphics[5], 4, 256, 15.00, 1.19, "Black"),
        new Laptop("Asus ROG Zephyrus G GA502", "Asus", 3499.00, 32, "ROG Zephyrus M GU502", processors[10], graphics[4], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Asus VivoBook 14 X412FA-E", "Asus", 2599.00, 30, "VivoBook 14 X412FA-E", processors[10], graphics[4], 8, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus VivoBook 14 X412", "Asus", 2799.00, 40, "VivoBook 14 X412", processors[10], graphics[1], 8, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus ROG Strix SCAR II", "Asus", 3499.00, 48, "ROG Strix SCAR II", processors[10], graphics[1], 16, 256, 15.00, 1.19, "Black"),
        new Laptop("Dell XPS 13 2-in-1 7390", "Dell", 2599.00, 59, "XPS 13 2-in-1 7390", processors[9], graphics[6], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Dell G7 15 7590", "Asus", 3499.00, 71, "G7 15 7590", processors[2], graphics[4], 4, 256, 15.00, 1.19, "Black"),
        new Laptop("Dell Inspiron 15 5580", "Asus", 2099.00, 33, "Inspiron 15 5580", processors[8], graphics[6], 4, 256, 15.00, 1.19, "Black"),
        new Laptop("Dell Inspiron I5481-5076GRY", "Asus", 2599.00, 13, "Inspiron I5481-5076GRY", processors[7], graphics[5], 4, 256, 15.00, 1.19, "Black"),
        new Laptop("Dell G3579-5958BLK", "Asus", 3499.00, 53, "G3579-5958BLK", processors[0], graphics[6], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Dell ChromeBook C3181-C895GRY", "Asus", 3299.00, 76, "ChromeBook C3181-C895GRY ", processors[10], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Dell Inspiron 7375", "Asus", 3499.00, 14, "Inspiron 7375", processors[8], graphics[1], 4, 256, 15.00, 1.19, "Black"),
        new Laptop("Dell Inspiron 15 I5570-5262SLV", "Asus", 3559.00, 65, "Inspiron 15 I5570-5262SLV", processors[11], graphics[3], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("HP 15Q-DS0029TU", "HP", 2599.00, 67, "15Q-DS0029TU", processors[11], graphics[3], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("HP Pavilion 15-BC444TX", "HP", 3499.00, 10, "Pavilion 15-BC444TX", processors[0], graphics[0], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("HP Spectre x360 LTE", "HP", 2099.00, 69, "Spectre x360 LTE", processors[4], graphics[5], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("HP ZBook 17 G6", "HP", 2599.00, 10, "ZBook 17 G6", processors[1], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("HP Spectre x360 13-ap010", "HP", 3499.00, 15, "Spectre x360 13-ap010", processors[2], graphics[0], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("HP Notebook 15-da0295tu", "HP", 3299.00, 51, "Notebook 15-da0295tu ", processors[7], graphics[0], 16, 256, 15.00, 1.19, "Black"),
        new Laptop("HP Omen X 2S", "HP", 3499.00, 27, "Omen X 2S", processors[8], graphics[2], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("HP Envy x360 13-AG0035AU", "HP", 3559.00, 11, "Envy x360 13-AG0035AU", processors[4], graphics[6], 16, 256, 15.00, 1.19, "Black"),
        new Laptop("MSI Modern 14 A10M", "MSI", 2099.00, 30, "Modern 14 A10M", processors[9], graphics[0], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("MSI Modern 15 A10RB", "MSI", 2599.00, 45, "Modern 15 A10RB", processors[5], graphics[0], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("MSI GT76 DT-9SG Titan", "MSI", 3499.00, 75, "GT76 DT-9SG Titan", processors[2], graphics[0], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("MSI PS63 Modern 8RC", "MSI", 3299.00, 21, "PS63 Modern 8RC  ", processors[9], graphics[1], 16, 256, 15.00, 1.19, "Black"),
        new Laptop("MSI Stealth GS73", "MSI", 2599.00, 42, "Stealth GS73", processors[1], graphics[1], 16, 256, 15.00, 1.19, "Black"),
        new Laptop("MSI Stealth GS65", "MSI", 3499.00, 74, "Stealth GS65", processors[7], graphics[1], 16, 256, 15.00, 1.19, "Black"),
        new Laptop("MSI Raider GE73", "MSI", 3299.00, 34, "Raider GE73", processors[7], graphics[1], 16, 256, 15.00, 1.19, "Black"),
        new Laptop("MSI GL63 8RD-067", "MSI", 3499.00, 30, "GL63 8RD-067", processors[7], graphics[1], 16, 256, 15.00, 1.19, "Black"),
        new Laptop("Lenovo Legion Y740", "Lenovo", 2099.00, 62, "Legion Y740", processors[2], graphics[4], 4, 256, 15.00, 1.19, "Black"),
        new Laptop("Lenovo Yoga S940", "Lenovo", 3500.00, 44, "Yoga S940", processors[8], graphics[4], 4, 256, 15.00, 1.19, "Black"),
        new Laptop("Lenovo Lenovo Ideapad 330-15ARR", "Lenovo", 3559.00, 34, "Lenovo Ideapad 330-15ARR", processors[9], graphics[3], 4, 256, 15.00, 1.19, "Black"),
        new Laptop("Lenovo Ideapad 330-151IGM", "Lenovo", 3299.00, 44, "Ideapad 330-151IGM", processors[0], graphics[3], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Lenovo ThinkPad X1 Extreme", "Lenovo", 3499.00, 78, "ThinkPad X1 Extreme", processors[6], graphics[2], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Lenovo IdeaPad", "Lenovo", 2599.00, 59, "IdeaPad", processors[3], graphics[2], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Lenovo Yoga 20LES4S500", "Lenovo", 2799.00, 77, "Yoga 20LES4S500", processors[8], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Lenovo IdeaPad 330-15ARR", "Lenovo", 3499.00, 66, "IdeaPad 330-15ARR", processors[4], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Apple MacBook Air MREA2HN/A", "Apple", 4499.00, 66, "MacBook Air MREA2HN/A", processors[11], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Apple MacBook Air MRE82HN/A", "Apple", 4499.00, 66, "MacBook Air MRE82HN/A", processors[11], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Apple MacBook Air MREC2HN/A", "Apple", 4499.00, 66, "MacBook Air MREC2HN/A", processors[11], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Apple MacBook Air MREE2HN/A", "Apple", 5499.00, 66, "MacBook Air MREE2HN/A", processors[11], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Apple MacBook Air MRE92HN/A", "Apple", 5499.00, 66, "MacBook Air MRE92HN/A", processors[12], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Apple MacBook Pro MR932HN/A", "Apple", 4499.00, 66, "MacBook Pro MR932HN/A", processors[11], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Apple MacBook Pro MR962HN/A", "Apple", 5499.00, 66, "MacBook Pro MR962HN/A", processors[12], graphics[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Apple MacBook Pro MR9Q2HN/A", "Apple", 5499.00, 66, "MacBook Pro MR9Q2HN/A", processors[12], graphics[1], 8, 256, 15.00, 1.19, "Black")
    };

    public MockData() {
    }

    public LinkedListImpl<Laptop> getLinkedList() {
        LinkedListImpl<Laptop> laptopsList = new LinkedListImpl<>();

        for (int i = 0; i < laptops.length; i++) {
            laptopsList.add(laptops[i]);
        }

        return laptopsList;
    }

}
