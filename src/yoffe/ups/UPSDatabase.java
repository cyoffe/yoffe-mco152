package yoffe.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {

	HashMap<Location, HashSet<Package>> shipping;
	HashMap<Package, Location> packageInfo;

	public UPSDatabase() {
		shipping = new HashMap<Location, HashSet<Package>>();
		packageInfo = new HashMap<Package, Location>();
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		HashSet<Package> pkgs = shipping.get(location);
		if (pkgs == null) {
			pkgs = new HashSet<Package>();
			pkgs.add(pkg);
			shipping.put(location, pkgs);
			packageInfo.put(pkg, location);
		} else {
			shipping.get(location).add(pkg);
			packageInfo.put(pkg, location);
		}
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		Location oldLocation = packageInfo.get(pkg);
		shipping.get(oldLocation).remove(pkg);

		addPackageToLocation(location, pkg);
		packageInfo.put(pkg, location);

	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		if (shipping.get(location) == null) {
			Set<Package> packages = new HashSet<Package>();
			return packages;
		} else {
			return shipping.get(location);
		}
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return packageInfo.get(pkg);
	}

}
