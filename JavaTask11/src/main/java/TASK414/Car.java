package TASK414;

import TASK411.LibraryItem;

public class Car implements Rentable {
    private String color;
    private String plate;
    private Integer dailyRate;
    private Integer rentalDays;
    private  Integer seats;

    public Car(String color) {
        this.color = color;
    }


    public String getColor() {
        return color;
    }



    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        if (plate == null || plate.equals("")) {
            System.out.println("plate cannot be empty.");
        } else {
            this.plate = plate;
        }
    }

    public Integer getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Integer dailyRate) {
        if (dailyRate >= 0 && dailyRate <= 200) {
            this.dailyRate = dailyRate;
        } else {
            System.out.println("Invalid daily Rate.");
        }

    }

    public Integer getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(Integer rentalDays) {

        if (rentalDays >= 0 && rentalDays <= 30) {
            this.rentalDays = rentalDays;
        } else {
            System.out.println("Rental days must within 1 to 30 days only");
        }
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        if (seats >= 2 && seats <= 7) {
            this.seats = seats;
        } else {
            System.out.println("Invalid number of seats");
        }
    }


    @Override
    public void printAllInfo() {
        System.out.println("[Car] Plate " + plate + ", " + seats + " seats, " +
                color + ", " + dailyRate + " OMR/day, " +
                rentalDays + " days");
    }

    @Override
    public double costFor(int days) {
        return (dailyRate * days) + 5.0;
    }



}
