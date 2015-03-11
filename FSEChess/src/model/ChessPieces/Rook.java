/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

public class Rook extends ChessPiece{

	public Rook(boolean color) {
		super(color);
	}
	
	public boolean legalMove(int fromX, int fromY, int toX, int toY){
		
		int distX = toX - fromX;
		int distY = toY - fromY;
		
		if(distX == 0 || distY == 0){
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
