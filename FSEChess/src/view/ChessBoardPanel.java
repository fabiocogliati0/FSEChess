/**
 * Fabio Cogliati
 * Progetto di Fundamentals of software engineering
 */

package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Constants;
import model.Model;
import controller.Controller;

public class ChessBoardPanel extends JPanel implements View{
	
	private final int TilesSizeX = 8;
	private final int TilesSizeY = 8;
	
	private final JFrame frame;
	private final Model model;
	private Controller controller;
	
	private ChessBoardTile[][] tiles = new ChessBoardTile[TilesSizeX][TilesSizeY];
	
	//-------------------------------Public methods-------------------------------------------
	
 	public ChessBoardPanel(Model model, JFrame frame){
 		this.model = model;
		this.frame = frame;
		createTiles();
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
				tiles[x][y].setPiece(model.at(x, y));
			}
		}
	}
	
	public void selectPiece(int x, int y){
		tiles[x][y].selectPiece();
	}
	
	public void deselectPiece(int x, int y){
		tiles[x][y].deselectPiece();
	}
	
	//-------------------------------Private methods-------------------------------------------

	private void createTiles(){
		
		setLayout(new GridLayout(TilesSizeX,TilesSizeY));
		
		for(int x = 0; x<TilesSizeX; x++){
			for(int y = 0; y<TilesSizeY; y++){
				boolean tileColor;
				if((x+y) % 2 == 0){
					tileColor = Constants.whiteColor;
				}
				else{
					tileColor = Constants.blackColor;	
				}
				tiles[x][y] = new ChessBoardTile(x, y, tileColor, makeButton(x,y),model.at(x,y));
				add(tiles[x][y]);
			
			}
		}
	}
	
	private JButton makeButton(int x, int y){
		JButton button = new JButton();
		button.addActionListener(event -> {
			if(controller != null){
				controller.onClick(x, y);
			}
		});
		
		return button;
	}
	
}
