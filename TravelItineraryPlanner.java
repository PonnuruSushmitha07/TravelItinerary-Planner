import java.util.ArrayList;
import java.util.Scanner;

public class TravelItineraryPlanner {

    static class Destination {
        String name;
        String startDate;
        String endDate;
        double budget;

        public Destination(String name, String startDate, String endDate, double budget) {
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.budget = budget;
        }

        @Override
        public String toString() {
            return "Destination: " + name + 
                   "\nStart Date: " + startDate + 
                   "\nEnd Date: " + endDate + 
                   "\nBudget: $" + budget;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();
        boolean exit = false;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Destination
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();

                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();

                    System.out.print("Enter budget for this destination: $");
                    double budget = scanner.nextDouble();

                    itinerary.add(new Destination(name, startDate, endDate, budget));
                    System.out.println("Destination added successfully!");
                    break;

                case 2: // View Itinerary
                    if (itinerary.isEmpty()) {
                        System.out.println("No destinations added yet.");
                    } else {
                        System.out.println("\nYour Itinerary:");
                        for (Destination dest : itinerary) {
                            System.out.println("\n" + dest);
                        }
                    }
                    break;

                case 3: // Calculate Total Budget
                    double totalBudget = 0.0;
                    for (Destination dest : itinerary) {
                        totalBudget += dest.budget;
                    }
                    System.out.printf("Total budget for your trip: $%.2f%n", totalBudget);
                    break;

                case 4: // Exit
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
