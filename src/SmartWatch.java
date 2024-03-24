/**
 * {@code SmartWatch} sınıfı, akıllı saat cihazlarını temsil eder ve {@code Device} arayüzünü uygular.
 * Akıllı saatlerin ismi, fiyatı ve miktarını saklar.
 */
public class SmartWatch implements Device {

    private final String category = "SmartWatch";

    private String name;
    private double price;
    private int quantity;
    /**
     * Akıllı saat nesnesi oluşturur.
     *
     * @param name Akıllı saatlerin ismi
     * @param price Akıllı saatlerin fiyatı
     * @param quantity Akıllı saat miktarı
     */
    public SmartWatch(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    /**
     * Akıllı saatlerin kategorisini döndürür.
     *
     * @return Akıllı saatlerin kategorisi
     */
    @Override
    public String getCategory() {
        return category;
    }
    /**
     * Akıllı saatlerin ismini döndürür.
     *
     * @return Akıllı saatlerin ismi
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Akıllı saatlerin ismini ayarlar.
     *
     * @param name Yeni isim
     */
    @Override
    public void setName(String name) {

    }
    /**
     * Akıllı saatlerin fiyatını döndürür.
     *
     * @return Akıllı saatlerin fiyatı
     */
    @Override
    public double getPrice() {
        return price;
    }
    /**
     * Akıllı saatlerin fiyatını ayarlar.
     *
     * @param price Yeni fiyat
     */
    @Override
    public void setPrice(double price) {
        this.price=price;

    }
    /**
     * Akıllı saatlerin miktarını döndürür.
     *
     * @return Akıllı saat miktarı
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    /**
     * Akıllı saatlerin miktarını ayarlar.
     *
     * @param quantity Yeni miktar
     */
    @Override
    public void setQuantity(int quantity) {
this.quantity=quantity;
    }

}