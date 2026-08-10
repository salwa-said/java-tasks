package TASK412;

public class Service implements Sellable {
    private  String name;
    private  double price;
    private double minutes;

    public Service(String name, double price, Integer minutes) {
        setName(name);
        setPrice(price);
        setMinutes(minutes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            System.out.println("Name cannot be empty.");
            // keep old value
        } else {
            this.name = name;
        }
    }

    @Override
    public void printAllInfo() {

    }

    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return "Service" ;
    }

    public void setPrice(double price) {
        if (price>0){
            this.price = price;
        }else {
            System.out.println("Invalid price.");
        }

    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}
