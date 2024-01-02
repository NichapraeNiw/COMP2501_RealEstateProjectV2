/**
 * Class: Commercial extends Property
 *
 * Instance Variables:
 *      1. loadingDock (boolean: indicates if it has a loading dock)
 *      2. highwayAccess (boolean: indicates if easy access to a highway)
 *
 * Methods:
 *      1. Subtype of Property
 *      2. Get methods for all fields
 *      3. toString() for displaying the state of Commercial types
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Commercial extends Property
{
    private boolean loadingDock;
    private boolean highwayAccess;

    /**
     * constructor
     * @param loadingDock      - indicates if it has a loading dock
     * @param highwayAccess    - indicates if easy access to a highway
     * @param priceUsd         - price in USD
     * @param address          - property's address
     * @param type             - type of property (“residence”, “commercial”, or “retail”)
     * @param propertyId       - property ID
     */
    public Commercial(final double priceUsd,
                      final Address address,
                      final String type,
                      final String propertyId,
                      final boolean loadingDock,
                      final boolean highwayAccess)
    {
        super(priceUsd, address, type, propertyId);

        this.loadingDock = loadingDock;
        this.highwayAccess = highwayAccess;
    }

    /**
     * getters
     * @return isLoadingDock, isHighwayAccess
     */
    public boolean isLoadingDock() {
        return loadingDock;
    }

    public boolean isHighwayAccess() {
        return highwayAccess;
    }

    /**
     * To String method
     * @return state of Commercial types
     */
    @Override
    public String toString() {
        return "Commercial [loadingDock=" + loadingDock + ", highwayAccess=" + highwayAccess + ", " + super.toString() + "]";
    }
}
