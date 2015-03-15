/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model.ChessPieces;

import model.Configuration;
import model.Constants;

/**
 * Abstract class that represent a general chess piece
 */
public abstract class ChessPiece {
	
	/**
	 * Color of the ChessPiece
	 */
	private boolean color;

	
	
	/**
	 * Constructor that takes the color of the piece
	 */
	public ChessPiece(boolean color){
		this.color = color;
	}
	
	/**
	 * Returns true if the piece is white
	 */
	public boolean isWhite(){
		return (color==Constants.whiteColor);
	}
	
	/**
	 * Returns true if the piece is black
	 */
	public boolean isBlack(){
		return (color==Constants.blackColor);
	}

	/**
	 * Returns true if the piece is of the passed color
	 */
	public boolean isOfColor(boolean color){
		return (this.color == color);
	}
	
	/**
	 * Returns true if the piece is of the same color of the passed piece
	 */
	public boolean isOfColor(ChessPiece other){
		return (this.isOfColor(other.getColor()));
	}
	
	/**
	 * Returns the color of the piece
	 */
	public boolean getColor(){
		return color;
	}
	
	/**
	 * Check if the piece can make passed move in an ideal empty and infinite chessBoard.
	 * The configuration will be checked only if the piece have some special move that is triggered only depending other
	 * pieces on the board (like pawns)
	 */
	public abstract boolean canMove(int fromX, int fromY, int toX, int toY, Configuration configuration);
	
	/**
	 * Returns true if the piece can pass through the other pieces (like knight)
	 */
	public abstract boolean canFly();
	
	/**
	 * Return the image file path of the piece
	 */
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

}
