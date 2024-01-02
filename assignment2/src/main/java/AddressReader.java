import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: AddressReader
 *
 * Methods:
 *      public static ArrayList<Address> readAddressData(File file) throws FileNotFoundException: reads
 *      “address_data.txt” (provided) and adds Address objects to an ArrayList<Address> and returns it
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class AddressReader
{
    public static ArrayList<Address> readAddressData(File file) throws FileNotFoundException
    {
        ArrayList<Address> addresses = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\|");

            String unitNumber = parts[0];
            String streetNumber = parts[1];
            String streetName = parts[2];
            String postalCode = parts[3];
            String city = parts[4];

            Address address = new Address(unitNumber, streetNumber, streetName, postalCode, city);
            addresses.add(address);
        }

        return addresses;
    }
}
