public class Motorcycle extends Vehicle {
    private int displacement;
    private boolean offRoad;


    public Motorcycle(String make, String model, int year, String fuelType, double price, int displacement, boolean offRoad) {
        super(make, model, year, fuelType, price);
        this.displacement = displacement;
        this.offRoad = offRoad;
    }

    @Override
    public void display() {
        System.out.println("\nMotorcycle Information:");
        super.printInfo();
        System.out.println("Engine Displacement: " + displacement + " cc");
        System.out.println("Is Off Road: " + offRoad);
        System.out.println("Tax: $" + computeTax());
    }

    public double computeTax() {
        double tax;
        if (displacement < 500) {
            tax = 50;
        } else {
            tax = 100;
        }

        if (offRoad) {
            tax = tax * 0.5;
        }
        return tax;
    }

}
