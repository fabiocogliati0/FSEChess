/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

import model.Configuration;

/**
 * Class that represent King Piece
 */
public class King extends ChessPiece{
	
	/**
	 * Constructor that takes the color of the piece
	 */
	public King(boolean color) {
		super(color);
	}
	
	/**
	 * Check if the piece can make passed move in an ideal empty and infinite chessBoard.
	 * The configuration will be checked only if the piece have some special move that is triggered only depending other
	 * pieces on the board (like pawns)
	 */
	public boolean canMove(int fromX, int fromY, int toX, int toY, Configuration configuration){
		
		int distX = Math.abs(toX - fromX);
		int distY = Math.abs(toY - fromY);
		
		if(distX<=1 && distY<=1 && (distX==1 || distY==1)){
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
