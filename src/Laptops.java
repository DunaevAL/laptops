import java.util.*;

class Notebook {
    private String brand;
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public Notebook(String brand, String model, int ram, int hdd, String os, String color) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public void printInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", RAM: " + ram + "GB, HDD: " + hdd + "GB, OS: " + os + ", Color: " + color);
    }
}

