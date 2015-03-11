/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

public class Bishop extends ChessPiece{
	
	public Bishop(boolean color) {
		super(color);
	}

	public boolean legalMove(int fromX, int fromY, int toX, int toY){
		
		int distX = Math.abs(toX - fromX);
		int distY = Math.abs(toY - fromY);
		
		if(distX == distY && distX != 0){
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
