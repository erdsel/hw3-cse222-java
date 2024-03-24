/**
 * {@code Device} interface yapısı, Elektronik cihazların ortak özelliklerini tanımlayan arayüz.
 * Bu arayüz, bir cihazın kategorisini, adını, fiyatını ve miktarını sorgulama ve ayarlama işlevlerini içerir.
 * Her elektronik cihaz bu arayüzü uygulayarak, bu temel özelliklere sahip olur.
 */
public interface Device {

    /**
     * Cihazın kategorisini döndürür.
     * @return Cihazın kategorisi.
     */
    String getCategory();

    /**
     * Cihazın adını döndürür.
     * @return Cihazın adı.
     */
    String getName();

    /**
     * Cihazın adını ayarlar.
     * @param name Yeni cihaz adı.
     */
    void setName(String name);

    /**
     * Cihazın fiyatını döndürür.
     * @return Cihazın fiyatı.
     */
    double getPrice();

    /**
     * Cihazın fiyatını ayarlar.
     * @param price Yeni cihaz fiyatı.
     */
    void setPrice(double price);

    /**
     * Cihazın mevcut miktarını döndürür.
     * @return Cihazın miktarı.
     */
    int getQuantity();

    /**
     * Cihazın miktarını ayarlar.
     * @param quantity Yeni cihaz miktarı.
     */
    void setQuantity(int quantity);

    // Ek özellikler


}
