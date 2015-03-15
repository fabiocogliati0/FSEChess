/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

import model.ChessPieces.ChessPiece;

/**
 * Interface of a class that represent one chessBoard (pieces and turn) configuration
 */
public interface Configuration {
	
	/**
	 * Returns the piece at the tile in position (x,y). It returns null if there is no piece of that tile
	 */
	public ChessPiece at(int x,int y);
	
	/**
	 * Gets the current turn color
	 */
	public boolean getTurnColor();
	
	/**
	 * Create a new configuration starting from this executing the passed move
	 */
	public Configuration swap(int fromX, int fromY, int intoX, int intoY);
	
	/**
	 * Checks if the player of color "color" is in chess in this configuration
	 */
	public boolean isChessConfiguration(boolean color);
	
	/**
	 * Checks if there are no legal movement for the player of color "color" in this configuration
	 */
	public boolean noLegalmoves(boolean color);
	
	/**
	 * Checks if the passed move is legal
	 */
	public boolean isLegalMove(int formX, int fromY, int toX, int toY);
}
