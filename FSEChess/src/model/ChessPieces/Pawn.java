/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

import model.Configuration;

public class Pawn extends ChessPiece{

	public Pawn(boolean color) {
		super(color);
	}

	public boolean legalMove(int fromX, int fromY, int toX, int toY, Configuration configuration){
		
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
	
	public boolean canFly(){
		return false;
	}
}
