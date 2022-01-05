package application;
	
import game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pieces.SlideMove;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application 
{
	Game game = new Game("1k1r4/pp1b1R2/3q2pp/4p3/2B5/4Q3/PPP2B2/2K5 b - -");
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/board.fxml"));
			BoardController con = new BoardController(game.getBoard());
			loader.setController(con);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Szaszki");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/blackKing.png")));
			primaryStage.show();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
