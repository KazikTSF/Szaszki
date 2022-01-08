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
	private final Game GAME;
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
		GAME.getBoard().update();
        paint();
    }
	private void paint() {
		squares.getChildren().removeAll(squares.getChildren());
		for(int i = 0; i < 64; i++) {
			squareList.get(i).setFitHeight(100);
			squareList.get(i).setFitWidth(100);
			int col = i%8;
			int row = i/8;
        	if(GAME.getBoard().getBoard()[i] == null)
        		continue;
        	if(GAME.getBoard().getBoard()[i] instanceof Pawn) {
        		if(GAME.getBoard().getBoard()[i].isWhite())
        			squareList.get(i).setImage(whitePawn);
        		else
        			squareList.get(i).setImage(blackPawn);
        	}
        	else if(GAME.getBoard().getBoard()[i] instanceof Rook) {
        		if(GAME.getBoard().getBoard()[i].isWhite())
        			squareList.get(i).setImage(whiteRook);
        		else
        			squareList.get(i).setImage(blackRook);
        	}
        	else if(GAME.getBoard().getBoard()[i] instanceof Bishop) {
        		if(GAME.getBoard().getBoard()[i].isWhite())
        			squareList.get(i).setImage(whiteBishop);
        		else
        			squareList.get(i).setImage(blackBishop);
        	}
        	else if(GAME.getBoard().getBoard()[i] instanceof Knight) {
        		if(GAME.getBoard().getBoard()[i].isWhite())
        			squareList.get(i).setImage(whiteKnight);
        		else
        			squareList.get(i).setImage(blackKnight);
        	}
        	else if(GAME.getBoard().getBoard()[i] instanceof Queen) {
        		if(GAME.getBoard().getBoard()[i].isWhite())
        			squareList.get(i).setImage(whiteQueen);
        		else
        			squareList.get(i).setImage(blackQueen);
        	}
        	else if(GAME.getBoard().getBoard()[i] instanceof King) {
        		if(GAME.getBoard().getBoard()[i].isWhite())
        			squareList.get(i).setImage(whiteKing);
        		else
        			squareList.get(i).setImage(blackKing);
        	}
			else
				squareList.get(i).setImage(null);
			squares.add(squareList.get(i), col, row);
        }
	}
	public BoardController(Game game) {
		this.GAME = game;
	}
	public void onMousePressed(MouseEvent e) {
		int col = (int) (e.getX() / 100);
		int row = (int) (e.getY() / 100);
		paint();
		if (GAME.moveInput(row, col)) {
			grid.getChildren().removeAll(grid.getChildren());
			paint();
		}
		if(GAME.getBoard().getBoard()[8*row+col] != null && GAME.getSelected() != null) {
			paintPossibleMoves(GAME.getBoard().getBoard()[8 * row + col].getPossibleMoves(), 8 * row + col);
		}
		if(GAME.getBoard().getLastMove() != null)
			lastMoveText.setText("Last move: " + GAME.getBoard().getLastMove().toString());
	}
	public void paintPossibleMoves(ArrayList<Integer> moves, int selectedPos) {
		for(int move : moves) {
			move = move+selectedPos;
			int col = move%8;
			int row = move/8;
			Pane pane = new Pane();
			pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			grid.add(pane, col, row);
		}
	}
}
