package controllers;

import game.Game;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import pieces.*;

import java.util.ArrayList;
import java.util.Objects;

public class BoardController {
	private Image blackPawn = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/blackPawn.png")));
	private Image blackKing = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/blackKing.png")));
	private Image blackQueen = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/blackQueen.png")));
	private Image blackRook = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/blackRook.png")));
	private Image blackKnight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/blackKnight.png")));
	private Image blackBishop = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/blackBishop.png")));
	private Image whitePawn = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/whitePawn.png")));
	private Image whiteKing = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/whiteKing.png")));
	private Image whiteQueen = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/whiteQueen.png")));
	private Image whiteRook = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/whiteRook.png")));
	private Image whiteKnight = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/whiteKnight.png")));
	private Image whiteBishop = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/whiteBishop.png")));
	ArrayList<ImageView> squareList = new ArrayList<>();

	@FXML
	private Text lastMoveText;
	@FXML
	private Text evalText;
	@FXML
	private GridPane squares;
	@FXML
	private GridPane grid;
	@FXML
	private Text selectedPosText;
	@FXML
	private Text possibleMovesText;
	@FXML
    public void initialize() {
		for(int i = 0; i < 64; i++) {
			squareList.add(new ImageView());
			squareList.get(i).setFitWidth(100);
			squareList.get(i).setFitWidth(100);
		}
        paint();
    }
	private void paint() {
	}
	public BoardController(Game game) {
	}
	public void onMousePressed(MouseEvent e) {

	}
	public void paintPossibleMoves(ArrayList<Integer> moves, int selectedPos) {

	}
}
