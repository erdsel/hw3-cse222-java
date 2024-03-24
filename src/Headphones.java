/**
 * {@code Headphones} sınıfı, kulaklık cihazlarını temsil eder ve {@code Device} arayüzünü uygular.
 * Kulaklıkların ismi, fiyatı ve miktarını saklar.
 */
public class Headphones implements Device {

    private String name;
    private double price;
    private int quantity;
    private final String category = "Headphones";

    /**
     * Kulaklık nesnesi oluşturur.
     *
     * @param name Kulaklığın ismi
     * @param price Kulaklığın fiyatı
     * @param quantity Kulaklık miktarı
     */
    public Headphones(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Kulaklığın kategorisini döndürür.
     *
     * @return Kulaklığın kategorisi
     */
    @Override
    public String getCategory() { return category; }

    /**
     * Kulaklığın ismini döndürür.
     *
     * @return Kulaklığın ismi
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Kulaklığın ismini ayarlar.
     *
     * @param name Yeni isim
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Kulaklığın fiyatını döndürür.
     *
     * @return Kulaklığın fiyatı
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Kulaklığın fiyatını ayarlar.
     *
     * @param price Yeni fiyat
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Kulaklığın miktarını döndürür.
     *
     * @return Kulaklık miktarı
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Kulaklığın miktarını ayarlar.
     *
     * @param quantity Yeni miktar
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
