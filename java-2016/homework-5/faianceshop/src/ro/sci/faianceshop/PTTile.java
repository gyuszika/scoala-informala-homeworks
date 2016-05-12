package ro.sci.faianceshop;

/**
 * The PTTile child class inherits methods from AbstractTile class.
 * 
 * @author Gyuszika
 *
 */
public class PTTile extends AbstractTile {
	/**
	 * Sets price for PTTile/Piece type tile.
	 * 
	 * @param priceForSTile
	 *            holds value for the PTTile/Piece type tile
	 */
	public PTTile(double priceForSTile) {
		super(priceForSTile);

	}

	public PTTile(double priceForPTTile, double pTTileLeg) {
		super(priceForPTTile, pTTileLeg, pTTileLeg);

	}

	/**
	 * Calculates price for covering are with PTTile/Piece type tile.
	 */
	@Override
	public double calculatePrice(double surfaceToCover) {
		double quantity = surfaceToCover / calculateArea();
		return quantity * price;

	}

	/**
	 * Calculates the surface area of one PTTile/Piece type tile.
	 */
	@Override
	public double calculateArea() {

		return (length * width) / 2;
	}

}
