package NB27;

import java.io.Serializable;

public class Car implements Comparable<Car>, Serializable {
    private String brand;
    private String year;
    private int mileage;

    public Car(String brand, String year, int mileage){
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public String getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "(" + brand + ", " + year + ", " + mileage + ")";
    }

    @Override
    public int compareTo(Car o) {
        return brand.compareTo(o.brand);
    }
}
