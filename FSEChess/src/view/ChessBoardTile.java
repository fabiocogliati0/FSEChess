package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Constants;
import model.ChessPieces.ChessPiece;

/**
 * A panel that represent a single tile of the chessBoard
 */
public class ChessBoardTile extends JPanel{
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 3L;

	/**
	 * Color of the background of the button of the white tile
	 */
	private final static Color deselectedButtonColorWhite = new Color(1.0f, 1.0f, 1.0f);
	
	/**
	 * Color of the background of the button of the black tile
	 */
	private final static Color deselectedButtonColorBlack = new Color(0.4f, 0.4f, 0.4f);
	
	/**
	 * Color of the button of the tile with a piece selected by the user
	 */
	private final static Color selectedPieceButtonColor = new Color(0.0f, 0.0f, 1.0f);

	/**
	 * Color of the button of a tile that is a legal move for the selected piece
	 */
	private final static Color selectedButtonColor = new Color(0.0f, 0.8f, 0.8f);
	
	/**
	 * Horizontal size of the sprite of the chess pieces
	 */
	private final static int chessPieceImageSizeX = 60;
	
	/**
	 * Vertical size of the sprite of the chess pieces
	 */
	private final static int chessPieceImageSizeY = 60;
	
	/**
	 * The current tile color
	 */
	private final boolean tileColor;
	
	/**
	 * JLaebl that contains the sprite of the chess piece
	 */
	private JLabel label;
	
	/**
	 * Button that represent the chess tile
	 */
	private final JButton button;
	
	/**
	 * LayeredPane used to paint on the screen button and label in the right order 
	 */
	private final JLayeredPane layeredPane;
	
	
	
	
	/**
	 * Constructor of an empty tile
	 */
	public ChessBoardTile(int x, int y, boolean tileColor, JButton button){
		this(x,y,tileColor,button, null);
	}

	/**
	 * Constructor of a tile with a piece on it
	 */
	public ChessBoardTile(int x, int y, boolean tileColor, JButton button, ChessPiece chessPiece){
		
		super();
		
		this.button = button;
		this.label = new JLabel();
		this.tileColor = tileColor;
		
		setPiece(chessPiece);
		
		layeredPane = new JLayeredPane();
		int padding = 40;
		layeredPane.setPreferredSize(new Dimension((782 - padding)/8, (753 - padding)/8));
		layeredPane.add(button, new Integer(50));
		layeredPane.add(label, new Integer(100));
		
		layeredPane.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		label.setBounds(15, 0, 800/8, 800/8 ); 
        button.setBounds( 0, 0,  800/8, 800/8 );
		
		this.add(layeredPane);
		
		deselectTile();
		
	}
	
	/**
	 * Places the image of a piece on the tile
	 */
	public void setPiece(ChessPiece piece){
		label.setIcon(null);
		ImageIcon image = getPieceImage(piece);
		if(image!=null) label.setIcon(image);
	}
	
	/**
	 * Selects the current tile changing the background color of the button to selectedPieceButtonColor
	 */
	public void selectPiece(){
		button.setBackground(selectedPieceButtonColor);
	}
	
	/**
	 * Deselects the current tile changing the background color of the button to 
	 * deselectedButtonColorWhite or deselectedButtonColorBlack depending on original color of the tile
	 */
	public void deselectTile(){
		if(tileColor==Constants.whiteColor){
			button.setBackground(deselectedButtonColorWhite);
		}
		else{
			button.setBackground(deselectedButtonColorBlack);
		}
	}
	
	/**
	 * Select the current tile changing the background color of the button to selectedButtonColor
	 */
	public void selectTile(){
		button.setBackground(selectedButtonColor);
	}

	/**
	 * Creates and scales the ImageIcon of the passed piece
	 */
	private ImageIcon getPieceImage(ChessPiece piece){
		ImageIcon imageIcon = null;
		if(piece!=null){
			imageIcon = new ImageIcon(piece.getImagePath());
			Image image = imageIcon.getImage();
			image = image.getScaledInstance(chessPieceImageSizeX, chessPieceImageSizeY,  java.awt.Image.SCALE_SMOOTH); 
			imageIcon = new ImageIcon(image);
		}
		
		return imageIcon;
	}

}
