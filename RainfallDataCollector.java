import java.util.Scanner;

public class RainfallDataCollector {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int numYears;

        // Input validation for the number of years
        do {
            System.out.print("Enter the number of years (must be at least 1): ");
            numYears = scanner.nextInt();
        } while (numYears < 1);

        double totalRainfall = 0;
        
        // Total months
        int totalMonths = numYears * 12; 

        // For each year
        for (int year = 1; year <= numYears; year++) {
            System.out.println("\nYear " + year + ":");

            // For each month
            for (int month = 1; month <= 12; month++) {
                double rainfall;

                // Input validation for monthly rainfall
                do {
                    System.out.print("Enter the rainfall for month " + month + " (in inches, must be 0 or more): ");
                    rainfall = scanner.nextDouble();
                    if (rainfall < 0) {
                        System.out.println("Rainfall cannot be negative. Please enter a valid amount.");
                    }
                } while (rainfall < 0);

                totalRainfall += rainfall; // Total rainfall
            }
        }

        // Average rainfall
        double averageRainfall = totalMonths > 0 ? totalRainfall / totalMonths : 0;

        // The results
        System.out.println("\nNumber of months: " + totalMonths);
        System.out.printf("Total inches of rainfall over %d years: %.2f inches%n", numYears, totalRainfall);
        System.out.printf("Average monthly rainfall: %.2f inches%n", averageRainfall);

        scanner.close();


	}

}
