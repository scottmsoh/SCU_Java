public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String fuelType;
    protected double price;

    public Vehicle(String make, String model, int year, String fuelType, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.price = price;
    }

    public abstract void display();

    protected void printInfo() {
        System.out.println("Vehicle Information:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Price: $" + price);
    }
}
