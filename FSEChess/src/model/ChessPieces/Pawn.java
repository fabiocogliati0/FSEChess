/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

public class Pawn extends ChessPiece{

	public Pawn(boolean color) {
		super(color);
	}

	//per ora muovono solo in avanti
	public boolean legalMove(int fromX, int fromY, int toX, int toY){
		
		int distX = toX - fromX;
		int distY = toY - fromY;
		
		boolean legal = false;
		
		if(distY==0){
			if(isWhite()){
				if(distX == -1) legal = true;
				else if(distX == -2 && fromX == 6) legal = true;
			}
			if(isBlack()){
				if(distX == 1) legal = true;
				else if(distX == 2 && fromX == 1) legal = true;
			}
		}
		
		return legal;
	}
	
	public boolean canFly(){
		return false;
	}
}
