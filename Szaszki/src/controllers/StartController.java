package controllers;

import game.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private TextField FENText;
    @FXML
    private MenuButton styleMenu;
    @FXML
    private CheckBox isWhiteBox;
    @FXML
    private CheckBox twoPlayerBox;

    public void start(ActionEvent e) throws IOException {
        Game game = new Game(FENText.getText());
        if(!isWhiteBox.isSelected())
            throw new UnsupportedOperationException("PLAYING BLACK IS NOT SUPPORTED YET");
        if(twoPlayerBox.isSelected())
            throw new UnsupportedOperationException("PLAYING ALONE IS NOT SUPPORTED YET");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/board.fxml"));
        BoardController con = new BoardController(game);
        loader.setController(con);
        Parent root = loader.load();
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
