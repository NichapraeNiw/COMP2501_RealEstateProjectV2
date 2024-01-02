import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class: Assignment 2
 *
 * Instance Variables:
 *      1. Agency: reference to the Agency class
 *
 * Methods: Get methods for all instance variables
 *      1. public void init() throws FileNotFoundException: This method gets the ArrayList,<Address> and
 *          ArrayList<String> form AddressReader and PropertyReader, and uses them to create subtype Objects
 *          and adds them to the Agency.HashMap<String, Property> properties
 *      2. public void doSearches(): This method provides the primary user interface through command prompts
 *          that will allow the user to choose which search operations to perform. See the Sample Interface below.
 *          Each search will display results to the console.
 *      3. public static void main(String[] args) throws FileNotFoundException: Will create an instance of
 *          Assignment2 and use that to call init() and then doSearches().
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Assignment2 {
    private Agency agency;

    public static void main(String[] args) throws FileNotFoundException
    {
        Assignment2 a2 = new Assignment2();
        a2.init();
        a2.doSearches();
    }

    public void init() throws FileNotFoundException {
        ArrayList<Address> addresses = AddressReader.readAddressData(new File("address_data.txt"));
        ArrayList<String> propertyData = PropertyReader.readPropertyData(new File("property_data.txt"));

        agency = new Agency("Assignment2");

        int addressesIndex = 0;
        for (String line : propertyData) {

            String[] rawData = line.split("\\|");

            if (rawData[3].equalsIgnoreCase("residence")) {

                agency.addProperty(new Residence(Double.parseDouble(rawData[0]), addresses.get(addressesIndex),
                        Integer.parseInt(rawData[1]), Boolean.parseBoolean(rawData[2]), rawData[3], rawData[4],
                        Boolean.parseBoolean(rawData[5])));

            } else if (rawData[1].equalsIgnoreCase("commercial")) {

                agency.addProperty(new Commercial(Double.parseDouble(rawData[0]), addresses.get(addressesIndex),
                        rawData[1], rawData[2], Boolean.parseBoolean(rawData[3]), Boolean.parseBoolean(rawData[4])));

            } else {

                agency.addProperty(new Retail(Double.parseDouble(rawData[0]), addresses.get(addressesIndex), rawData[1],
                        rawData[2], Integer.parseInt(rawData[3]), Boolean.parseBoolean(rawData[4])));
            }

            addressesIndex++;
        }
    }

    public void doSearches() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to our Property search.");
            System.out.println("Choose one of the following options:");
            System.out.println("1. General Queries");
            System.out.println("2. Residence Queries");
            System.out.println("3. Commercial Queries");
            System.out.println("4. Retail Queries");
            System.out.println("5. Exit");

            int option = scanner.nextInt();

            // general queries page
            if (option == 1)
            {
                System.out.println("General Queries");
                System.out.println("1. By Property ID");
                System.out.println("2. By Price");
                System.out.println("3. By Street");
                System.out.println("4. By Type");
                System.out.println("5. Back");

                int generalOption = scanner.nextInt();
                scanner.nextLine();

                // options in general queries
                if (generalOption == 1)
                {
                    System.out.println("Enter Property ID:");

                    String propertyId = scanner.nextLine();
                    System.out.println(agency.getProperty(propertyId));
                    continue;
                }
                else if (generalOption == 2)
                {
                    System.out.println("Enter minimum selling price:");
                    double minPrice = scanner.nextDouble();
                    System.out.println("Enter maximum selling price:");
                    double maxPrice = scanner.nextDouble();
                    System.out.println(Arrays.toString(agency.getPropertiesBetween(minPrice, maxPrice)));
                    continue;
                }
                else if (generalOption == 3)
                {
                    System.out.println("Enter street name:");
                    String streetName = scanner.nextLine();
                    System.out.println(agency.getPropertiesOn(streetName));
                    continue;
                }
                else if (generalOption == 4)
                {
                    System.out.println("Enter property type");
                    String propertyType = scanner.nextLine();
                    System.out.println(agency.getPropertiesOfType(propertyType));
                    continue;
                }
                else if (generalOption == 5)
                {
                    continue;
                }
            }

            // residence queries page
            else if (option == 2)
            {
                System.out.println("Residence Queries");
                System.out.println("1. By Bedroom");
                System.out.println("2. By pool");
                System.out.println("3. By Strata");
                System.out.println("4. Back");

                int residenceOption = scanner.nextInt();

                // options in residence queries
                if (residenceOption == 1)
                {
                    System.out.println("Enter minimum bedrooms:");
                    int minBedroom = scanner.nextInt();
                    System.out.println("Enter maximum bedrooms:");
                    int maxBedroom = scanner.nextInt();

                    System.out.println(agency.getPropertiesWithBedrooms(minBedroom, maxBedroom));
                    continue;
                }
                else if (residenceOption == 2)
                {
                    System.out.println(agency.getPropertiesWithPools());
                    continue;
                }
                else if (residenceOption == 3)
                {
                    System.out.println(agency.getPropertiesWithStrata());
                    continue;
                }
                else if (residenceOption == 4)
                {
                    continue;
                }
            }

            // commercial queries page
            else if (option == 3)
            {
                System.out.println("Commercial Queries");
                System.out.println("1. By Loading Dock");
                System.out.println("2. By Highway Access");
                System.out.println("3. Back");

                int commercialOption = scanner.nextInt();

                // options in commercial queries
                if (commercialOption == 1)
                {
                    System.out.println(agency.getPropertiesWithLoadingDocks());
                    continue;
                }
                else if (commercialOption == 2)
                {
                    System.out.println(agency.getPropertiesWithHighwayAccess());
                    continue;
                }
                else if (commercialOption == 3)
                {
                    continue;
                }
            }

            // retail queries page
            else if (option == 4)
            {
                System.out.println("Retail Queries");
                System.out.println("1. By Square Footage");
                System.out.println("2. By Customer Parking");
                System.out.println("3. Back");

                int retailOption = scanner.nextInt();

                // options in retail queries
                if (retailOption == 1)
                {
                    System.out.println("Enter minimum square footage:");
                    int squareFootage = scanner.nextInt();
                    System.out.println(agency.getPropertiesSquareFootage(squareFootage));
                    continue;
                }
                else if (retailOption == 2)
                {
                    System.out.println(agency.getPropertiesWithCustomerParking());
                    continue;
                }
                else if (retailOption == 3)
                {
                    continue;
                }
            }

            // Exit
            else if (option == 5)
            {
                System.out.println("Goodbye for now");
                return;
            }
        }
    }
}