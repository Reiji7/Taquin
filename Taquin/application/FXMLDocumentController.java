/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Controller_Game;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.game.Model_Board;
import model.game.Model_Player;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;

public class FXMLDocumentController implements Initializable {
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
    
    int SIZE = Controller_Game.SIZE;	//récupèe la taille de la grille
    int cpt = 0;	//compte le nombre de mouvements effectués par le joueur 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	//TODO
    	System.out.println("le controleur initialise la vue");
    	
    	/*for(int i = SIZE; i > 3; i++) {
    		for(int j = SIZE; j > 3; j++) {
    			Label label = new Label();
    		    GridPane.setConstraints(label, i, j);	
    		    grid.getChildren().addAll();
    		}
    	}
    	
    	for(int i = 0; i <= SIZE; i++) {
    		for(int j = 0; j <= SIZE; j++) {
    			getNodeByRowColumnIndex(i, j, grid).getChildren().setText(Model_Board.board[i + j]);
    		}
    	}
    	
    	//player_name.setText("Test");
    	*/
    	moves_nb.setText(cptToString());
    	//player_name.setText(Model_Player.name);
    	
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
    	String str = Integer.toString(cpt);
    	return str;
    }
    
}
