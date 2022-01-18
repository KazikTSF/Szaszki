package controllers;

import game.BitBoards;
import game.Game;
import game.Move;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import pieces.MoveGenerator;
import pieces.Piece;
import pieces.PieceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	ArrayList<ImageView> squareList = new ArrayList<>(64);
	HashMap<String, Long> board;

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
		for(int i = 0; i < 64; i++)
			squareList.add(new ImageView());
        paint();
    }
	private void paint() {
		squares.getChildren().removeAll();
		Piece[] paintBoard = bitBoardToArray();
		for(int i = 7; i > -1; i--) {
			for(int j = 0; j < 8; j++) {
				if(paintBoard[i * 8 + j] == null) {
					squareList.get(i * 8 + j).setImage(null);
					continue;
				}
				if(paintBoard[i * 8 + j].isIS_WHITE()) {
					switch (paintBoard[i * 8 + j].getTYPE()) {
						case KING -> squareList.get(i*8+j).setImage(whiteKing);
						case QUEEN -> squareList.get(i*8+j).setImage(whiteQueen);
						case BISHOP -> squareList.get(i*8+j).setImage(whiteBishop);
						case KNIGHT -> squareList.get(i*8+j).setImage(whiteKnight);
						case ROOK -> squareList.get(i*8+j).setImage(whiteRook);
						case PAWN -> squareList.get(i*8+j).setImage(whitePawn);
					}
				}
				else {
					switch (paintBoard[i * 8 + j].getTYPE()) {
						case KING -> squareList.get(i*8+j).setImage(blackKing);
						case QUEEN -> squareList.get(i*8+j).setImage(blackQueen);
						case BISHOP -> squareList.get(i*8+j).setImage(blackBishop);
						case KNIGHT -> squareList.get(i*8+j).setImage(blackKnight);
						case ROOK -> squareList.get(i*8+j).setImage(blackRook);
						case PAWN -> squareList.get(i*8+j).setImage(blackPawn);
					}
				}
			}
		}
		for(int i = 0; i < 64; i++) {
			int col = i%8;
			int row = 7-i/8;
			squareList.get(i).setFitWidth(100);
			squareList.get(i).setFitHeight(100);
			squares.add(squareList.get(i), col, row);
		}
	}
	public BoardController(Game game) {
		board = game.getBoard();
		long w = 0;
		long b = 0;
		w = w | board.get("wP");
		w = w | board.get("wR");
		w = w | board.get("wN");
		w = w | board.get("wB");
		w = w | board.get("wQ");
		w = w | board.get("wK");
		b = b | board.get("bP");
		b = b | board.get("bR");
		b = b | board.get("bN");
		b = b | board.get("bB");
		b = b | board.get("bQ");
		b = b | board.get("bK");
		MoveGenerator moveGenerator = new MoveGenerator();
		moveGenerator.pawnsMoves(board.get("wP"), w, b, true);
	}
	public void onMousePressed(MouseEvent e) {

	}
	private void paintPossibleMoves(ArrayList<Integer> moves, int selectedPos) {

	}
	private Piece[] bitBoardToArray() {
		Piece[] res = new Piece[64];
		Arrays.fill(res, null);
		ArrayList<ArrayList<Integer>> positions = new ArrayList<>();
		positions.add(findPos(board.get("wP")));
		positions.add(findPos(board.get("wR")));
		positions.add(findPos(board.get("wN")));
		positions.add(findPos(board.get("wB")));
		positions.add(findPos(board.get("wQ")));
		positions.add(findPos(board.get("wK")));
		positions.add(findPos(board.get("bP")));
		positions.add(findPos(board.get("bR")));
		positions.add(findPos(board.get("bN")));
		positions.add(findPos(board.get("bB")));
		positions.add(findPos(board.get("bQ")));
		positions.add(findPos(board.get("bK")));
		for(int i = 0; i < 12; i++) {
			for(int pos : positions.get(i)) {
				long temp = Long.MIN_VALUE;
				long BBPos = temp >>> pos;
				switch (i) {
					case 0 -> res[pos] = new Piece(BBPos, PieceType.PAWN, true);
					case 1 -> res[pos] = new Piece(BBPos, PieceType.ROOK, true);
					case 2 -> res[pos] = new Piece(BBPos, PieceType.KNIGHT, true);
					case 3 -> res[pos] = new Piece(BBPos, PieceType.BISHOP, true);
					case 4 -> res[pos] = new Piece(BBPos, PieceType.QUEEN, true);
					case 5 -> res[pos] = new Piece(BBPos, PieceType.KING, true);
					case 6 -> res[pos] = new Piece(BBPos, PieceType.PAWN, false);
					case 7 -> res[pos] = new Piece(BBPos, PieceType.ROOK, false);
					case 8 -> res[pos] = new Piece(BBPos, PieceType.KNIGHT, false);
					case 9 -> res[pos] = new Piece(BBPos, PieceType.BISHOP, false);
					case 10 -> res[pos] = new Piece(BBPos, PieceType.QUEEN, false);
					case 11 -> res[pos] = new Piece(BBPos, PieceType.KING, false);
				}
			}
		}
		return res;
	}
	private ArrayList<Integer> findPos(long l) {
		ArrayList<Integer> res = new ArrayList<>();
		char[] bin = BitBoards.bitBoardToString(l).toCharArray();
		for(int i = 0; i < bin.length; i++) {
			if(bin[i] == '1')
				res.add(i);
		}
		return res;
	}
}
