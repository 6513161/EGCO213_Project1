package Project1_135.module;

import java.util.ArrayList;

public class Booking{

    // Create a ArrayList to hold Customer objects
    private final ArrayList<Customer> customers = new ArrayList<>();

    // Create Customer class to hold customer data
    private static class Customer{
        // Create variable
        private final int bookingID;
        private final String customerName;
        private final int night;
        private final int[] roomTypes;

        // Customer Constructor
        public Customer(int bookingID, String name, int night, int[] roomTypes) {
            this.bookingID = bookingID;
            this.customerName = name;
            this.night = night;
            this.roomTypes = roomTypes;
        }

        // Access Booking ID
        public int getBookingID() {
            return bookingID;
        }

        // Access Customer Name
        public String getCustomerName() {
            return customerName;
        }

        // Access night
        public int getNight() {
            return night;
        }

        // Access Room Types
        public int[] getRoomTypes() {
            return roomTypes;
        }

    }

    public void addBooking(int bookingID, String name, int night, int[] roomTypes) throws BookingException {

        customers.add(new Customer(bookingID, name, night, roomTypes));
    }


    // Access CustomerName of a customer by bookingID
    public String getCustomerName(int bookingID) {
        for (Customer customer : customers) {
            if (customer.getBookingID() == bookingID) {
                return customer.getCustomerName();
            }
        }
        return ""; // Default if bookingID not found
    }

    // Access night of a customer by bookingID
    public int getNight(int bookingID) {
        for (Customer customer : customers) {
            if (customer.getBookingID() == bookingID) {
                return customer.getNight();
            }
        }
        return 0; // Default if bookingID not found
    }

    // Access roomTypes of a customer by bookingID
    public int[] getRoomTypes(int bookingID) {
        for (Customer customer : customers) {
            if (customer.getBookingID() == bookingID) {
                return customer.getRoomTypes();
            }
        }
        return new int[5]; // Default if bookingID not found
    }

    // Custom Booking Exception
    public static class BookingException extends Exception {
        public BookingException(String errorMessage) {
            super(errorMessage);
        }
    }


}
