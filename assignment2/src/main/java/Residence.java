/**
 * Class: Residence extends Property
 *
 * Instance Variables:
 *      1. numberOfBedrooms(int: must not be less than 1)
 *      2. swimmingPool (boolean: indicates presence of a pool)
 *      3. strata (boolean: indicates if part of a strata)
 *
 * Methods:
 *      1. Subtype of Property
 *      2. Get methods for all fields
 *      3. toString() for displaying the state of Residence types
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Residence extends Property
{
    private int numberOfBedrooms;
    private boolean swimmingPool;
    private boolean strata;

    private static final int MINIMUM_NUMBER_OF_BEDROOMS = 1;
    private static final int MAXIMUM_NUMBER_OF_BEDROOMS = 20;

    /**
     * constructor
     * @param numberOfBedrooms - number of bedroom
     * @param swimmingPool     - whether it has a swimming pool or not
     * @param strata           - whether it is a part of strata or not
     * @param priceUsd         - price in USD
     * @param address          - property's address
     * @param type             - type of property (“residence”, “commercial”, or “retail”)
     * @param propertyId       - property ID
     */
    public Residence(final double priceUsd,
                     final Address address,
                     final int numberOfBedrooms,
                     final boolean swimmingPool,
                     final String type,
                     final String propertyId,
                     final boolean strata)
    {
        super(priceUsd, address, type, propertyId);

        // numOfBedrooms check
        if (numberOfBedrooms < MINIMUM_NUMBER_OF_BEDROOMS || numberOfBedrooms > MAXIMUM_NUMBER_OF_BEDROOMS)
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }
        else
        {
            this.numberOfBedrooms = numberOfBedrooms;
        }

        this.swimmingPool = swimmingPool;
        this.strata = strata;
    }

    /**
     * getters
     * @return numberOfBedrooms, isSwimmingPool, isStrata
     */
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public boolean isStrata() {
        return strata;
    }

    /**
     * To String method
     * @return state of Residence types
     */
    @Override
    public String toString() {
        return "Residence [numberOfBedrooms=" + numberOfBedrooms + ", swimmingPool=" + swimmingPool + ", strata=" + strata + ", " + super.toString() + "]";
    }

}
