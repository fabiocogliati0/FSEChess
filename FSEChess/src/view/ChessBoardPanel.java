/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import model.Model;
import model.ChessPieces.ChessPiece;
import controller.Controller;

public class ChessBoardPanel extends JPanel implements View{
	
	private final int TilesSizeX = 8;
	private final int TilesSizeY = 8;
	
	private final Color deselectedButtonColorWhite = new Color(1.0f, 1.0f, 1.0f);
	private final Color deselectedButtonColorBlack = new Color(0.0f, 0.0f, 0.0f);
	private final Color selectedButtonColor = new Color(0.0f, 0.0f, 1.0f);
	
	private final JFrame frame;
	private final Model model;
	private Controller controller;
	
	private final JButton[][] buttons = new JButton[TilesSizeX][TilesSizeY];
	
	//-------------------------------Public methods-------------------------------------------
	
 	public ChessBoardPanel(Model model, JFrame frame){
 		
 		this.model = model;
		this.frame = frame;
		createButtons();
		model.setView(this);
		
	}
	
	@Override
	public Model getModel() {
		return model;
	}

	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void showSolvedDialog() {
		//TODO
		//new SolvedDialog(frame, controller).setVisible(true);
	}

	@Override
	public void onConfigurationChange() {
		for(int y = 0; y<TilesSizeY; y++){
			for(int x = 0; x<TilesSizeX; x++){
				buttons[x][y].setText("");
			}
		}
	}
	
	public void selectPiece(int x, int y){
		buttons[x][y].setBackground(selectedButtonColor);
	}
	
	public void deselectPiece(int x, int y){
		if((x + y) % 2 == 0){
			buttons[x][y].setBackground(deselectedButtonColorWhite);
		}
		else{
			buttons[x][y].setBackground(deselectedButtonColorBlack);
		}
	}
	
	//-------------------------------Private methods-------------------------------------------

	private void createButtons(){
		setLayout(new GridLayout(TilesSizeX,TilesSizeY));
		
		for(int x = 0; x<TilesSizeX; x++){
			for(int y = 0; y<TilesSizeY; y++){
				buttons[x][y] = makeButton(x,y,model.at(x, y));
				deselectPiece(x,y);
				//add(buttons[x][y]);		
				
				//---prova
				JPanel casella = new JPanel();
				casella.setLayout(new OverlayLayout(casella));
				JLabel label = new JLabel();
				
				if(model.at(x, y) != null){
					
					ImageIcon imageIcon = new ImageIcon(model.at(x, y).getImagePath());
					Image image = imageIcon.getImage();
					image = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
					imageIcon = new ImageIcon(image);
					label = new JLabel(imageIcon);	
				}
				
				casella.add(label);
				casella.add(buttons[x][y]);
				add(casella);
				
				//--fine prova
				
			}
		}
	}
	
	private JButton makeButton(int x, int y, ChessPiece value){
		JButton button = new JButton("");
		button.addActionListener(event -> {
			if(controller != null){
				controller.onClick(x, y);
			}
		});
		
		return button;
	}
	
}
