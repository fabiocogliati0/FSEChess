/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

import model.Configuration;

public class Rook extends ChessPiece{

	public Rook(boolean color) {
		super(color);
	}
	
	public boolean legalMove(int fromX, int fromY, int toX, int toY, Configuration configuration){
		
		int distX = toX - fromX;
		int distY = toY - fromY;
		
		if((distX == 0 && distY!=0) || (distY == 0 && distX!=0)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean canFly(){
		return false;
	}
}
