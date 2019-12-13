package com.obama.justin.mainFX;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Dialog extends Application{
	
	public static Stage WINDOW;
	public static Group ROOT;
	public static Scene SCENE;
	
    private static String IMAGEURL;
    private static Image IMAGE;
    private static ImageView IMAGEVIEW;
    
    TranslateTransition angery1;
    TranslateTransition angery2;
    TranslateTransition angery3;
    TranslateTransition angery4;
	FillTransition ft;
	FillTransition ftA;
	
	Rectangle dialogBG = new Rectangle(10,400,1260,310);
	Text txt = new Text();
	int j =0;
	int e = 0;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ROOT = new Group();
		SCENE = new Scene(ROOT,1280,720,Color.BLACK);
		WINDOW = primaryStage;
		WINDOW.setScene(SCENE);
		WINDOW.show();
		
		dialogBG.setFill(Color.WHITE);
		dialogBG.setOpacity(1);
		
		txt.setX(20);
		txt.setY(680);
		txt.setFont(Font.font(50));
		
        IMAGEURL = "obama_prism_normal.png";
        IMAGE = new Image(Dialog.class.getResource(IMAGEURL).toExternalForm());
        IMAGEVIEW = new ImageView(IMAGE);
        IMAGEVIEW.setX(1070);
        IMAGEVIEW.setY(510);
        IMAGEVIEW.setFitWidth(200);
        IMAGEVIEW.setFitHeight(200);
		
		ft = new FillTransition(Duration.millis(5000), dialogBG, Color.WHITE, Color.GREENYELLOW);
		ft.setCycleCount(Animation.INDEFINITE);
		ft.setAutoReverse(true);
		
		ftA = new FillTransition(Duration.millis(50), dialogBG, Color.DARKRED, Color.RED);
		ftA.setCycleCount(40);
		ftA.setAutoReverse(true);
		
		angery1 = new TranslateTransition(Duration.millis(100), dialogBG);
		angery1.setFromX(5);
		angery1.setToX(15);
		angery1.setCycleCount(20);
        angery1.setAutoReverse(true);
        
        angery2 = new TranslateTransition(Duration.millis(50), dialogBG);
		angery2.setFromY(5);
		angery2.setToY(15);
		angery2.setCycleCount(40);
        angery2.setAutoReverse(true);
        
        angery3 = new TranslateTransition(Duration.millis(100), txt);
		angery3.setFromX(5);
		angery3.setToX(35);
		angery3.setCycleCount(20);
        angery3.setAutoReverse(true);
        
        angery4 = new TranslateTransition(Duration.millis(50), txt);
		angery4.setFromY(5);
		angery4.setToY(35);
		angery4.setCycleCount(40);
        angery4.setAutoReverse(true);
		
		SCENE.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					if(j == 0) {
						ROOT.getChildren().add(dialogBG);
						ROOT.getChildren().add(txt);
						ft.play();
						txt.setText("from my rechearch");
						ROOT.getChildren().add(IMAGEVIEW);
						j++;
					} else if (j == 1) {
						txt.setText("i have concluded that you");
						j++;
					}
					else if (j == 2) {
						txt.setText("are the enemy of my people");
						j++;
					}  
					else if (j == 3){
						txt.setText("prepare to die");
						j++;
						ft.stop();
						ftA.play();
						angery1.play();
						angery2.play();
						angery3.play();
						angery4.play();
					}
					else {
						txt.setText("");
						WINDOW.close();
					}
				}
				if(event.getCode() == KeyCode.E) {
					if(e == 0){
						ftA.stop();
						ft.play();
						e = 1;
					}
					else if(e == 1){
						angery1.play();
						angery2.play();
						angery3.play();
						angery4.play();
						ft.stop();
						ftA.play();
						e = 0;
					}
					
				}
			}
		});
	}
}
