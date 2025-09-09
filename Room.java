package assignment1;

import java.util.*;

public class Room {
    private int roomNo;
    private String type;
    private double basePrice;
    private boolean isBooked;

    public Room(int roomNo, String type, double basePrice) {
        this.roomNo = roomNo;
        this.type = type;
        this.basePrice = basePrice;
        this.isBooked = false;
    }

    public int getRoomNo() { return roomNo; }
    public String getType() { return type; }
    public double getBasePrice() { return basePrice; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }

    public boolean checkAvailability() { return !isBooked; }

    public void book() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Room " + roomNo + " booked successfully!");
        } else {
            System.out.println("Room " + roomNo + " is already booked.");
        }
    }

    public void cancel() {
        if (isBooked) {
            isBooked = false;
            System.out.println("Booking cancelled for Room " + roomNo);
        } else {
            System.out.println("Room " + roomNo + " is not booked.");
        }
    }

    public double computeBill() { return basePrice; }

    public void displayInfo() {
        String status = isBooked ? "Yes" : "No";
        System.out.println("Room No: " + roomNo + ", Type: " + type + ", Price: " + basePrice + ", Booked: " + status);
    }
}