/**
 * {@code SmartPhone} sınıfı, kulaklık cihazlarını temsil eder ve {@code Device} arayüzünü uygular.
 * Telefonların ismi, fiyatı ve miktarını saklar.
 */
public class SmartPhone implements Device {
    private final String category = "Smart Phone";
    private String name;
    private double price;
    private int quantity;
    /**
     * Telefon nesnesi oluşturur.
     *
     * @param name Telefonun ismi
     * @param price Telefonun fiyatı
     * @param quantity Telefon miktarı
     */
    public SmartPhone(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    /**
     * Telefonun kategorisini döndürür.
     *
     * @return Telefonun kategorisi
     */

    @Override
    public String getCategory() { return category; }
    /**
     * Telefonun ismini döndürür.
     *
     * @return Telefonun ismi
     */
    @Override
    public String getName() { return name; }
    /**
     * Telefonun ismini ayarlar.
     *
     * @param name Yeni isim
     */
    @Override
    public void setName(String name) { this.name = name; }
    /**
     * Telefonun fiyatını döndürür.
     *
     * @return Telefonun fiyatı
     */
    @Override
    public double getPrice() { return price; }
    /**
     * Telefonun fiyatını ayarlar.
     *
     * @param price Yeni fiyat
     */
    @Override
    public void setPrice(double price) { this.price = price; }
    /**
     * Telefonun miktarını döndürür.
     *
     * @return Telefon miktarı
     */
    @Override
    public int getQuantity() { return quantity; }
    /**
     * Telefonun miktarını ayarlar.
     *
     * @param quantity Yeni miktar
     */
    @Override
    public void setQuantity(int quantity) { this.quantity = quantity; }


}