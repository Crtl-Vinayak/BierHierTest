package com.obama.justin.mainFX;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application{

	public static Stage WINDOW;
	public static Group ROOT;
	public static Scene SCENE;
	
	Line line = new Line();
	int j = 0;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ROOT = new Group();
		SCENE = new Scene(ROOT,1280,720,Color.AQUA);
		WINDOW = primaryStage;
		WINDOW.setScene(SCENE);
		WINDOW.show();
		WINDOW.setTitle("still sea watching simulator");

		line.setStartX(150.0f); 
		line.setStartY(140.0f);         
		line.setEndX(450.0f); 
		line.setEndY(140.0f);
		line.setFill(Color.RED);

		ROOT.getChildren().add(line);
		
		
		
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				//line.setStartX(j++);
			}
			
		}.start();
	}
}
