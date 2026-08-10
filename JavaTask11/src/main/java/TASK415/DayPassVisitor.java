package TASK415;

public class DayPassVisitor implements Payable{
    private  String name;
    private Integer age;
    private double pricePerVisit;
    private int visits;
    private Integer membershipId;


    public DayPassVisitor(int membershipId) {
        this.membershipId = membershipId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 2) {
            System.out.println("Name must be at least 2 characters.");
        } else {
            this.name = name;
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 14) {
            System.out.println("Too young to register.");
        } else if (age > 90) {
            System.out.println("Invalid age.");
        } else {
            this.age = age;
        }
    }

    public double getPricePerVisit() {
        return pricePerVisit;
    }

    public void setPricePerVisit(double pricePerVisit) {
        if (pricePerVisit > 0 && pricePerVisit <= 500) {
            this.pricePerVisit = pricePerVisit;
        } else {
            System.out.println("Price per visit must be 1–500.");
        }
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        if (visits >= 1 && visits <= 31) {
            this.visits = visits;
        } else {
            System.out.println("Visits must be 1–31.");
        }
    }

    public Integer getMembershipId() {
        return membershipId;
    }

    @Override
    public void printAllInfo() {
        System.out.println("[Day-pass] " + name + ", age " + age +
                ", ID " + membershipId + ", " + visits +
                " visits @ " + pricePerVisit + " OMR");
    }

    @Override
    public double monthlyTotal() {
        return pricePerVisit * visits;
    }
}
