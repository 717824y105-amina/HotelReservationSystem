package assignment1;

import java.util.Scanner;

public class HotelMainApp {
    public static void main(String[] args) {
        BookingService service = new BookingService();

        service.addRoom(new Room(101, "Standard", 1500));
        service.addRoom(new DeluxeRoom(102, 2500, true, 300));
        service.addRoom(new SuiteRoom(201, 5000, true, 500));
        service.addRoom(new DeluxeRoom(103, 2800, false, 400));

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nHotel Booking Menu");
            System.out.println("1. View Availability");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Generate Invoice");
            System.out.println("5. Daily Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    service.viewAvailability();
                    break;
                case 2:
                    System.out.print("Enter Room No to Book: ");
                    int bookNo = sc.nextInt();
                    Room roomToBook = service.findRoom(bookNo);
                    if (roomToBook != null) {
                        if (roomToBook instanceof DeluxeRoom) {
                            ((DeluxeRoom) roomToBook).book(true, "DISC10");
                        } else {
                            roomToBook.book();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Room No to Cancel: ");
                    int cancelNo = sc.nextInt();
                    Room roomToCancel = service.findRoom(cancelNo);
                    if (roomToCancel != null) roomToCancel.cancel();
                    break;
                case 4:
                    System.out.print("Enter Room No for Invoice: ");
                    int invoiceNo = sc.nextInt();
                    service.generateInvoice(invoiceNo);
                    break;
                case 5:
                    service.dailyReport();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 0);

        sc.close();
    }
}
