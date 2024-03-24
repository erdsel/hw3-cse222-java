import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Inventory {
    private LinkedList<ArrayList<Device>> devices;

    public Inventory() {
        devices = new LinkedList<ArrayList<Device>>();
    }

    public void addDevice(Device newDevice) {
        boolean categoryExists = false;
        for (ArrayList<Device> deviceList : devices) {
            if (!deviceList.isEmpty() && deviceList.get(0).getCategory().equals(newDevice.getCategory())) {
                deviceList.add(newDevice);
                categoryExists = true;
                break;
            }
        }

        if (!categoryExists) {
            ArrayList<Device> newList = new ArrayList<Device>();
            newList.add(newDevice);
            devices.add(newList);
        }
    }

    public LinkedList<ArrayList<Device>> getDevices() {
        return devices;
    }

    /**
     * Envanterden belirli bir cihazı kaldırır.
     *
     * @param deviceToRemove Kaldırılacak cihaz nesnesi.
     * @return Cihazın kaldırılıp kaldırılmadığını belirten boolean.
     */
    public boolean removeDevice(Device deviceToRemove) {
        for (ArrayList<Device> deviceList : devices) {
            if (deviceList.contains(deviceToRemove)) {
                deviceList.remove(deviceToRemove);
                // Eğer liste boşsa, bu listeyi LinkedList'ten kaldır
                if (deviceList.isEmpty()) {
                    devices.remove(deviceList);
                }
                return true; // Cihaz bulundu ve kaldırıldı
            }
        }
        return false; // Cihaz envanterde bulunamadı
    }
    public void updateDeviceDetails(String name, String newName, double newPrice, int newQuantity) {
        for (ArrayList<Device> deviceList : devices) {
            for (Device device : deviceList) {
                if (device.getName().equals(name)) {
                    device.setName(newName);
                    device.setPrice(newPrice);
                    device.setQuantity(newQuantity);
                    return; // Cihaz bulunup güncellendikten sonra döngüden çık
                }
            }
        }
    }

    public void listAllDevices() {
        if (devices.isEmpty()) {
            System.out.println("Envanter boş.");
            return;
        }

        for (ArrayList<Device> deviceList : devices) {
            for (Device device : deviceList) {
                System.out.println("Kategori: " + device.getCategory() +
                        ", Adı: " + device.getName() +
                        ", Fiyatı: " + device.getPrice() +
                        ", Miktarı: " + device.getQuantity());
            }
        }
    }

    public Device findCheapestDevice() {
        Device cheapestDevice = null;
        double minPrice = Double.MAX_VALUE;

        for (ArrayList<Device> deviceList : devices) {
            for (Device device : deviceList) {
                if (device.getPrice() < minPrice) {
                    minPrice = device.getPrice();
                    cheapestDevice = device;
                }
            }
        }

        return cheapestDevice;
    }

    public void sortDevicesByPrice() {
        List<Device> allDevices = new ArrayList<>();

        // Tüm cihazları tek bir listeye topla
        for (ArrayList<Device> deviceList : devices) {
            allDevices.addAll(deviceList);
        }

        // Cihazları fiyatlarına göre sırala
        Collections.sort(allDevices, new Comparator<Device>() {
            @Override
            public int compare(Device d1, Device d2) {
                return Double.compare(d1.getPrice(), d2.getPrice());
            }
        });

        // Sıralı listeyi göster (isterseniz bu kısmı kaldırabilirsiniz)
        for (Device device : allDevices) {
            System.out.println(device.getName() + " - " + device.getPrice());
        }
    }
    public double calculateTotalInventoryValue() {
        double totalValue = 0.0;

        for (ArrayList<Device> deviceList : devices) {
            for (Device device : deviceList) {
                totalValue += device.getPrice() * device.getQuantity();
            }
        }

        return totalValue;
    }
    public void restockDevice(String deviceName, int newQuantity) {
        for (ArrayList<Device> deviceList : devices) {
            for (Device device : deviceList) {
                if (device.getName().equals(deviceName)) {
                    device.setQuantity(newQuantity);
                    return; // Cihaz bulundu ve miktarı güncellendi, metodtan çık
                }
            }
        }
        System.out.println("Cihaz bulunamadı: " + deviceName);
    }
    public void exportInventoryToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ArrayList<Device> deviceList : devices) {
                for (Device device : deviceList) {
                    writer.write(device.getName() + ", "
                            + device.getCategory() + ", "
                            + device.getPrice() + ", "
                            + device.getQuantity());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Dosyaya yazarken hata oluştu: " + e.getMessage());
        }
    }
    public Device findDeviceByName(String name) {
        for (ArrayList<Device> deviceList : devices) {
            for (Device device : deviceList) {
                if (device.getName().equals(name)) {
                    return device; // Cihaz bulundu
                }
            }
        }
        return null; // Cihaz bulunamadı
    }

}
