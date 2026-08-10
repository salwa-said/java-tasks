package TASK414;

public class Motorbike implements Rentable{
    private String color;
    private String plate;
    private Integer dailyRate;
    private Integer rentalDays;
    private Integer engineSize;
    // for car  only getter
    public Motorbike(String color) {
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

    public Integer getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Integer engineSize) {
        if (engineSize >= 50 && engineSize <= 1500) {
            this.engineSize = engineSize;
        } else {
            System.out.println("Invalid size of engine");
        }

    }
    @Override
    public void printAllInfo() {
        System.out.println("[Motorbike] Plate " + plate + ", " + engineSize + "cc, " +
                color + ", " + dailyRate + " OMR/day, " +
                rentalDays + " days");
    }

    @Override
    public double costFor(int days) {
        return dailyRate * days; // no insurance fee
    }


}
