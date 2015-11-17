package yoffe.ups;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/**
	 * Add a Package to a Location. Verify that the Package is returned with
	 * getPackages(). Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase database = new UPSDatabase();
		Location loc = new Location(32, 24);
		Package pkg = new Package("ABC123");
		database.addPackageToLocation(loc, pkg);

		Assert.assertTrue(database.getPackages(loc).contains(pkg));
		Assert.assertEquals(loc, database.getLocation(pkg));

	}

	@Test
	/**
	 * Add a Package to a Location then update the Package Location to a
	 * different Location. Verify that the Package is returned with
	 * getPackages(). Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with
	 * the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase database = new UPSDatabase();
		Location loc = new Location(231, 234);
		Location newLoc = new Location(345, 654);
		Package pkg = new Package("ADC123");
		database.addPackageToLocation(loc, pkg);
		database.updatePackageLocation(pkg, newLoc);

		Assert.assertFalse(database.getPackages(loc).contains(pkg));
		Assert.assertTrue(database.getPackages(newLoc).contains(pkg));
		Assert.assertEquals(newLoc, database.getLocation(pkg));

	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with a
	 * Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase database = new UPSDatabase();
		Assert.assertTrue(database.getPackages(new Location(56, 46)).size() == 0);
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase database = new UPSDatabase();
		Package pkg = new Package("231DFG");
		Assert.assertNull(database.getLocation(pkg));

	}
}
