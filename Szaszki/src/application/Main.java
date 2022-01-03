package application;
	
import game.Game;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application 
{
	GridPane root = new GridPane();
    final int size = 8;
    
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			for(int row = 0; row < 8; row++)
			{
				for(int column = 0; column < 8; column++)
				{
					Rectangle square = new Rectangle();
					Color color;
					if((column+row)%2 == 0)
						color = Color.rgb(124, 90, 82);
					else
						color = Color.BLACK;
					square.setFill(color);
					root.add(square, column, row);
					square.widthProperty().bind(root.widthProperty().divide(size));
	                square.heightProperty().bind(root.heightProperty().divide(size));
				}
			}
			primaryStage.setScene(new Scene(root, 400, 400));
			primaryStage.show();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		Game game = new Game("rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6");
		launch(args);
	}
}
