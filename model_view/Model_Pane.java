package model_view;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import resources.Position;

public class Model_Pane {
	
	private static AnchorPane anchorpane;
	
	
	public Model_Pane() {
		anchorpane = new AnchorPane();
	}
	
	
	public void add(Node component, Position position){
		anchorpane.getChildren().add(component);
		AnchorPane.setTopAnchor(component, (double)position.x);
		AnchorPane.setLeftAnchor(component, (double)position.y); 
	}
	
	
	public AnchorPane getContent(){
		return anchorpane;
	}
}
