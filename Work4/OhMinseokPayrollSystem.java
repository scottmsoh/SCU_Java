import java.util.Scanner;
import java.util.InputMismatchException;

public class OhMinseokPayrollSystem {

    // Class member variables
    private String employeeName;
    private String employeeID;
    private double hourlyRate;
    private double hoursWorked;
    private double taxRate;
    private double bonus;

    // Constructor
    public OhMinseokPayrollSystem(String employeeName, String employeeID, double hourlyRate, double hoursWorked, double taxRate) {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.taxRate = taxRate;
        this.bonus = 0; // Initialize bonus to 0
    }

    // Getter for bonus
    public double getBonus() {
        return bonus;
    }

    // Setter for bonus
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // Setter for hours worked
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Method to calculate gross pay
    public double calculateGrossPay() {
        return hourlyRate * hoursWorked;
    }

    // Method to calculate tax
    public double calculateTax() {
        return calculateGrossPay() * taxRate;
    }

    // Method to calculate bonus amount
    public double awardBonus() {
        return calculateGrossPay() * bonus;
    }

    // Method to calculate net pay
    public double calculateNetPay() {
        return calculateGrossPay() + awardBonus() - calculateTax();
    }

    // Method to display details of the employee
    public void displayEmployeeDetails() {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Gross pay: $" + calculateGrossPay());
        System.out.println("Tax Amount: $" + calculateTax());
        System.out.println("Net Pay (after bonus): $" + calculateNetPay());
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();

        // Validating and getting input for rate, tax, and hours
        double rate = getValidatedDouble("Enter hourly rate: ", scanner, 0, Double.MAX_VALUE, "Invalid hourly rate.");
        double tax = getValidatedDouble("Enter tax rate between 0.1 and 0.4 both inclusive (e.g., 0.2 for 20%): ", scanner, 0.1, 0.4, "Invalid tax rate.");
        double hours = getValidatedDouble("Enter hours worked: ", scanner, 0, Double.MAX_VALUE, "Invalid hours.");

        // Creating an employee object
        OhMinseokPayrollSystem employee = new OhMinseokPayrollSystem(name, id, rate, hours, tax);

        // Main menu loop
        while (true) {
            System.out.println("\n1. Calculate Pay");
            System.out.println("2. Award Bonus");
            System.out.println("3. Display Employee Details");
            System.out.println("4. Exit");

            int choice = getValidatedInt("Choose an option: ", scanner);

            switch (choice) {
                case 1:
                    System.out.println("Net Pay: $" + employee.calculateNetPay());
                    break;
                case 2:
                    double bonusRate = getValidatedDouble("Enter bonus percentage between 0.1 & 0.5 both inclusive (e.g., 0.2 for 20%): ", scanner, 0.1, 0.5, "Invalid bonus rate.");
                    employee.setBonus(bonusRate);
                    System.out.print("Bonus awarded: $" + employee.awardBonus());  // Assuming you have a method to get the calculated bonus amount
                    break;
                case 3:
                    employee.displayEmployeeDetails();
                    break;
                case 4:
                    System.out.println("Program Completed");
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
                    break;
            }
        }
    }

    // Input validation methods for double type
    public static double getValidatedDouble(String prompt, Scanner scanner, double min, double max, String errorMsg) {
        double value;
        while (true) {
            System.out.print(prompt);  // Use print instead of println
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println(errorMsg);
                }
            } else {
                scanner.next();  // Clear the invalid input
                System.out.println(errorMsg);
            }
        }
        return value;
    }

    // Input validation method for int type
    public static int getValidatedInt(String prompt, Scanner scanner) {
        int value;
        while (true) {
            System.out.print(prompt);  // Use print instead of println
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                break;
            } else {
                scanner.next();  // Clear the invalid input
                System.out.println("Invalid option.");
            }
        }
        return value;
    }
}