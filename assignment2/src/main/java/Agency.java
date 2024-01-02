import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class: Agency
 *
 * Instance Variables:
 *      1. Name (String, 1 to 30 characters)
 *      2. Properties (HashMap of properties; key is property id, value is a Property)
 *
 * Methods:
 *      1. addProperty(property): adds the (non-null) property to the HashMap
 *      2. removeProperty(propertyId): removes the property whose ID matches the parameter, from the HashMap
 *      3. getProperty(propertyId): returns the property whose ID matches the parameter, from the HashMap (or null if there is no match)
 *      4. getTotalPropertyValues(): returns the total amount in USD of all Properties
 *      5. getPropertiesWithPools(): returns an ArrayList of such Properties...or null if there are none
 *      6. getPropertiesBetween(minUsd, maxUsd): returns an array of properties whose price falls in the range specified by the parameters...or null if there are none
 *      7. getPropertiesOn(streetName): returns an ArrayList of addresses which are on the specified street...or null if there are none
 *      8. getPropertiesWithBedrooms(minBedrooms, maxBedrooms): returns a HashMap of properties
 *          (key is property id, value is the Property) whose number of bedrooms falls in the range specified
 *          by the parameters...or null if there are none. Note that the order of the properties may differ
 *          from since a HashMap doesn’t store “in order,” but the contents must otherwise match those in the sample run in the tests.
 *      9. getPropertiesOfType(propertyType): returns an ArrayList of Strings, with all the information
 *          about every property (one property per line) that is of the specified type (e.g. “commErciAl”: be
 *          case-insensitive) in the exact format of:
 *
 *          Type: COMMERCIAL
 *              1) Property 9999: unit #9 at 99 Gretzky Way T6V7H3 in Toronto (1 bedroom): $99999.
 *              2) Property 678T: 1515 Main Street V8Y7R3 in West Vancouver (2 bedrooms plus pool): $4000000.
 *              3) Property A1212: unit #7h at 1500 Railway Avenue V9V5V4 in Richmond (4 bedrooms): $840000.
 *
 *          Note that the sample output above is exactly what should be returned for the data shown
 *          below; it must create similar sentence structures for any property of any type. Notice the
 *          capitalization of various parts of the string (see above) versus how it was stored (see below).
 *
 *          If there are NO properties of the specified type the output must be as follows:
 *
 *          Type: RETAIL
 *          <none found>
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Agency {

    private String name;
    private HashMap<String, Property>   properties;

    private static double TOTAL_PRICE_USD = 0.00;
    private static int PROPERTIES_BETWEEN_FIRST_INDEX = 0;
    private static int PROPERTIES_BETWEEN_TOTAL_INDEX = 0;

    /**
     * constructor
     * @param name - name of the class
     */
    public Agency(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new NullPointerException("Invalid Name: " + name);
        } else
        {
            this.name = name;
        }
        this.properties = new HashMap<>();
    }

    /**
     * addProperty method
     * @param property - adds the (non-null) property to the HashMap
     */
    void addProperty(final Property property)
    {
        if (property == null) {
            throw new NullPointerException("Property cannot be null");
        }
        else {
            properties.put(property.getPropertyId(), property);
        }
    }

    /**
     * getProperty method
     * @param propertyId    - property id you want to find
     * @return              - the property whose ID matches the parameter, from the HashMap (or null if there is no match)
     */
    Property getProperty(final String propertyId)
    {
        for (String key : properties.keySet())
        {
            if (key.equals(propertyId)) {
                return properties.get(key);
            }
        }
        return null;
    }

    /**
     * removeProperty method
     * @param propertyId - property id you want to remove
     */
    void removeProperty(final String propertyId)
    {
        if (propertyId == null || propertyId.isBlank())
        {
            throw new NullPointerException("Property cannot be null");
        }
        else if (!properties.containsKey(propertyId))
        {
            throw new IllegalArgumentException("Property ID doesn't match");
        }
        else
        {
            properties.remove(propertyId);
        }
    }

    /**
     * getTotalPropertyValues method
     * @return - the total amount in USD of all Properties
     */
    double getTotalPropertyValues() {
        for (String key : properties.keySet())
        {
            double price = properties.get(key).getPriceUsd();
            TOTAL_PRICE_USD += price;
        }
        return TOTAL_PRICE_USD;
    }

    /**
     * getPropertiesWithPools method (modified)
     * @return - ArrayList<Residence> type properties
     */
    ArrayList<Residence> getPropertiesWithPools()
    {
        ArrayList<Residence> propertiesWithPools = new ArrayList<>();

        for (String key : properties.keySet())
        {
            Property p = properties.get(key);
            if (p instanceof Residence)
            {
                Residence r = (Residence) p;
                if (r.isSwimmingPool())
                {
                    propertiesWithPools.add(r);
                }
            }
        }

        return propertiesWithPools;
    }

    /**
     * getPropertiesBetween method
     * @param minUsd - minimum price in usd
     * @param maxUsd - maximum price in usd
     * @return       - an array of properties whose price falls in the range specified by the parameters, or null if there are none
     */
    Property[] getPropertiesBetween(final double minUsd, final double maxUsd)
    {
        for (String key : properties.keySet())
        {
            double priceUsd = properties.get(key).getPriceUsd();
            if (priceUsd >= minUsd && priceUsd <= maxUsd)
            {
                PROPERTIES_BETWEEN_TOTAL_INDEX++;
            }
        }

        Property[] propertiesBetween = new Property[PROPERTIES_BETWEEN_TOTAL_INDEX];
        for (String key : properties.keySet())
        {
            double priceUsd = properties.get(key).getPriceUsd();
            if (priceUsd >= minUsd && priceUsd <= maxUsd)
            {
                propertiesBetween[PROPERTIES_BETWEEN_FIRST_INDEX] = properties.get(key);
                PROPERTIES_BETWEEN_FIRST_INDEX++;
            }
        }

        return propertiesBetween;
    }

    /**
     * getPropertiesOn method
     * @param streetName - street name you want to find
     * @return           - an ArrayList of addresses which are on the specified street, or null if there are none
     */
    ArrayList<Address> getPropertiesOn(final String streetName)
    {
        ArrayList<Address> propertiesOn = new ArrayList<>();
        for (String key : properties.keySet())
        {
            Property property = properties.get(key);
            if (property.getAddress().getStreetName().equalsIgnoreCase(streetName))
            {
                propertiesOn.add(property.getAddress());
            }
        }

        return propertiesOn;
    }

    /**
     * getPropertiesWithBedrooms method (modified)
     * @param minBedrooms   - minimum number of bedroom
     * @param maxBedrooms   - maximum number of bedroom
     * @return              - a HashMap of residences (key is property id, value is the Property)
     *                        whose number of bedrooms falls in the range specified by the parameters...or null if there are none
     */
    HashMap<String, Residence> getPropertiesWithBedrooms(final int minBedrooms, final int maxBedrooms)
    {
        HashMap<String, Residence> propertiesWithBedrooms = new HashMap<>();
        for (String key : properties.keySet())
        {
            Property p = properties.get(key);
            if (p instanceof Residence)
            {
                Residence r = (Residence) p;
                int propertyNumberOfBedrooms = r.getNumberOfBedrooms();
                if (propertyNumberOfBedrooms >= minBedrooms && propertyNumberOfBedrooms <= maxBedrooms)
                {
                    propertiesWithBedrooms.put(r.getPropertyId(), r);
                }
            }
        }
        // if streetName is not found, return null
        if (propertiesWithBedrooms.isEmpty())
        {
            return null;
        }

        return propertiesWithBedrooms;
    }

    /**
     * getPropertiesOfType method (modified)
     * @param propertyType  - property type tou want to find
     * @return              - an ArrayList of Property, with all the information about every property (one property per line)
     *                        that is one of the specified type (“residence”, “commercial”, or “retail”) in the exact format
     */
    ArrayList<Property> getPropertiesOfType(final String propertyType)
    {
        ArrayList<Property> matchingProperties = new ArrayList<>();
        for (String key : properties.keySet()) {
            Property property = properties.get(key);
            if (property.getType().equalsIgnoreCase(propertyType))
            {
                matchingProperties.add(property);
            }
        }

        return matchingProperties;
    }

    /**
     * getPropertiesWithLoadingDock method
     * @return an ArrayList<Commercial> that holds only Commercial properties that have a loading dock available
     */
    ArrayList<Commercial> getPropertiesWithLoadingDocks()
    {
        ArrayList<Commercial> propertiesWithLoadingDocks = new ArrayList<>();
        for (String key : properties.keySet())
        {
            Property p = properties.get(key);
            if (p instanceof Commercial)
            {
                Commercial c = (Commercial) p;
                if (c.isLoadingDock())
                {
                    propertiesWithLoadingDocks.add(c);
                }
            }
        }

        return propertiesWithLoadingDocks;
    }

    /**
     * getPropertiesWithHighwayAccess method
     * @return an ArrayList<Commercial> that holds only Commercial properties that have highway access
     */
    ArrayList<Commercial> getPropertiesWithHighwayAccess()
    {
        ArrayList<Commercial> propertiesWithHighwayAccess = new ArrayList<>();
        for (String key : properties.keySet())
        {
            Property p = properties.get(key);
            if (p instanceof Commercial)
            {
                Commercial c = (Commercial) p;
                if (c.isHighwayAccess())
                {
                    propertiesWithHighwayAccess.add(c);
                }
            }
        }

        return propertiesWithHighwayAccess;
    }

    /**
     * getPropertiesWithSquareFootage method
     * @param squareFootage - amount of square footage
     * @return an ArrayList<Retail> that holds properties where square footage is at least the parameter value.
     */
    ArrayList<Retail> getPropertiesSquareFootage(final int squareFootage)
    {
        ArrayList<Retail> propertiesSquareFootage = new ArrayList<>();
        for (String key : properties.keySet())
        {
            Property p = properties.get(key);
            if (p instanceof Retail)
            {
                Retail r = (Retail) p;
                if (r.getSquareFootage() == squareFootage)
                {
                    propertiesSquareFootage.add(r);
                }
            }
        }

        return propertiesSquareFootage;
    }

    /**
     * getPropertiesWithCustomerParking method
     * @return an ArrayList<Retail> that holds properties where customer parking is available
     */
    ArrayList<Retail> getPropertiesWithCustomerParking()
    {
        ArrayList<Retail> propertiesWithCustomerParking = new ArrayList<>();
        for (String key : properties.keySet())
        {
            Property p = properties.get(key);
            if (p instanceof Retail)
            {
                Retail r = (Retail) p;
                if (r.isCustomerParking())
                {
                    propertiesWithCustomerParking.add(r);
                }
            }
        }

        return propertiesWithCustomerParking;
    }

    /**
     * getPropertiesWithStrata method
     * @return an ArrayList<Residence> that hold only the Residences that are in a strata
     */
    ArrayList<Residence> getPropertiesWithStrata()
    {
        ArrayList<Residence> propertiesWithStrata = new ArrayList<>();
        for (String key : properties.keySet())
        {
            Property p = properties.get(key);
            if (p instanceof Residence)
            {
                Residence r = (Residence) p;
                if (r.isStrata())
                {
                    propertiesWithStrata.add(r);
                }
            }
        }

        return propertiesWithStrata;
    }
}
