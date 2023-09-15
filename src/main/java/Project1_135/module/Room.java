package Project1_135.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {

    // Create a ArrayList to hold RoomDetails objects
    private final ArrayList<RoomDetails> roomList = new ArrayList<>();
    // Create a RoomDetails class to hold room details
    private static class RoomDetails implements Comparable<RoomDetails> {
        // Create variable
        private final String roomType;
        private final double price;
        private final double vatPrice;
        private double totalSaleInCash;
        private int totalSaleInUnit;

        // RoomDetails Constructor
        public RoomDetails(String roomType, double price) {
            this.roomType = roomType;
            this.price = price;
            double serviceCharge = price * 0.1;
            double vat = (serviceCharge + price) * 0.07;
            this.vatPrice = price + serviceCharge + vat;
        }

        // Access Price
        public double getPrice() {
            return price;
        }

        // Access Vat Price
        public double getVatPrice() {
            return vatPrice;
        }

        // Access Room Type
        public String getRoomType() {
            return roomType;
        }

        // Print room result
        public void printResult(){
            String output = String.format("%-19s total sale = %,6d rooms %,15.2f Baht",roomType,totalSaleInUnit,totalSaleInCash);
                    System.out.println(output);
        }

        @Override
        public int compareTo(RoomDetails other) {

            //compare totalSaleInUnit
            if (this.totalSaleInUnit < other.totalSaleInUnit) {
                return 1;

            }
            else if(this.totalSaleInUnit > other.totalSaleInUnit) {
                return -1;
            }

            //compare totalSaleInCash
            if (this.totalSaleInCash < other.totalSaleInCash) {
                return 1;

            }
            else if(this.totalSaleInCash > other.totalSaleInCash) {
                return -1;
            }

            return 0;
        }
    }

    // Add a room with its price
    public void addRoom(String roomType, double price) throws RoomException {
        // Custom RoomException
        if (price < 0) {
            throw new RoomException(String.format("Price cannot be negative: %.2f", price));
        }

        // Create a RoomDetails object and store it in the list
        roomList.add(new RoomDetails(roomType, price));
    }

    // Sort RoomDetails
    public void sortRoom(){

        Collections.sort(roomList);
    }

    // Print Room result
    public void printResult(){
        for (RoomDetails room : roomList) {
            room.printResult();
        }
        System.out.println();
    }

    // Access roomType as list
    public List<String> getRoomTypes() {
        List<String> roomTypes = new ArrayList<>();
        for (int i = 0; i < roomList.size(); i++) {
            roomTypes.add("Room " + (i + 1));
        }
        return roomTypes;
    }

    // Access the price of a room by roomType
    public double getPrice(String roomType) throws RoomException{
        for (RoomDetails roomDetail : roomList) {
            if (roomDetail.getRoomType().equals(roomType)) {
                return roomDetail.getPrice();
            }
        }
        throw new RoomException("Room type not found: " + roomType);
    }

    // Access the VAT price of a room by roomType
    public double getVatPrice(String roomType) throws RoomException{
        for (RoomDetails roomDetail : roomList) {
            if (roomDetail.getRoomType().equals(roomType)) {
                return roomDetail.getVatPrice();
            }
        }
        throw new RoomException("Room type not found: " + roomType);
    }


    // Print all room data
    public void print() {
        for (RoomDetails roomDetail : roomList) {
            String output = String.format("%-21s rate =%,10.2f      rate++ =%,10.2f",
                    roomDetail.getRoomType(), roomDetail.getPrice(), roomDetail.getVatPrice());
            System.out.println(output);
        }
    }

    // Custom Room Exception
    public static class RoomException extends Exception {
        public RoomException(String errorMessage) {
            super(errorMessage);
        }
    }
}
