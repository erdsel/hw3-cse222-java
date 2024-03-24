import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Represents an inventory of devices, categorized in lists.
 * Each list in the linked list contains devices of the same category.
 */
public class Inventory {
    private LinkedList<ArrayList<Device>> devices;
    /**
     * Constructs an empty inventory.
     */
    public Inventory() {
        devices = new LinkedList<ArrayList<Device>>();
    }
    /**
     * Adds a new device to the inventory. If the category of the device
     * already exists, the device is added to the corresponding list.
     * Otherwise, a new list is created for this category.
     *
     * @param newDevice The device to be added to the inventory.
     */
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
    /**
     * Returns the list of device lists in the inventory. Each list contains
     * devices of a specific category.
     *
     * @return The linked list of device array lists.
     */
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

    /**
     * Updates the details of a specific device in the inventory.
     * If a device with the specified name exists, its details are updated.
     *
     * @param name        The current name of the device to be updated.
     * @param newName     The new name for the device.
     * @param newPrice    The new price for the device.
     * @param newQuantity The new quantity for the device.
     */
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
    /**
     * Lists all the devices in the inventory to the standard output.
     * The details listed include category, name, price, and quantity of each device.
     */
    public void listAllDevices() {
        if (devices.isEmpty()) {
            System.out.println("Envanter is empty.");
            return;
        }

        for (ArrayList<Device> deviceList : devices) {
            for (Device device : deviceList) {
                System.out.println("Category: " + device.getCategory() +
                        ", Name: " + device.getName() +
                        ", Price: " + device.getPrice() +
                        ", Quantitiy: " + device.getQuantity());
            }
        }
    }
    /**
     * Finds and returns the device with the lowest price in the inventory.
     * If there are no devices in the inventory, returns null.
     *
     * @return The device with the lowest price or null if no devices are found.
     */
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

//    public void sortDevicesByPrice() {
//        List<Device> allDevices = new ArrayList<>();
//
//        // Tüm cihazları tek bir listeye topla
//        for (ArrayList<Device> deviceList : devices) {
//            allDevices.addAll(deviceList);
//        }
//
//        // Cihazları fiyatlarına göre sırala
//        Collections.sort(allDevices, new Comparator<Device>() {
//            @Override
//            public int compare(Device d1, Device d2) {
//                return Double.compare(d1.getPrice(), d2.getPrice());
//            }
//        });
//
//        // Sıralı listeyi göster
//        for (Device device : allDevices) {
//            System.out.println(device.getName() + " - " + device.getPrice());
//        }
//    }


    /**
     * Calculates the total value of all devices in the inventory.
     * The total value is computed by summing up the product of the price and quantity for each device.
     *
     * @return The total value of the inventory.
     */
    public double calculateTotalInventoryValue() {
        double totalValue = 0.0;

        for (ArrayList<Device> deviceList : devices) {
            for (Device device : deviceList) {
                totalValue += device.getPrice() * device.getQuantity();
            }
        }

        return totalValue;
    }

    /**
     * Restocks a device by updating its quantity in the inventory.
     * If the device with the given name is found, its quantity is updated.
     * A message is printed if the device cannot be found.
     *
     * @param deviceName The name of the device to restock.
     * @param newQuantity The new quantity to be set for the device.
     */
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
    /**
     * Exports the inventory report to a text file. The report will contain
     * a detailed list of all devices including their category, name, price,
     * and quantity, followed by a summary of the total number of devices
     * and total inventory value.
     *
     * @param filePath The file path where the report will be saved.
     */
    public void exportInventoryToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Electronics Shop Inventory Report\n");
            writer.write("Generated on: " + java.time.LocalDate.now() + "\n");
            writer.write("-------------------------------------------------\n");
            writer.write("| No. | Category | Name | Price | Quantity |\n");
            writer.write("-------------------------------------------------\n");

            int totalDevices = 0;
            double totalValue = 0.0;
            int deviceNo = 1; // Cihaz numaraları için sayaç

            for (ArrayList<Device> deviceList : getDevices()) {
                for (Device device : deviceList) {
                    writer.write(String.format("| %d | %s | %s | $%.2f | %d |\n",
                            deviceNo++,
                            device.getCategory(),
                            device.getName(),
                            device.getPrice(),
                            device.getQuantity()));

                    totalDevices++;
                    totalValue += device.getPrice() * device.getQuantity();
                }
            }

            writer.write("-------------------------------------------------\n");
            writer.write("Summary:\n");
            writer.write("- Total Number of Devices: " + totalDevices + "\n");
            writer.write(String.format("- Total Inventory Value: $%,.2f\n", totalValue));
            writer.write("End of Report\n");
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        }
    }

    /**
     * Searches for a device by its name in the inventory.
     * Iterates through all devices and returns the first device with the matching name.
     *
     * @param name The name of the device to search for.
     * @return The device with the specified name, or {@code null} if no such device is found.
     */

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
