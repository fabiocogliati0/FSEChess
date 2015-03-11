package view;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Constants;
import model.ChessPieces.ChessPiece;

public class ChessBoardTile extends JPanel{

	private final static Color deselectedButtonColorWhite = new Color(1.0f, 1.0f, 1.0f);
	private final static Color deselectedButtonColorBlack = new Color(0.0f, 0.0f, 0.0f);
	private final static Color selectedButtonColor = new Color(0.0f, 0.0f, 1.0f);
	
	private final static int chessPieceImageSizeX = 60;
	private final static int chessPieceImageSizeY = 60;
	
	private final boolean tileColor;
	
	private JLabel label;
	private final JButton button;
	
	public ChessBoardTile(int x, int y, boolean tileColor, JButton button){
		this(x,y,tileColor,button, null);
	}

	public ChessBoardTile(int x, int y, boolean tileColor, JButton button, ChessPiece chessPiece){
		this.button = button;
		this.label = new JLabel();
		this.tileColor = tileColor;
		
		setPiece(chessPiece);
		
		add(button);
		add(label);
		
		deselectPiece();
	}
	
	public void setPiece(ChessPiece piece){
		label.setIcon(null);
		ImageIcon image = getPieceImage(piece);
		if(image!=null) label.setIcon(image);
	}
	
	public void selectPiece(){
		button.setBackground(selectedButtonColor);
	}
	
	public void deselectPiece(){
		if(tileColor==Constants.whiteColor){
			button.setBackground(deselectedButtonColorWhite);
		}
		else{
			button.setBackground(deselectedButtonColorBlack);
		}
	}
	
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
