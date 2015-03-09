/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

import model.Constants;

public abstract class ChessPiece {
	
	private boolean color;

	public ChessPiece(boolean color){
		this.color = color;
	}
	
	public boolean isWhite(){
		return (color==Constants.whiteColor);
	}
	
	public boolean isBlack(){
		return (color==Constants.blackColor);
	}

	public boolean getColor(){
		return color;
	}
	
}
