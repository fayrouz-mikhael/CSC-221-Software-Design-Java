package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			Scene scene = new Scene(root,1000,1000 ,Color.WHITESMOKE);
			Canvas canvas = new Canvas(1000, 500);
	        canvas.setLayoutX(0);
	        canvas.setLayoutY(0);
	        GraphicsContext gc = canvas.getGraphicsContext2D();
	        
	        root.getChildren().addAll(canvas);
	        
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Shape 2");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	        
	          
            Geometric_Figure_2.drawShape2(gc); // Draw the Geometric shape of the circles, polygons and the line

	        
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
