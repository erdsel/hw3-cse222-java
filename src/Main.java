import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("Welcome to the Electronics Inventory Management System!");
            System.out.println("Please select an option:");
            System.out.println("1. Add a new device");
            System.out.println("2. Remove a device");
            System.out.println("3. Update device details");
            System.out.println("4. List all devices");
            System.out.println("5. Find the cheapest device");
            System.out.println("6. Sort devices by price");
            System.out.println("7. Calculate total inventory value");
            System.out.println("8. Restock a device");
            System.out.println("9. Export inventory report");




            // Diğer seçenekleri de burada listele
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // İnt sonrası kalan new line'ı temizlemek için

            switch (choice) {
                case 1:
                    System.out.print("Enter category name (Smart Phone, Laptop, Television, Headphones, Smart Watch): ");
                    String category = scanner.nextLine();
                    System.out.println(category);

                    System.out.print("Enter device name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // İnt sonrası kalan new line'ı temizlemek için

                    Device newDevice = null;
                    switch (category) {
                        case "SmartPhone":
                            newDevice = new SmartPhone(name, price, quantity);
                            break;
                        case "Laptop":
                            newDevice = new Laptop(name, price, quantity);
                            break;
                        case "Television":
                            newDevice = new Television(name, price, quantity);
                            break;
                        case "Headphones":
                            newDevice = new Headphones(name, price, quantity);
                            break;
                        case "Smart Watch":
                            newDevice = new SmartWatch(name, price, quantity);
                            break;
                        default:
                            System.out.println("Invalid category name entered.");
                            break;
                    }

                    if (newDevice != null) {
                        inventory.addDevice(newDevice);
                        System.out.println(category + ", " + name + ", " + price + ", " + quantity + " amount added...");
                    }
                    break;


                case 2:
                    System.out.print("Enter the name of the device to remove: ");
                    String nameToRemove = scanner.nextLine();
                    Device deviceToRemove = inventory.findDeviceByName(nameToRemove);
                    if (deviceToRemove != null) {
                        boolean isRemoved = inventory.removeDevice(deviceToRemove);
                        if (isRemoved) {
                            System.out.println(nameToRemove + " has been removed from the inventory.");
                        } else {
                            System.out.println("Something went wrong. The device could not be removed.");
                        }
                    } else {
                        System.out.println("No such device found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the device to update: ");
                    String updateName = scanner.nextLine();

                    // Önce cihazı envanterde bulalım
                    Device deviceToUpdate = null;
                    for (ArrayList<Device> deviceList : inventory.getDevices()) {
                        for (Device device : deviceList) {
                            if (device.getName().equalsIgnoreCase(updateName)) {
                                deviceToUpdate = device;
                                break;
                            }
                        }
                        if (deviceToUpdate != null) break; // Eğer cihaz bulunursa döngüyü kır
                    }

                    if (deviceToUpdate == null) {
                        System.out.println("Device not found in inventory.");
                        break;
                    }

                    System.out.print("Enter new price (leave blank to keep current price): ");
                    String newPriceStr = scanner.nextLine();
                    double newPrice = newPriceStr.isEmpty() ? deviceToUpdate.getPrice() : Double.parseDouble(newPriceStr);

                    System.out.print("Enter new quantity (leave blank to keep current quantity): ");
                    String newQuantityStr = scanner.nextLine();
                    int newQuantity = newQuantityStr.isEmpty() ? deviceToUpdate.getQuantity() : Integer.parseInt(newQuantityStr);

                    // Güncellemeleri yap
                    deviceToUpdate.setPrice(newPrice);
                    deviceToUpdate.setQuantity(newQuantity);

                    System.out.println(deviceToUpdate.getName() + " details updated: Price - " + newPrice + "$, Quantity - " + newQuantity);
                    break;
                case 4:
                    System.out.println("Device List:");
                    int count = 1; // Cihazların sıralı bir şekilde numaralandırılması için sayaç.
                    for (ArrayList<Device> deviceList : inventory.getDevices()) {
                        for (Device device : deviceList) {
                            System.out.println(count++ + ". Category: " + device.getCategory() +
                                    ", Name: " + device.getName() +
                                    ", Price: " + device.getPrice() + "$" +
                                    ", Quantity: " + device.getQuantity());
                        }
                    }
                    if (count == 1) {
                        System.out.println("No devices in inventory.");
                    }
                    break;
                case 5:
                    Device cheapestDevice = null;
                    double minPrice = Double.MAX_VALUE;

                    // Tüm cihazları dolaş ve en ucuz olanı bul
                    for (ArrayList<Device> deviceList : inventory.getDevices()) {
                        for (Device device : deviceList) {
                            if (device.getPrice() < minPrice) {
                                minPrice = device.getPrice();
                                cheapestDevice = device;
                            }
                        }
                    }

                    // En ucuz cihazın bilgilerini yazdır
                    if (cheapestDevice != null) {
                        System.out.println("The cheapest device is:");
                        System.out.println("Category: " + cheapestDevice.getCategory() +
                                ", Name: " + cheapestDevice.getName() +
                                ", Price: " + cheapestDevice.getPrice() + "$" +
                                ", Quantity: " + cheapestDevice.getQuantity());
                    } else {
                        System.out.println("No devices found in inventory.");
                    }
                    break;
                case 6:
                    // Tüm cihazları tek bir liste içine al
                    List<Device> allDevices = new ArrayList<>();
                    for (ArrayList<Device> deviceList : inventory.getDevices()) {
                        allDevices.addAll(deviceList);
                    }

                    // Cihazları fiyatlarına göre sırala
                    allDevices.sort(Comparator.comparingDouble(Device::getPrice));

                    // Sıralı cihaz listesini yazdır
                    System.out.println("Devices sorted by price:");
                    int index = 1;
                    for (Device device : allDevices) {
                        System.out.println(index++ + ". Category: " + device.getCategory() +
                                ", Name: " + device.getName() +
                                ", Price: " + device.getPrice() + "$" +
                                ", Quantity: " + device.getQuantity());
                    }
                    break;
                case 7:
                    double totalValue = 0.0;
                    for (ArrayList<Device> deviceList : inventory.getDevices()) {
                        for (Device device : deviceList) {
                            totalValue += device.getPrice() * device.getQuantity();
                        }
                    }
                    System.out.printf("Total inventory value: $%,.2f\n", totalValue);
                    break;
                case 8:
                    System.out.print("Enter the name of the device to restock: ");
                    String restockName = scanner.nextLine();

                    // Cihazı envanterde bul
                    Device deviceToRestock = null;
                    for (ArrayList<Device> deviceList : inventory.getDevices()) {
                        for (Device device : deviceList) {
                            if (device.getName().equalsIgnoreCase(restockName)) {
                                deviceToRestock = device;
                                break;
                            }
                        }
                        if (deviceToRestock != null) break;
                    }

                    if (deviceToRestock == null) {
                        System.out.println("Device not found in inventory.");
                        break;
                    }

                    System.out.print("Do you want to add or remove stock? (Add/Remove): ");
                    String action = scanner.nextLine();

                    int quantityChange;
                    if (action.equalsIgnoreCase("Add")) {
                        System.out.print("Enter the quantity to add: ");
                        quantityChange = scanner.nextInt();
                        deviceToRestock.setQuantity(deviceToRestock.getQuantity() + quantityChange);
                        System.out.println(restockName + " restocked. New quantity: " + deviceToRestock.getQuantity());
                    } else if (action.equalsIgnoreCase("Remove")) {
                        System.out.print("Enter the quantity to remove: ");
                        quantityChange = scanner.nextInt();
                        int newQuantity2 = deviceToRestock.getQuantity() - quantityChange;
                        if (newQuantity2 < 0) {
                            System.out.println("Cannot remove more than the current stock.");
                        } else {
                            deviceToRestock.setQuantity(newQuantity2);
                            System.out.println(restockName + " stock reduced. New quantity: " + deviceToRestock.getQuantity());
                        }
                    } else {
                        System.out.println("Invalid action.");
                    }
                    scanner.nextLine(); // İnt sonrası kalan new line'ı temizlemek için
                    break;
                case 9:
                    String reportPath = "InventoryReport.txt"; // Raporun kaydedileceği dosyanın yolu
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
                        writer.write("Electronics Shop Inventory Report\n");
                        writer.write("Generated on: " + java.time.LocalDate.now() + "\n");
                        writer.write("-------------------------------------------------\n");
                        writer.write("| No. | Category | Name | Price | Quantity |\n");
                        writer.write("-------------------------------------------------\n");

                        int totalDevices = 0;
                        double totalValue2 = 0.0;
                        int deviceNo = 1; // Cihaz numaraları için sayaç

                        for (ArrayList<Device> deviceList : inventory.getDevices()) {
                            for (Device device : deviceList) {
                                writer.write(String.format("| %d | %s | %s | $%.2f | %d |\n",
                                        deviceNo++,
                                        device.getCategory(),
                                        device.getName(),
                                        device.getPrice(),
                                        device.getQuantity()));

                                totalDevices++;
                                totalValue2 += device.getPrice() * device.getQuantity();
                            }
                        }

                        writer.write("-------------------------------------------------\n");
                        writer.write("Summary:\n");
                        writer.write("- Total Number of Devices: " + totalDevices + "\n");
                        writer.write(String.format("- Total Inventory Value: $%,.2f\n", totalValue2));
                        writer.write("End of Report\n");

                        System.out.println("Inventory report exported to " + reportPath);
                    } catch (IOException e) {
                        System.err.println("Error while writing to file: " + e.getMessage());
                    }
                    break;








                // Diğer caseleri ekleyin
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }
}
