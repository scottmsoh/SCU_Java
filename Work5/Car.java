public class Car extends Vehicle {
    private int numDoors;
    private double trunkCapacity;

    public Car(String make, String model, int year, String fuelType, double price, int numDoors, double trunkCapacity) {
        super(make, model, year, fuelType, price);
        this.numDoors = numDoors;
        this.trunkCapacity = trunkCapacity;
    }

    @Override
    public void display() {
        System.out.println("\nCar Information:");
        super.printInfo();
        System.out.println("Number of Doors: " + numDoors);
        System.out.println("Trunk Capacity: " + trunkCapacity + " cu ft");
        System.out.println("Insurance Premium: $" + computeInsurancePremium());
    }

    public double computeInsurancePremium() {
        return numDoors * 100 + trunkCapacity * 10;  // Example insurance computation
    }
}
