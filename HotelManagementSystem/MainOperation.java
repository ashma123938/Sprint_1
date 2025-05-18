package org.example;

import org.example.entity.*;
import org.example.serviceimpl.*;

import java.util.Scanner;

public class MainOperation {

    public static void main(String[] args) {
        // Initialize service implementations (you might want to replace these with actual implementations)
        GuestServiceImpl guestService = new GuestServiceImpl();
        RoomServiceImpl roomService = new RoomServiceImpl();
        ReservationServiceImpl reservationService = new ReservationServiceImpl();
        PaymentServiceImpl paymentService = new PaymentServiceImpl();

        // Initialize the AllOperations class with service implementations
        AllOperations allOperations = new AllOperations(guestService, roomService, reservationService, paymentService);

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Menu-driven CLI
        while (true) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Add Guest");
            System.out.println("2. View Guests");
            System.out.println("3. Delete Guest");
            System.out.println("4. Add Room");
            System.out.println("5. View Rooms");
            System.out.println("6. Delete Room");
            System.out.println("7. Add Reservation");
            System.out.println("8. View Reservations");
            System.out.println("9. Delete Reservation");
            System.out.println("10. Add Payment");
            System.out.println("11. View Payments");
            System.out.println("12. Delete Payment");
            System.out.println("13. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1: // Add Guest
                    System.out.print("Enter Guest ID: ");
                    String guestId = scanner.nextLine();
                    System.out.print("Enter Guest Name: ");
                    String guestName = scanner.nextLine();
                    Guest guest = new Guest();  // Assuming Guest class has a constructor
                    allOperations.addGuest(guest);
                    break;

                case 2: // View Guests
                    allOperations.viewGuests();
                    break;

                case 3: // Delete Guest
                    System.out.print("Enter Guest ID to delete: ");
                    String deleteGuestId = scanner.nextLine();
                    allOperations.deleteGuest(deleteGuestId);
                    break;

                case 4: // Add Room
                    System.out.print("Enter Room Number: ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Enter Room Type: ");
                    String roomType = scanner.nextLine();
                    Room room = new Room(roomNumber, roomType, choice);  // Assuming Room class has a constructor
                    allOperations.addRoom(room);
                    break;

                case 5: // View Rooms
                    allOperations.viewRooms();
                    break;

                case 6: // Delete Room
                    System.out.print("Enter Room Number to delete: ");
                    String deleteRoomNumber = scanner.nextLine();
                    allOperations.deleteRoom(deleteRoomNumber);
                    break;

                case 7: // Add Reservation
                    System.out.print("Enter Reservation ID: ");
                    String reservationId = scanner.nextLine();
                    System.out.print("Enter Guest ID for Reservation: ");
                    String reservationGuestId = scanner.nextLine();
                    System.out.print("Enter Room Number for Reservation: ");
                    String reservationRoomNumber = scanner.nextLine();
                    Reservation reservation = new Reservation(reservationId, reservationGuestId, reservationRoomNumber);  // Assuming Reservation class has a constructor
                    allOperations.addReservation(reservation);
                    break;

                case 8: // View Reservations
                    allOperations.viewReservations();
                    break;

                case 9: // Delete Reservation
                    System.out.print("Enter Reservation ID to delete: ");
                    String deleteReservationId = scanner.nextLine();
                    allOperations.deleteReservation(deleteReservationId);
                    break;

                case 10: // Add Payment
                    System.out.print("Enter Payment ID: ");
                    String paymentId = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    Payment payment = new Payment();  // Assuming Payment class has a constructor
                    allOperations.addPayment(payment);
                    break;

                case 11: // View Payments
                    allOperations.viewPayments();
                    break;

                case 12: // Delete Payment
                    System.out.print("Enter Payment ID to delete: ");
                    String deletePaymentId = scanner.nextLine();
                    allOperations.deletePayment(deletePaymentId);
                    break;

                case 13: // Exit
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}
