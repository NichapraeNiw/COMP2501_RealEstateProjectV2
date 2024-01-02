import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: PropertyReader
 *
 * Methods:
 *      public static ArrayList<String> readPropertyData(File file) throws FileNotFoundException: reads
 *      “property_data.txt” (provided) and adds Strings (for each line) to an ArrayList<String> and returns it
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class PropertyReader
{
    public static ArrayList<String> readPropertyData(File file) throws FileNotFoundException
    {
        ArrayList<String> data = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            data.add(scanner.nextLine());
        }
        scanner.close();
        return data;
    }
}
