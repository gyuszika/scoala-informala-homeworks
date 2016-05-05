package ro.sci.faianceshop;

/**
 * This AbstractTile is the parent abstract class.
 * 
 * @author Gyuszika
 *
 */
public abstract class AbstractTile implements Tile {

	protected double width;
	protected double length;
	protected double price;

	public AbstractTile(double priceForSTile) {
		price = priceForSTile;

	}

	public AbstractTile(double priceForPTile, double pTileLength, double pTileWidth) {
		length = pTileLength;
		width = pTileWidth;
		price = priceForPTile;

	}

	public double getPrice() {
		return price;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

}
