import java.awt.desktop.SystemSleepEvent;
import java.security.Principal;

class OhminseokA1 {

    public static void main(String[] args) {
        // Check incorrect cases if arguments are missing, or incorrect arguments in my program
        if(args.length !=3) {
            System.out.println("Usage: java OhminseokA1 principalAmount AnnualInterestRate time");
            System.out.println("\nProgram Completed.");
            System.exit(1);
        }

        // Parse arguments
        double principalAmount = Double.parseDouble(args[0]);
        double AnnualInterestRate = Double.parseDouble(args[1]);
        double time = Double.parseDouble(args[2]);

        // Insert calculation of interest
        double interest = (principalAmount * AnnualInterestRate * time) / 100;

        // Display the output
        System.out.print("principalAmount = " + principalAmount);
        System.out.print(", AnnualInterestRate = " + AnnualInterestRate);
        System.out.print(", time = " + time);
        System.out.println("\nThe simple interest is: " + interest);
        System.out.println("\nProgram Completed.");
    }
}