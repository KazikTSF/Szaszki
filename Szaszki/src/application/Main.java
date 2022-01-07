package application;
	
import game.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.util.Objects;


public class Main extends Application 
{
	Game game = new Game("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq -");
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/game/board.fxml"));
			BoardController con = new BoardController(game.getBoard());
			loader.setController(con);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Szaszki");
			primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/blackKing.png"))));
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
