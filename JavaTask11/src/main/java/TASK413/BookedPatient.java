package TASK413;

public class BookedPatient implements Attendable  {
    private String name;
    private  Integer age;
    private  Integer slotTime;

    public BookedPatient(int slotTime) {
        Integer slotTime1 = slotTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            System.out.println("Name is required .");
        } else {
            this.name = name;
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age .");
        }

    }
    public int getSlotTime() {
        return slotTime;
    }

    @Override
    public void printAllInfo() {
        System.out.println("[Booked] " + name + ", age " + age +
                ", slot " + slotTime + ", waits " + getWaitMinutes() + " min");
    }

    @Override
    public String getPriority() {
        return "Booked" ;
    }

    @Override
    public int getWaitMinutes() {
        return 10;
    }
}
