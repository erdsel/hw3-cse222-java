public class SmartPhone implements Device {
    private final String category = "Smart Phone";
    private String name;
    private double price;
    private int quantity;

    public SmartPhone(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getCategory() { return category; }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public double getPrice() { return price; }

    @Override
    public void setPrice(double price) { this.price = price; }

    @Override
    public int getQuantity() { return quantity; }

    @Override
    public void setQuantity(int quantity) { this.quantity = quantity; }


}