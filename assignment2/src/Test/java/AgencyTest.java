import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AgencyTest {
	
	private static Agency agency;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		ArrayList<Address> addresses = AddressReader.readAddressData(new File("address_data.txt"));

		ArrayList<String> propertyData = PropertyReader.readPropertyData(new File("property_data.txt"));

		agency = new Agency("Properties R Us");

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

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		agency = null;
	}

	@Test
	void testGetProperty() {

		Property prop = agency.getProperty("abc123");
		assertEquals("abc123", prop.getPropertyId());
		prop = agency.getProperty("333");
		assertNull(prop);
	}
	
	@Test
	void testGetPropertiesBetween() {
		
		Property[] props = agency.getPropertiesBetween(1000000.0,  2000000.0);
		Arrays.sort(props,(p1, p2) -> p1.getPropertyId().compareTo(p2.getPropertyId()));
		assertEquals(2, props.length);
		assertEquals("876tru", props[0].getPropertyId());
		assertEquals("9000a", props[1].getPropertyId());
	}
	
	@Test
	void testGetPropertiesOn() {
		
		ArrayList<Address> addresses = agency.getPropertiesOn("56th avenue");
		assertEquals(1, addresses.size());
		assertEquals("56th avenue", addresses.get(0).getStreetName());
		addresses = agency.getPropertiesOn("Bullwinkle Drive");
		assertEquals(0, addresses.size());
	}
	
	@Test
	void testGetPropertiesOfType() {
		ArrayList<Property> props = agency.getPropertiesOfType("residence");
		assertEquals(7, props.size());
		props = agency.getPropertiesOfType("commercial");
		assertEquals(3, props.size());
		props = agency.getPropertiesOfType("retail");
		assertEquals(2, props.size());
		props = agency.getPropertiesOfType("appartments");
		assertEquals(0, props.size());
		
	}
	
	@Test
	void testGetPropertiesWithPools() {
		ArrayList<Residence> props = agency.getPropertiesWithPools();
		Collections.sort(props,(p1, p2) -> p1.getPropertyId().compareTo(p2.getPropertyId()));
		
		assertEquals(3, props.size());
		assertEquals("777def", props.get(0).getPropertyId());
		assertEquals("78444a", props.get(1).getPropertyId());
		assertEquals("xyz789", props.get(2).getPropertyId());
	}
	
	@Test
	void testGetPropertiesWithBedrooms() {
		HashMap<String, Residence> props = agency.getPropertiesWithBedrooms(3, 4);
		SortedSet<String> keys = new TreeSet<>(props.keySet());
		ArrayList<String> propsList = new ArrayList(keys);
		
		assertEquals(2, keys.size());
		assertEquals("9000a", props.get(propsList.get(0)).getPropertyId());
		assertEquals("mr6789", props.get(propsList.get(1)).getPropertyId());
	}
	
	@Test
	void testGetPropertiesWithStrata() {
		ArrayList<Residence> props = agency.getPropertiesWithStrata();
		assertEquals(1, props.size());
		assertEquals("abc123", props.get(0).getPropertyId());
	}
	
	@Test
	void testGetPropertiesWithLoadingDocks() {
		ArrayList<Commercial> props = agency.getPropertiesWithLoadingDocks();
		assertEquals(1, props.size());
		assertEquals("678T", props.get(0).getPropertyId());
	}
	
	@Test
	void testGetPropertiesWithHighwayAccess() {
		ArrayList<Commercial> props = agency.getPropertiesWithHighwayAccess();
		assertEquals(2, props.size());
	}
	
	@Test
	void testGetPropertiesSquareFootage() {
		ArrayList<Retail> props = agency.getPropertiesSquareFootage(800);
		assertEquals(1, props.size());
		assertEquals("876tru", props.get(0).getPropertyId());
	}
	
	@Test
	void testGetPropertiesWithCustomerParking() {
		ArrayList<Retail> props = agency.getPropertiesWithCustomerParking();
		assertEquals(1, props.size());
		assertEquals("876tru", props.get(0).getPropertyId());
	}

}
