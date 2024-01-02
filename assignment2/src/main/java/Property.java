/**
 * Class: Property
 *
 * Instance Variables:
 *      1. Price in USD (double, must be positive)
 *      2. Address (Address, not null)
 *      3. Number of bedrooms (int: must be 1 to 20)
 *      4. Swimming pool (boolean)
 *      5. Type (String: must be one of: “residence”, “commercial”, or “retail”)
 *      6. Property ID (String: must be one to six characters)
 *
 * Methods:
 *      1. Get methods for all instance variables
 *      2. Set method for price
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Property {

    private double  priceUsd;
    private Address address;
    private String  type;
    private String  propertyId;

    private static final int LOWEST_PRICE_USD = 0;
    private static final int MINIMUM_PROPERTY_ID_LENGTH = 1;
    private static final int MAXIMUM_PROPERTY_ID_LENGTH = 6;

    /**
     * constructor
     * @param priceUsd           - price in USD
     * @param address            - property's address
     * @param type               - type of property (“residence”, “commercial”, or “retail”)
     * @param propertyId         - property ID
     */
    public Property(final double priceUsd,
                    final Address address,
                    final String type,
                    final String propertyId) {
        // price check
        if (priceUsd < LOWEST_PRICE_USD) {
            throw new IllegalArgumentException("Invalid price: " + priceUsd);
        }
        else
        {
            this.priceUsd = priceUsd;
        }

        // address check
        if (address == null)
        {
            throw new NullPointerException("Invalid address: " + address);
        }
        else {
            this.address = address;
        }

        // type check
        if (type == null || type.isBlank())
        {
            throw new NullPointerException("Invalid property type: " + type);
        }
        else if (type.strip().equalsIgnoreCase("residence") ||
                type.strip().equalsIgnoreCase("commercial") ||
                type.strip().equalsIgnoreCase("retail"))
        {
            this.type = type;
        }
        else
        {
            throw new IllegalArgumentException("Invalid property type: " + type);
        }

        // propertyID check
        if (propertyId == null)
        {
            throw new NullPointerException("Invalid property id: " + propertyId);
        }
        else if (propertyId.isBlank() || propertyId.length() < MINIMUM_PROPERTY_ID_LENGTH || propertyId.length() > MAXIMUM_PROPERTY_ID_LENGTH)
        {
            throw new IllegalArgumentException("Invalid property id: " + propertyId);
        }
        else
        {
            this.propertyId = propertyId;
        }
    }

    /**
     * getters
     * @return priceUsd, address, type, propertyID
     */
    public double getPriceUsd()
    {
        return priceUsd;
    }

    public Address getAddress()
    {
        return address;
    }

    public String getType()
    {
        return type;
    }

    public String getPropertyId()
    {
        return propertyId;
    }

    /**
     * Setters
     * @param priceUsd - new price in USD
     */
    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    /**
     * To string method
     * @return the state of Property objects
     */
    @Override
    public String toString() {
        return "Property{" +
                "priceUsd=" + priceUsd +
                ", address=" + address +
                ", type='" + type + '\'' +
                ", propertyId='" + propertyId + '\'' +
                '}';
    }
}
