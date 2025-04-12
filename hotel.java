import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Room {
    String category;
    boolean isReserved;
    String guestName;

    public Room(String category) {
        this.category = category;
        this.isReserved = false;
        this.guestName = "";
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Room> rooms = new HashMap<>();
        rooms.put("101", new Room("Single"));
        rooms.put("102", new Room("Double"));
        rooms.put("103", new Room("Suite"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hotel Reservation System");
            System.out.println("1. Search Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Payment Processing");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    searchRooms(rooms);
                    break;
                case 2:
                    makeReservation(rooms, scanner);
                    break;
                case 3:
                    viewBookingDetails(rooms, scanner);
                    break;
                case 4:
                    paymentProcessing(rooms, scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void searchRooms(Map<String, Room> rooms) {
        System.out.println("Available Rooms:");
        for (Map.Entry<String, Room> entry : rooms.entrySet()) {
            if (!entry.getValue().isReserved) {
                System.out.println("Room No: " + entry.getKey() + ", Category: " + entry.getValue().category);
            }
        }
    }

    public static void makeReservation(Map<String, Room> rooms, Scanner scanner) {
        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();

        if (rooms.containsKey(roomNumber) && !rooms.get(roomNumber).isReserved) {
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();
            rooms.get(roomNumber).isReserved = true;
            rooms.get(roomNumber).guestName = guestName;
            System.out.println("Room reserved successfully!");
        } else {
            System.out.println("Room not available or already reserved.");
        }
    }

    public static void viewBookingDetails(Map<String, Room> rooms, Scanner scanner) {
        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();

        if (rooms.containsKey(roomNumber) && rooms.get(roomNumber).isReserved) {
            System.out.println("Room No: " + roomNumber);
            System.out.println("Guest Name: " + rooms.get(roomNumber).guestName);
            System.out.println("Category: " + rooms.get(roomNumber).category);
        } else {
            System.out.println("Room not reserved or does not exist.");
        }
    }

    public static void paymentProcessing(Map<String, Room> rooms, Scanner scanner) {
        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();

        if (rooms.containsKey(roomNumber) && rooms.get(roomNumber).isReserved) {
            System.out.println("Payment processed successfully for room " + roomNumber);
        } else {
            System.out.println("Room not reserved or does not exist.");
        }
    }
}
