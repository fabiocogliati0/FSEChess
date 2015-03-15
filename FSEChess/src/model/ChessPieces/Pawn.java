/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

import model.Configuration;

/**
 * Class that represent Pawn Piece
 */
public class Pawn extends ChessPiece{

	/**
	 * Constructor that takes the color of the piece
	 */
	public Pawn(boolean color) {
		super(color);
	}

	/**
	 * Check if the piece can make passed move in an ideal empty and infinite chessBoard.
	 * The configuration will be checked only if the piece have some special move that is triggered only depending other
	 * pieces on the board (like pawns)
	 */
	public boolean canMove(int fromX, int fromY, int toX, int toY, Configuration configuration){
		
		if(configuration==null) 
			throw new IllegalArgumentException("Can't check all moves of a pawn without configuration");
		
		int distX = toX - fromX;
		int distY = toY - fromY;
		
		boolean legal = false;
		
		if(distY==0){
			if(configuration.at(toX, toY) == null){
				if(isWhite()){
					if(distX == -1) legal = true;
					else if(distX == -2 && fromX == 6) legal = true;
				}
				if(isBlack()){
					if(distX == 1) legal = true;
					else if(distX == 2 && fromX == 1) legal = true;
				}
			}
		}
		else if(distY == -1 || distY == 1){
			if(configuration.at(toX, toY)!= null && !configuration.at(toX, toY).isOfColor(this.getColor())){
				if(isWhite() && distX == -1){
					legal = true;
				}
				if(isBlack() && distX == 1){
					legal = true;
				}
			}
		}
		
		
		return legal;
	}
	
	/**
	 * Returns true if the piece can pass through the other pieces, this piece can
	 */
	public boolean canFly(){
		return false;
	}
}
