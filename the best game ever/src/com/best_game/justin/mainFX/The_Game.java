package com.best_game.justin.mainFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class The_Game extends Application {
	
	public static Stage WINDOW;
	public static Group ROOT;
	public static Scene SCENE;
	
	private static String IMAGEURL;
    private static Image IMAGE;
    private static ImageView IMAGEVIEW;
    
    private static String IMAGEURL2;
    private static Image IMAGE2;
    private static ImageView IMAGEVIEW2;
    
    private static String IMAGEURL3;
    private static Image IMAGE3;
    private static ImageView IMAGEVIEW3;
    
    private static MediaView MEDIAVIEW; 
    
    int t = 0;
    
    MediaPlayer mediaplayer;
    Rectangle borderedge = new Rectangle(0,0,1280,720);
    
    
    int start = 0;
    boolean timer = false;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
		ROOT = new Group();
		SCENE = new Scene(ROOT,1280,720,Color.BLACK);
		WINDOW = primaryStage;
		WINDOW.setScene(SCENE);
		WINDOW.show();
		
		Media musicFile = new Media("file:///C:/Users/justi/eclipse-workspace/the%20best%20game%20ever/src/com/best_game/justin/mainFX/ChickenSong-GecoRemix.mp3");
		
		borderedge.setFill(Color.DIMGRAY);
		
		mediaplayer = new MediaPlayer(musicFile);
		mediaplayer.setVolume(0.5);
		mediaplayer.setCycleCount(10);
		
		
		IMAGEURL = "start screen.png";
        IMAGE = new Image(The_Game.class.getResource(IMAGEURL).toExternalForm());
        IMAGEVIEW = new ImageView(IMAGE);
        IMAGEVIEW.setX(0);
        IMAGEVIEW.setY(0);
        IMAGEVIEW.setFitWidth(1280);
        IMAGEVIEW.setFitHeight(720);
        
        IMAGEURL2 = "chicken.jpg";
        IMAGE2 = new Image(The_Game.class.getResource(IMAGEURL2).toExternalForm());
        IMAGEVIEW2 = new ImageView(IMAGE2);
        IMAGEVIEW2.setX(345);
        IMAGEVIEW2.setY(180);
        IMAGEVIEW2.setFitWidth(640);
        IMAGEVIEW2.setFitHeight(360);
        
        IMAGEURL3 = "game visual.png";
        IMAGE3 = new Image(The_Game.class.getResource(IMAGEURL3).toExternalForm());
        IMAGEVIEW3 = new ImageView(IMAGE3);
        IMAGEVIEW3.setX(400);
        IMAGEVIEW3.setY(0);
        IMAGEVIEW3.setFitWidth(345);
        IMAGEVIEW3.setFitHeight(180);
        
        MEDIAVIEW = new MediaView(mediaplayer);
        
        if (t == 500) {
        	t = 0;
        	IMAGEURL2 = "chicken2.png";
        	ROOT.getChildren().add(IMAGEVIEW2);
        }
                
        ROOT.getChildren().add(IMAGEVIEW);
        
        SCENE.setOnKeyReleased(new EventHandler<KeyEvent>() {
        
        public void handle(KeyEvent event) {
			if(event.getCode() == KeyCode.ENTER) {
				if(start == 0) {
					ROOT.getChildren().remove(IMAGEVIEW);
					ROOT.getChildren().addAll(borderedge, IMAGEVIEW3, IMAGEVIEW2,MEDIAVIEW);
					mediaplayer.play();
					start = 1;
				}
			}
        }
	});
}}