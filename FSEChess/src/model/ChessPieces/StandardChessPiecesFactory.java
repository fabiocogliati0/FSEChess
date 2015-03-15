package model.ChessPieces;

/**
 * Factory class that create standard chess pieces (Pawns, Bishops, Knights, Rooks, Kings and Queens)
 */
public class StandardChessPiecesFactory implements ChessPiecesFactory {

	/**
	 * Factory method that creates a pieces of the passed type and the passed color
	 */
	@Override
	public ChessPiece createPiece(String type, boolean color){
		
		switch(type){
		case "pawn":
			return new Pawn(color);
		case "bishop":
			return new Bishop(color);
		case "rook":
			return new Rook(color);
		case "knight":
			return new Knight(color);
		case "king":
			return new King(color);
		case "queen":
			return new Queen(color);
		default: 
			throw new IllegalArgumentException("this factory can't create chess pieces of type " + type);
		}
		
	}
	
}
