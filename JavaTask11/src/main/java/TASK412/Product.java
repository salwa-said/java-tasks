package TASK412;

public class Product implements Sellable {
   private  String name;
   private  double price;
   private Integer quantity;


   public Product(String name, double price, Integer quantity){
       setName(name);
       setPrice(price);
       setQuantity(quantity);
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            System.out.println("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    @Override
    public void printAllInfo() {
        System.out.println("Product: " + name + " | " + price + " OMR | qty " + quantity);
    }

    public double getPrice() {
        return price * quantity;
    }

    @Override
    public String getCategory() {
        return "Product";
    }

    public void setPrice(double price) {
        if (price >= 0 && price <= 10000) {
            this.price = price;
        } else {
            System.out.println("Price out of range.");
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        if (quantity >= 1 && quantity <= 100) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity must be 1 to 100 .");
        }
    }
}
