import java.util.Scanner;

public class AirlineDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] layout = { {'A', 'B', 'C', 'D'},
                            {'A', 'B', 'C', 'D'},
                            {'A', 'B', 'C', 'D'},
                            {'A', 'B', 'C', 'D'},
                            {'A', 'B', 'C', 'D'} };

        while (true) {
            displaySeats(layout);
            System.out.print("Enter row (1-5) and seat (A-D), or type 'exit' to quit: ");
            String seat = scan.nextLine();

            // Check if user wants to quit
            if (seat.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            // Parse row and seat
            int row = Character.getNumericValue(seat.charAt(0)) - 1;
            char seatChar = Character.toUpperCase(seat.charAt(1));
            int col = seatChar - 'A';

            // Check if row and column are valid
            if (row >= 0 && row < 5 && col >= 0 && col < 4) {
                // Check if the seat is available
                if (layout[row][col] != 'X') {
                	// Mark the seat as taken
                	layout[row][col] = 'X'; 
                    System.out.println("Seat assigned successfully.");
                } else {
                    System.out.println("Seat is already taken, please choose another.");
                }
            } else {
                System.out.println("Invalid seat selection. Please enter a valid row and seat.");
            }
        }
        scan.close();
    }

    public static void displaySeats(char[][] plane) {
        System.out.println("  Seats Layout");
        for (int row = 0; row < plane.length; row++) {
            System.out.print("   " + (row + 1) + "  ");
            for (int col = 0; col < plane[row].length; col++) {
                System.out.print(plane[row][col] + " ");
            }
            System.out.println();
        }
    }
}
