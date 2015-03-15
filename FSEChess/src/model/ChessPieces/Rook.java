/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

import model.Configuration;

/**
 * Class that represent Rook Piece
 */
public class Rook extends ChessPiece{

	/**
	 * Constructor that takes the color of the piece
	 */
	public Rook(boolean color) {
		super(color);
	}
	
	/**
	 * Check if the piece can make passed move in an ideal empty and infinite chessBoard.
	 * The configuration will be checked only if the piece have some special move that is triggered only depending other
	 * pieces on the board (like pawns)
	 */
	public boolean canMove(int fromX, int fromY, int toX, int toY, Configuration configuration){
		
		int distX = toX - fromX;
		int distY = toY - fromY;
		
		if((distX == 0 && distY!=0) || (distY == 0 && distX!=0)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	/**
	 * Returns true if the piece can pass through the other pieces, this piece can't
	 */
	public boolean canFly(){
		return false;
	}
}
