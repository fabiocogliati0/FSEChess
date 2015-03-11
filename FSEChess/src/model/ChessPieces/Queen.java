/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

public class Queen extends ChessPiece{

	public Queen(boolean color) {
		super(color);
	}

	public boolean legalMove(int fromX, int fromY, int toX, int toY){
		
		int distX = Math.abs(toX - fromX);
		int distY = Math.abs(toY - fromY);
		
		//Rook Behaviour
		if(distX == 0 || distY == 0){
			return true;
		}
		else{
			//Bishop Behaviour
			if(distX == distY && distX != 0){
				return true;
			}
			else{
				return false;
			}
		}
		
	}
	
	public boolean canFly(){
		return false;
	}
	
}
