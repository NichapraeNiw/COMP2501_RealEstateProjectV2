/**
 * Class: Address
 *
 * Instance Variables:
 *      1. Unit number (String: must be one to four characters)
 *      2. Street number (int must be 0 to 999999)
 *      3. Street name (String: must be one to twenty characters)
 *      4. Postal code (String: must be either length 5 or length 6)
 *      5. City (String: must be one to thirty characters)
 *
 * Methods: Get methods for all instance variables
 *
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Address {

    private String unitNumber;
    private String streetNumber;
    private String streetName;
    private String postalCode;
    private String city;

    private static final int MINIMUM_UNIT_NUMBER_LENGTH = 1;
    private static final int MAXIMUM_UNIT_NUMBER_LENGTH = 4;
    private static final int MINIMUM_STREET_NUMBER_LENGTH = 1;
    private static final int MAXIMUM_STREET_NUMBER_LENGTH = 6;
    private static final int MINIMUM_STREET_NAME_LENGTH = 1;
    private static final int MAXIMUM_STREET_NAME_LENGTH = 20;
    private static final int MINIMUM_POSTAL_CODE_LENGTH = 5;
    private static final int MAXIMUM_POSTAL_CODE_LENGTH = 6;
    private static final int MINIMUM_CITY_LENGTH = 1;
    private static final int MAXIMUM_CITY_LENGTH = 30;

    /**
     * constructor
     * @param unitNumber    - unit number
     * @param streetNumber  - street number
     * @param streetName    - street name
     * @param postalCode    - postal code
     * @param city          - city
     */
    public Address(String unitNumber,
                   final String streetNumber,
                   final String streetName,
                   final String postalCode,
                   final String city) {
        // unitNumber check
        if (unitNumber != null) {
            if (unitNumber.length() < MINIMUM_UNIT_NUMBER_LENGTH || unitNumber.length() > MAXIMUM_UNIT_NUMBER_LENGTH) {
                throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
            }
        }
        this.unitNumber = unitNumber;

        // streetNumber check
        if (streetNumber != null) {
            if (unitNumber.length() < MINIMUM_STREET_NUMBER_LENGTH || unitNumber.length() > MAXIMUM_STREET_NUMBER_LENGTH) {
                throw new IllegalArgumentException("Invalid unit number: " + streetNumber);
            }
        }
        this.streetNumber = streetNumber;

        // streetName check
        if (streetName == null)
        {
            throw new NullPointerException("Invalid street name: " + streetName);
        }
        else if (streetName.isBlank() || streetName.strip().length() < MINIMUM_STREET_NAME_LENGTH || streetName.strip().length() > MAXIMUM_STREET_NAME_LENGTH) {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }
        else {
            this.streetName = streetName;
        }

        // postalCode check
        if (postalCode == null || postalCode.isBlank())
        {
            throw new NullPointerException("Invalid postal code: " + postalCode);
        }
        else if (postalCode.strip().length() < MINIMUM_POSTAL_CODE_LENGTH || postalCode.strip().length() > MAXIMUM_POSTAL_CODE_LENGTH)
        {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        }
        else {
            this.postalCode = postalCode;
        }

        // city check
        if (city == null)
        {
            throw new NullPointerException("Invalid city: " + city);
        }
        else if (city.isBlank() || city.strip().length() < MINIMUM_CITY_LENGTH || city.strip().length() > MAXIMUM_CITY_LENGTH)
        {
            throw new IllegalArgumentException("Invalid city: " + city);
        }
        else {
            this.city = city;
        }
    }

    /**
     * getters
     * @return unitNumber, streetNumber, streetName, postalCode, city
     */
    public String getUnitNumber()
    {
        return unitNumber;
    }

    public String getStreetNumber()
    {
        return streetNumber;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getCity()
    {
        return city;
    }

    /**
     * To string method
     * @return the state of Address objects
     */
    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
