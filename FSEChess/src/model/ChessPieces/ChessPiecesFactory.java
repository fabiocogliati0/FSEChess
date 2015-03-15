package model.ChessPieces;

/**
 * Interface for all factories of pieces
 */
public interface ChessPiecesFactory {

	/**
	 * Factory method that creates a pieces of the passed type and the passed color
	 */
	public ChessPiece createPiece(String type, boolean color);
}
