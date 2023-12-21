import java.util.Scanner;
// Ref: Java, A Beginner's Guide
public class OhMinseokA5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input logic for Motorcycle
        System.out.println("Enter Motorcycle Details:");

        System.out.print("Make: ");
        String mMake = sc.nextLine();

        System.out.print("Model: ");
        String mModel = sc.nextLine();

        System.out.print("Year: ");
        int mYear = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Fuel Type: ");
        String mFuelType = sc.nextLine();

        System.out.print("Price: ");
        double mPrice = sc.nextDouble();

        System.out.print("Engine Displacement: ");
        int mDisplacement = sc.nextInt();

        System.out.print("Is Off Road (true/false): ");
        boolean mOffRoad = sc.nextBoolean();
        sc.nextLine(); // consume newline left after nextBoolean()

        Motorcycle motorcycle = new Motorcycle(mMake, mModel, mYear, mFuelType, mPrice, mDisplacement, mOffRoad);


        // User input logic for Car
        System.out.println("\nEnter Car Details:");

        System.out.print("Make: ");
        String cMake = sc.nextLine();

        System.out.print("Model: ");
        String cModel = sc.nextLine();

        System.out.print("Year: ");
        int cYear = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Fuel Type: ");
        String cFuelType = sc.nextLine();

        System.out.print("Price: ");
        double cPrice = sc.nextDouble();

        System.out.print("Number of Doors: ");
        int cNumDoors = sc.nextInt();

        System.out.print("Trunk Capacity (cu ft): ");
        double cTrunkCapacity = sc.nextDouble();

        Car car = new Car(cMake, cModel, cYear, cFuelType, cPrice, cNumDoors, cTrunkCapacity);
        motorcycle.display();
        car.display();

    }
}
