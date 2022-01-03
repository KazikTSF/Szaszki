package application;
	
import game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application 
{
	Game game = new Game("rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6");
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
//			Parent root = FXMLLoader.load(getClass().getResource("/board.fxml"));
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add("/board.css");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/board.fxml"));
			BoardController con = new BoardController(game.getBoard().getBoard());
			loader.setController(con);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
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
