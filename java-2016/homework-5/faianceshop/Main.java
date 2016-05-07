package ro.sci.faianceshop;

/**
 * This main class Main allow the application to calculate price to cover a surface with the following Tile types: Tiles/Surface, Tiles/Piece, Rectangular Tiles/Piece.
 * @author Gyuszika
 *<b>It allow to define the surface area which need covering.</b>
 *<p>
 *<b>It allow to define tile size(for Tiles/Piece)and price per tile(for he Tiles/Surface).</b>
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double surfaceToCover = 6000;
		double priceForSTile = 20;
		//double sTileLength = 50;
		//double sTileWidth = 50;

		double priceForPTile = 25;
		double pTileLength = 20;
		double pTileWidth = 20;

		double priceForPTTile = 40;
		double pTTileLeg = 25;

		double sTileCost = calculateSTileCost(surfaceToCover, priceForSTile);//, sTileLength, sTileWidth);

		System.out.println("1. Cost for covering the surface with S type tiles: " + sTileCost);

		double pTileCost = calculatePTileCost(surfaceToCover, priceForPTile, pTileLength, pTileWidth);

		System.out.println("2. Cost for covering the surface with P type tiles: " + pTileCost);

		double sum = calculateCombinedTileCost(surfaceToCover, priceForPTile, pTileLength, pTileWidth, priceForSTile);// sTileLength, sTileWidth);

		System.out.println("3. Cost for covering the surface with combination of P type tiles and S type tiles:" + sum);

		double pTTileCost = calculatePTTileCost(surfaceToCover, priceForPTTile, pTTileLeg);

		System.out.println("4. Cost for covering the surface with PT type tiles:" + pTTileCost);
	}
	/**
	 * Calculates price for covering area with Tile/Surface type tiles.
	 * 
	 * @param surfaceToCover holds value of the surface's area
	 * @param priceForSTile holds price for Tile/Surface type tile
	 * @return returns price for covering surface area
	 */
	public static double calculateSTileCost(double surfaceToCover, double priceForSTile){//, double sTileLength, double sTileWidth) {
		Tile sTypeTile = new STile(priceForSTile); //, sTileLength, sTileWidth);

		return sTypeTile.calculatePrice(surfaceToCover);

	}
	/**
	 * Calculates price for covering surface with the Tile/Piece type tiles.
	 * @param surfaceToCover holds value of the surface's area
	 * @param priceForPTile holds price of the Tile/Piece type tile
	 * @param pTileLength holds tiles length value
	 * @param pTileWidth holds tiles width value
	 * @return returns price for covering surface area
	 */
	private static double calculatePTileCost(double surfaceToCover, double priceForPTile, double pTileLength, double pTileWidth) {
		Tile pTypeTile = new PTile(priceForPTile, pTileLength, pTileWidth);

		return pTypeTile.calculatePrice(surfaceToCover);

	}
	/**
	 * Following method calculates price for covering surface area with 50% of both type tiles(Tile/Piece & Tile/Surface).
	 * @param surfaceToCover holds value of the surface's area
	 * @param priceForPTile holds price of the Tile/Piece type tile
	 * @param pTileLength holds tiles length value
	 * @param pTileWidth holds tiles width value
	 * @param priceForSTile holds price for Tile/Surface type tile
	 * @return returns price for covering surface area
	 */
	private static double calculateCombinedTileCost(double surfaceToCover, double priceForPTile, double pTileLength, double pTileWidth, double priceForSTile) {//,
			//double sTileLength, double sTileWidth) {

		Tile pTypeTile = new PTile(priceForPTile, pTileLength, pTileWidth);
		Tile sTypeTile = new STile(priceForSTile);//, sTileLength, sTileWidth);

		double sum = pTypeTile.calculatePrice(surfaceToCover / 2) + sTypeTile.calculatePrice(surfaceToCover / 2);

		return sum;

	}
	/**
	 * Following method calculates price for covering surface's are with isosceles right triangle type tiles.
	 * @param surfaceToCover holds value of the surface's area
	 * @param priceForPTTile holds price for isosceles right triangle type tile
	 * @param pTTileLeg holds value for leg's length
	 * @return returns price for covering surface area
	 */
	private static double calculatePTTileCost(double surfaceToCover, double priceForPTTile, double pTTileLeg) {
		Tile pTTypeTile = new PTTile(priceForPTTile, pTTileLeg);

		return pTTypeTile.calculatePrice(surfaceToCover);

	}

}
