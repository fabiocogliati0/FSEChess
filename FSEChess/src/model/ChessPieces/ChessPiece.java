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
	
	//ritorna il path del file della immagine del pezzo
	public String getImagePath(){
		
		String path = Constants.imgDirectory + "/";
		if(isWhite()){
			path += Constants.imgWhitePiecesFilePrefix;
		}
		else{
			path += Constants.imgBlackPiecesFilePrefix;
		}
		path += this.getClass().getSimpleName() + Constants.imgExtension;
		return path;
	}
	
	@Override
	public String toString(){
		String string = getClass().getName();
		if(color == Constants.whiteColor) string += "White";
		else string += "Black";
		return string;
	}
}
