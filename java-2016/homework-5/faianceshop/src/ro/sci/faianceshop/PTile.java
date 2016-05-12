package ro.sci.faianceshop;

/**
 * The PTile child class inherits methods from AbstractTile class.
 * 
 * @author Gyuszika
 *
 */
public class PTile extends AbstractTile {
	/**
	 * Calculates price for covering surface with the Tile/Piece type tiles.
	 * 
	 * @param priceForPTile
	 *            holds price of the Tile/Piece type tile
	 * @param pTileLength
	 *            holds tiles length value
	 * @param pTileWidth
	 *            holds tiles width value
	 */
	public PTile(double priceForPTile, double pTileLength, double pTileWidth) {
		super(priceForPTile, pTileLength, pTileWidth);

	}

	/**
	 * Following method overrides method for calculating price for covering
	 * surface with Tile/Piece type tiles.
	 * <p>
	 * <b>Returns price for covering surface's area.
	 */
	@Override
	public double calculatePrice(double surfaceToCover) {
		double quantity = surfaceToCover / calculateArea();
		return quantity * price;
	}

	/**
	 * Method is calculating the surface area of one Tile/Piece type tile.
	 */
	@Override
	public double calculateArea() {

		return length * width;
	}

}
