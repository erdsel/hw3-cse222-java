/**
 * {@code Laptop} sınıfı, kulaklık cihazlarını temsil eder ve {@code Device} arayüzünü uygular.
 * Laptopların ismi, fiyatı ve miktarını saklar.
 */public class Laptop implements Device {

    private String name;
    private double price;
    private int quantity;
    private final String category = "Laptop";
    /**
     * Laptop nesnesi oluşturur.
     *
     * @param name Laptopun ismi
     * @param price Laptopun fiyatı
     * @param quantity Laptop miktarı
     */
    public Laptop(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    /**
     * Laptopun kategorisini döndürür.
     *
     * @return Laptopun kategorisi
     */

    @Override
    public String getCategory() {
        return category;
    }
    /**
     * Laptopun ismini döndürür.
     *
     * @return Laptopun ismi
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Laptopun ismini ayarlar.
     *
     * @param name Yeni isim
     */
    @Override
    public void setName(String name) {
this.name= name;
    }
    /**
     * Laptopun fiyatını döndürür.
     *
     * @return Laptopun fiyatı
     */
    @Override
    public double getPrice() {
        return price;
    }
    /**
     * Laptopun fiyatını ayarlar.
     *
     * @param price Yeni fiyat
     */
    @Override
    public void setPrice(double price) {
this.price=price;
    }
    /**
     * Laptopun miktarını döndürür.
     *
     * @return Laptop miktarı
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    /**
     * Laptopun miktarını ayarlar.
     *
     * @param quantity Yeni miktar
     */
    @Override
    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }



}