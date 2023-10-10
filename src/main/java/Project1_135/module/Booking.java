//6513135 Purin Pongpanich
//6513161 Jarupat Chodsitanan
//6513163 Chalisa Buathong
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
        private int cashBack;

        // Customer Constructor
        public Customer(int bookingID, String name, int night, int[] roomTypes,int cashBack) {
            this.bookingID = bookingID;
            this.customerName = name;
            this.night = night;
            this.roomTypes = roomTypes;
            this.cashBack = cashBack;
        }

        // Set cashBack
        public void setCashBack(int cashBack) {
            this.cashBack = cashBack;
        }

        // Access cashBack
        public int getCashBack() {
            return cashBack;
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
        int cashBack = 0;

        customers.add(new Customer(bookingID, name, night, roomTypes, cashBack));
    }
    //Fetch customer cashBack
    public void fetchCustomerCashBack(int bookingID) {
        for (int i = customers.size() - 1; i >= 0; i--) {
            Customer customer = customers.get(i);
            if (customer.getBookingID() >= bookingID) {
                continue;
            }
            if (customer.getCustomerName().equals(getCustomerName(bookingID))) {
                setCashBack(bookingID, customer.getCashBack());
                break;
            }
        }
    }

    //Set cashBack
    public void setCashBack(int bookingID, int cashBack) {
        for (Customer customer : customers) {
            if (customer.getBookingID() == bookingID) {
                customer.setCashBack(cashBack);
            }
        }
    }
    //Access CustomerName of all customers
    public int[] getBookingIDs() {
        int[] bookingIDs = new int[customers.size()];
        for (int i = 0; i < customers.size(); i++) {
            bookingIDs[i] = customers.get(i).getBookingID();
        }
        return bookingIDs;
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

    // Access cashBack of a customer by bookingID
    public int getCashBack(int bookingID) {
        for (Customer customer : customers) {
            if (customer.getBookingID() == bookingID) {
                return customer.getCashBack();
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
