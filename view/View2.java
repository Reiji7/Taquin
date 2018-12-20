/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import controller.Controller_Game;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.game.Model_Board;
import model.game.Model_Player;



public class View2 implements Initializable, Observer {
    /*
     * 
     */
    @FXML
    private Label text1; 
    @FXML
    private Label text2;
    @FXML
    private Label text3;
    @FXML
    private Label player_name;
    @FXML
    private Label moves_nb;
    @FXML
    private Label timer;
    @FXML
    private AnchorPane background;
    @FXML
    private GridPane grid;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	//TODO
    	System.out.println("le controleur initialise la vue");
    	
    	/*for(int i = Controller_Game.SIZE; i > 3; i++) {
    		for(int j = Controller_Game.SIZE; j > 3; j++) {
    			Label label = new Label();
    		    GridPane.setConstraints(label, i, j);	
    		    grid.getChildren().addAll();
    		}
    	}
    	
    	for(int i = 0; i <= Controller_Game.SIZE; i++) {
    		for(int j = 0; j <= Controller_Game.SIZE; j++) {
    			getNodeByRowColumnIndex(i, j, grid).getChildren().setText(Model_Board.board[i][j].toString());
    		}
    	}
    	
    	//player_name.setText("Test");
    	*/
    	moves_nb.setText(cptToString());
    	player_name.setText(Model_Player.name);
    	
    }
  
    @FXML
    public void keyPressed(KeyEvent ke) {
        String key = ke.getText();
        System.out.println("key pressed" + key);
    }
    
    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }
    
    public String cptToString() {
    	String str = Integer.toString(0);
    	return str;
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
    
}
