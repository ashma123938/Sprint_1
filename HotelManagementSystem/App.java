package org.example;

import org.example.entity.*;
import org.example.service.*;
import org.example.serviceimpl.*;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize services
        GuestService guestService = new GuestServiceImpl();
        RoomService roomService = new RoomServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();

        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Hotel Management System");
            System.out.println("Please select an operation:");
            System.out.println("1. Manage Guests");
            System.out.println("2. Manage Rooms");
            System.out.println("3. Manage Reservations");
            System.out.println("4. Manage Payments");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            Guest guest = new Guest();
            Room room = new Room();
            Reservation reservation = new Reservation();
            Payment payment = new Payment();

            switch (choice) {
                case 1:
                    // Guest operations
                    System.out.println("1. Add Guest");
                    System.out.println("2. View Guest");
                    System.out.println("3. Delete Guest");
                    int guestChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (guestChoice) {
                        case 1:
                            System.out.print("Enter Guest ID: ");
                            guest.setGuestId(scanner.nextLine());

                            System.out.print("Enter Full Name: ");
                            guest.setFullName(scanner.nextLine());

                            System.out.print("Enter Email: ");
                            guest.setEmail(scanner.nextLine());

                            System.out.print("Enter Phone: ");
                            guest.setPhone(scanner.nextLine());

                            System.out.print("Enter Address: ");
                            guest.setAddress(scanner.nextLine());

                            System.out.print("Enter Gender: ");
                            guest.setGender(scanner.nextLine());

                            try {
                                guestService.addGuest(guest);
                                System.out.println("Guest added successfully!");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            guestService.viewGuest();
                            break;

                        case 3:
                            System.out.print("Enter Guest ID to delete: ");
                            String deleteGuestId = scanner.nextLine();
                            guestService.deleteGuest(deleteGuestId);
                            break;

                        default:
                            System.out.println("Invalid option!");
                    }
                    break;

                case 2:
                    // Room operations
                    System.out.println("1. Add Room");
                    System.out.println("2. View Room");
                    System.out.println("3. Delete Room");
                    int roomChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (roomChoice) {
                        case 1:
                            System.out.print("Enter Room Number: ");
                            room.setRoomNumber(scanner.nextLine());

                            System.out.print("Enter Room Type (e.g., Single, Double): ");
                            room.setRoomType(scanner.nextLine());

                            System.out.print("Enter Price Per Night: ");
                            room.setPricePerNight(Double.parseDouble(scanner.nextLine()));

                            try {
                                roomService.addRoom(room);
                                System.out.println("Room added successfully!");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            roomService.viewRoom();
                            break;

                        case 3:
                            System.out.print("Enter Room Number to delete: ");
                            String deleteRoomNumber = scanner.nextLine();
                            roomService.deleteRoom(deleteRoomNumber);
                            break;

                        default:
                            System.out.println("Invalid option!");
                    }
                    break;

                case 3:
                    // Reservation operations
                    System.out.println("1. Add Reservation");
                    System.out.println("2. View Reservation");
                    System.out.println("3. Delete Reservation");
                    int reservationChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (reservationChoice) {
                        case 1:
                            System.out.print("Enter Reservation ID: ");
                            reservation.setReservationId(scanner.nextLine());

                            System.out.print("Enter Customer ID: ");
                            reservation.setCustomerId(scanner.nextLine());

                            System.out.print("Enter Room Number: ");
                            reservation.setRoomNumber(scanner.nextLine());

                            System.out.print("Enter Check-in Date (yyyy-mm-dd): ");
                            reservation.setCheckInDate(scanner.nextLine());

                            System.out.print("Enter Check-out Date (yyyy-mm-dd): ");
                            reservation.setCheckOutDate(scanner.nextLine());

                            try {
                                reservationService.addReservation(reservation);
                                System.out.println("Reservation added successfully!");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            reservationService.viewReservation();
                            break;

                        case 3:
                            System.out.print("Enter Reservation ID to delete: ");
                            String deleteReservationId = scanner.nextLine();
                            reservationService.deleteReservation(deleteReservationId);
                            break;

                        default:
                            System.out.println("Invalid option!");
                    }
                    break;

                case 4:
                    // Payment operations
                    System.out.println("1. Add Payment");
                    System.out.println("2. View Payment");
                    System.out.println("3. Delete Payment");
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (paymentChoice) {
                        case 1:
                            System.out.print("Enter Payment ID: ");
                            payment.setPaymentId(scanner.nextLine());

                            System.out.print("Enter Amount: ");
                            payment.setAmount(Double.parseDouble(scanner.nextLine()));

                            System.out.print("Enter Payment Method (e.g., Cash, Card, UPI): ");
                            payment.setMethod(scanner.nextLine());

                            try {
                                paymentService.addPayment(payment);
                                System.out.println("Payment added successfully!");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            paymentService.viewPayment();
                            break;

                        case 3:
                            System.out.print("Enter Payment ID to delete: ");
                            String deletePaymentId = scanner.nextLine();
                            paymentService.deletePayment(deletePaymentId);
                            break;

                        default:
                            System.out.println("Invalid option!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
