public class Television implements Device {

    private final String category = "Television";

    private String name;
    private double price;
    private int quantity;
    public String getCategory() { return category; }
    public Television(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {

    }

    // Sınıfın içeriğini aynı şekilde doldurunuz
    // ...
}
