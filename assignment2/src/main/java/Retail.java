/**
 * Class: Retail extends Property
 *
 * Instance Variables:
 *      1. squareFootage (int: the amount of floor space available)
 *      2. customerParking (boolean: indicates if customer parking is available)
 *
 * Methods:
 *      1. Subtype of Property
 *      2. Get methods for all fields
 *      3. toString() for displaying the state of Retail types
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Retail extends Property
{
    private int squareFootage;
    private boolean customerParking;

    private static final int MINIMUM_SQUARE_FOOTAGE = 1;

    /**
     * constructor
     *
     * @param squareFootage    - the amount of floor space available
     * @param customerParking  - indicates if customer parking is available
     * @param priceUsd         - price in USD
     * @param address          - property's address
     * @param type             - type of property (“residence”, “commercial”, or “retail”)
     * @param propertyId       - property ID
     */
    public Retail(final double priceUsd,
                  final Address address,
                  final String type,
                  final String propertyId,
                  final int squareFootage,
                  final boolean customerParking)
    {
        super(priceUsd, address, type, propertyId);

        // squareFootage check
        if (squareFootage < MINIMUM_SQUARE_FOOTAGE)
        {
            throw new IllegalArgumentException("Invalid square footage: " + squareFootage);
        }
        else
        {
            this.squareFootage = squareFootage;
        }

        this.customerParking = customerParking;
    }

    /**
     * getters
     * @return numberOfBedrooms, isSwimmingPool, isStrata
     */
    public int getSquareFootage() {
        return squareFootage;
    }

    public boolean isCustomerParking() {
        return customerParking;
    }

    /**
     * To string method
     * @return state of Retail types
     */
    @Override
    public String toString() {
        return "Retail [squareFootage=" + squareFootage + ", customerParking=" + customerParking + ", " + super.toString() + "]";
    }
}
