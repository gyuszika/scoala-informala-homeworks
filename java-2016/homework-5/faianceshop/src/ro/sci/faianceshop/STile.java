package ro.sci.faianceshop;

/**
 * The STile child class inherits methods from AbstractTile class.
 * 
 * @author Gyuszika
 *
 */

public class STile extends AbstractTile {
	/**
	 * Sets values for the price of the Tile/Surface type tile.
	 * 
	 * @param priceForSTile
	 */
	public STile(double priceForSTile) {// , double sTileLength, double
										// sTileWidth) {
		super(priceForSTile);// , sTileLength, sTileWidth);

	}

	/**
	 * Following method overrides method for calculating price for covering
	 * surface with Tile/Surface type tiles.
	 * <p>
	 * <b>Returns price for covering surface's area.
	 */
	@Override
	public double calculatePrice(double surfaceToCover) {

		return surfaceToCover / 1000 * price;
	}

	/**
	 * Method is inherited from parent class but it's not used for any
	 * calculation.
	 */
	@Override
	public double calculateArea() {

		return length * width;
	}

}
