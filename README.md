# COMP2501_RealEstateProjectV2
We are building on top of what we created in the first RealEstateProjectV1. This time around we will focus on design by incorporating Inheritance, reading data files, and on providing an interface so users can interact with the program at runtime.

### Assignment2 Class

**Instance Variables:**
      1. Agency: reference to the Agency class

 **Methods:** 
 Get methods for all instance variables
 
1. public void init() throws FileNotFoundException: This method gets the ArrayList,<Address> and ArrayList<String> form AddressReader and PropertyReader, and uses them to create subtype Objects and adds them to the Agency.HashMap<String, Property> properties
2. public void doSearches() provides the primary user interface through command prompts that will allow the user to choose which search operations to perform. Each search will display results to the console.
3. public static void main(String[] args) throws FileNotFoundException: Will create an instance of Assignment2 and use that to call init() and then doSearches().

### Commercial Class

**Instance Variables:**

1. loadingDock (boolean: indicates if it has a loading dock)
2. highwayAccess (boolean: indicates if easy access to a highway)

**Methods:**
  1. Subtype of Property
  2. Get methods for all fields
  3. toString() for displaying the state of Commercial types

### PropertyReader Class

**Methods:**
      public static ArrayList<String> readPropertyData(File file) throws FileNotFoundException: reads “property_data.txt” (provided) and adds Strings (for each line) to an ArrayList<String> and returns it

### Residence Class

**Instance Variables:**
  1. numberOfBedrooms (int: must not be less than 1)
  2. swimmingPool (boolean: indicates presence of a pool)
  3. strata (boolean: indicates if part of a strata)

**Methods:**
  1. Subtype of Property
  2. Get methods for all fields
  3. toString() for displaying the state of Residence types

### Retail class

**Instance Variables:**
  1. squareFootage (int: the amount of floor space available)
  2. customerParking (boolean: indicates if customer parking is available)
     
**Methods:**
  1. Subtype of Property
  2. Get methods for all fields
  3. toString() for displaying the state of Retail types

### AgencyTest Class

To test all the methods in Agency Class.

### Address Class:

Represents the address details of a property, including unit number, street number, street name, postal code, and city.

### Agency Class:

Manages a list of properties through a HashMap, where each property is associated with a unique property ID.
Includes methods to add, remove, and retrieve properties, as well as perform various queries such as getting the total property values, properties with pools, properties within a specified price range, and more.

### Property Class:

Represents a real estate property with various attributes such as price, address, number of bedrooms, swimming pool availability, type, and a unique property ID.
Includes methods to retrieve information about the property and set the price.
