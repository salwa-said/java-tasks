package TASK413;

public class WalkInVisitor implements Attendable {
    private String name;
    private Integer age;
    private Integer arrivalOrder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getArrivalOrder() {
        return arrivalOrder;
    }

    public void setArrivalOrder(Integer arrivalOrder) {
        if(arrivalOrder>0){
            this.arrivalOrder = arrivalOrder;}
        else {
            this.arrivalOrder= 1;
        }

    }

    @Override
    public void printAllInfo() {
        System.out.println("[Walk-in] " + name + ", age " + age +
                ", arrival order " + arrivalOrder +
                ", waits " + getWaitMinutes() + " min");
    }

    @Override
    public String getPriority() {
        return "Walk-in";
    }

    @Override
    public int getWaitMinutes() {
        return arrivalOrder * 15;
    }
}
