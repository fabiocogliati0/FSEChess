/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package model;

/**
 * Class used to represent some constants that all the classes need
 */
public final class Constants{
	
	/**
	 * Number of rows of the chessBoard
	 */
	public final static int tileSizeX = 8;
	
	/**
	 * Number of columns of the ChessBoard
	 */
	public final static int tileSizeY = 8;
	
	/**
	 * Boolean value used to represent whiteColor
	 */
	public final static boolean whiteColor = true;
	
	/**
	 * Boolean value used to represent BlackColor
	 */
	public final static boolean blackColor = false;
	
	/**
	 * Directory path that contains all the images
	 */
	public final static String imgDirectory = "img";
	
	/**
	 * Name prefix for all the image files that represent white pieces
	 */
	public final static String imgWhitePiecesFilePrefix = "White";
	
	/**
	 * Name prefix for all the image files that represent black pieces
	 */
	public final static String imgBlackPiecesFilePrefix = "Black";
	
	/**
	 * Extension of all images
	 */
	public final static String imgExtension = ".png";
	
	
	
	
	private Constants(){}
	
}
