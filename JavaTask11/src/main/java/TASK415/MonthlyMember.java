package TASK415;

public class MonthlyMember implements Payable{
    private String name;
    private  Integer age;
    private  double monthlyFee;
    private Integer membershipId;

    public MonthlyMember(int membershipId) {
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

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        if (monthlyFee > 0 && monthlyFee <= 500) {
            this.monthlyFee = monthlyFee;
        } else {
            System.out.println("Monthly fee must be 1–500.");
        }
    }

    @Override
    public void printAllInfo() {
        System.out.println("[Monthly] " + name + ", age " + age +
                ", ID " + membershipId + ", fee " + monthlyFee + " OMR");
    }

    @Override
    public double monthlyTotal() {
        return monthlyFee;
    }

    public Integer getMembershipId() {
        return membershipId;
    }
}


