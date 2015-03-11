/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

public class King extends ChessPiece{
	
	public King(boolean color) {
		super(color);
	}
	
	public boolean legalMove(int fromX, int fromY, int toX, int toY){
		
		int distX = Math.abs(toX - fromX);
		int distY = Math.abs(toY - fromY);
		
		if(distX<=1 && distY<=1 && (distX==1 || distY==1)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean canFly(){
		return true;
	}

}
