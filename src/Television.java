/**
 * {@code Television} sınıfı, televizyon cihazlarını temsil eder ve {@code Device} arayüzünü uygular.
 * Televizyonların ismi, fiyatı ve miktarını saklar.
 */
public class Television implements Device {

    private final String category = "Television";

    private String name;
    private double price;
    private int quantity;
    
    /**
     * Televizyon nesnesi oluşturur.
     *
     * @param name Televizyonun ismi
     * @param price Televizyonun fiyatı
     * @param quantity Kulaklık miktarı
     */
    public Television(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Televizyonun kategorisini döndürür.
     *
     * @return Televizyonun kategorisi
     */
    public String getCategory() { return category; }


    /**
     * Televizyonun ismini döndürür.
     *
     * @return Televizyonun ismi
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Televizyonun ismini ayarlar.
     *
     * @param name Yeni isim
     */
    @Override
    public void setName(String name) {

    }
    /**
     * Televizyonun fiyatını döndürür.
     *
     * @return Televizyonun fiyatı
     */
    @Override
    public double getPrice() {
        return price;
    }
    /**
     * Televizyonun fiyatını ayarlar.
     *
     * @param price Yeni fiyat
     */
    @Override
    public void setPrice(double price) {
        this.price=price;

    }
    /**
     * Televizyonun miktarını döndürür.
     *
     * @return Kulaklık miktarı
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    /**
     * Televizyonun miktarını ayarlar.
     *
     * @param quantity Yeni miktar
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity=quantity;

    }


}
