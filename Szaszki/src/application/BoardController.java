package application;

import java.util.ArrayList;

import game.Board;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class BoardController {
	private Board board;
	private Image blackPawn = new Image(getClass().getResourceAsStream("/images/blackPawn.png"));
	private Image blackKing = new Image(getClass().getResourceAsStream("/images/blackKing.png"));
	private Image blackQueen = new Image(getClass().getResourceAsStream("/images/blackQueen.png"));
	private Image blackRook = new Image(getClass().getResourceAsStream("/images/blackRook.png"));
	private Image blackKnight = new Image(getClass().getResourceAsStream("/images/blackKnight.png"));
	private Image blackBishop = new Image(getClass().getResourceAsStream("/images/blackBishop.png"));
	private Image whitePawn = new Image(getClass().getResourceAsStream("/images/whitePawn.png"));
	private Image whiteKing = new Image(getClass().getResourceAsStream("/images/whiteKing.png"));
	private Image whiteQueen = new Image(getClass().getResourceAsStream("/images/whiteQueen.png"));
	private Image whiteRook = new Image(getClass().getResourceAsStream("/images/whiteRook.png"));
	private Image whiteKnight = new Image(getClass().getResourceAsStream("/images/whiteKnight.png"));
	private Image whiteBishop = new Image(getClass().getResourceAsStream("/images/whiteBishop.png"));
	ArrayList<ImageView> list = new ArrayList<ImageView>();
	Piece selected = null;
	int selectedPos = -1;
	
	@FXML
	private ImageView square0;
	@FXML
	private ImageView square1;
	@FXML
	private ImageView square2;
	@FXML
	private ImageView square3;
	@FXML
	private ImageView square4;
	@FXML
	private ImageView square5;
	@FXML
	private ImageView square6;
	@FXML 
	private ImageView square7;
	@FXML
	private ImageView square8;
	@FXML
	private ImageView square9;
	@FXML
	private ImageView square10;
	@FXML
	private ImageView square11;
	@FXML
	private ImageView square12;
	@FXML
	private ImageView square13;
	@FXML
	private ImageView square14;
	@FXML
	private ImageView square15;
	@FXML
	private ImageView square16;
	@FXML
	private ImageView square17;
	@FXML
	private ImageView square18;
	@FXML
	private ImageView square19;
	@FXML
	private ImageView square20;
	@FXML
	private ImageView square21;
	@FXML
	private ImageView square22;
	@FXML
	private ImageView square23;
	@FXML
	private ImageView square24;
	@FXML
	private ImageView square25;
	@FXML
	private ImageView square26;
	@FXML
	private ImageView square27;
	@FXML
	private ImageView square28;
	@FXML
	private ImageView square29;
	@FXML
	private ImageView square30;
	@FXML
	private ImageView square31;
	@FXML
	private ImageView square32;
	@FXML
	private ImageView square33;
	@FXML
	private ImageView square34;
	@FXML
	private ImageView square35;
	@FXML
	private ImageView square36;
	@FXML
	private ImageView square37;
	@FXML
	private ImageView square38;
	@FXML
	private ImageView square39;
	@FXML
	private ImageView square40;
	@FXML
	private ImageView square41;
	@FXML
	private ImageView square42;
	@FXML
	private ImageView square43;
	@FXML
	private ImageView square44;
	@FXML
	private ImageView square45;
	@FXML
	private ImageView square46;
	@FXML
	private ImageView square47;
	@FXML
	private ImageView square48;
	@FXML
	private ImageView square49;
	@FXML
	private ImageView square50;
	@FXML
	private ImageView square51;
	@FXML
	private ImageView square52;
	@FXML
	private ImageView square53;
	@FXML
	private ImageView square54;
	@FXML
	private ImageView square55;
	@FXML
	private ImageView square56;
	@FXML
	private ImageView square57;
	@FXML
	private ImageView square58;
	@FXML
	private ImageView square59;
	@FXML
	private ImageView square60;
	@FXML
	private ImageView square61;
	@FXML
	private ImageView square62;
	@FXML
	private ImageView square63;

	@FXML
    public void initialize() {
		fillArr();
        paint();
    }
	private void paint() {
		for(int i = 0; i < list.size(); i++) 
			list.get(i).setImage(null);
		for(int i = 0; i < board.getBoard().length; i++) {
        	list.get(i).setFitHeight(96);
    		list.get(i).setFitWidth(96);
        	if(board.getBoard()[i] == null)
        		continue;
        	if(board.getBoard()[i] instanceof Pawn) {
        		if(board.getBoard()[i].isWhite())
        			list.get(i).setImage(whitePawn);
        		else
        			list.get(i).setImage(blackPawn);
        	}
        	else if(board.getBoard()[i] instanceof Rook) {
        		if(board.getBoard()[i].isWhite())
        			list.get(i).setImage(whiteRook);
        		else
        			list.get(i).setImage(blackRook);
        	}
        	else if(board.getBoard()[i] instanceof Bishop) {
        		if(board.getBoard()[i].isWhite())
        			list.get(i).setImage(whiteBishop);
        		else
        			list.get(i).setImage(blackBishop);
        	}
        	else if(board.getBoard()[i] instanceof Knight) {
        		if(board.getBoard()[i].isWhite())
        			list.get(i).setImage(whiteKnight);
        		else
        			list.get(i).setImage(blackKnight);
        	}
        	else if(board.getBoard()[i] instanceof Queen) {
        		if(board.getBoard()[i].isWhite())
        			list.get(i).setImage(whiteQueen);
        		else
        			list.get(i).setImage(blackQueen);
        	}
        	else if(board.getBoard()[i] instanceof King) {
        		if(board.getBoard()[i].isWhite())
        			list.get(i).setImage(whiteKing);
        		else
        			list.get(i).setImage(blackKing);
        	}
        }
	}
	public BoardController(Board board) {
		this.board = board;
	}
	private void fillArr()
	{
		list.add(square0);
		list.add(square1);
		list.add(square2);
		list.add(square3);
		list.add(square4);
		list.add(square5);
		list.add(square6);
		list.add(square7);
		list.add(square8);
		list.add(square9);
		list.add(square10);
		list.add(square11);
		list.add(square12);
		list.add(square13);
		list.add(square14);
		list.add(square15);
		list.add(square16);
		list.add(square17);
		list.add(square18);
		list.add(square19);
		list.add(square20);
		list.add(square21);
		list.add(square22);
		list.add(square23);
		list.add(square24);
		list.add(square25);
		list.add(square26);
		list.add(square27);
		list.add(square28);
		list.add(square29);
		list.add(square30);
		list.add(square31);
		list.add(square32);
		list.add(square33);
		list.add(square34);
		list.add(square35);
		list.add(square36);
		list.add(square37);
		list.add(square38);
		list.add(square39);
		list.add(square40);
		list.add(square41);
		list.add(square42);
		list.add(square43);
		list.add(square44);
		list.add(square45);
		list.add(square46);
		list.add(square47);
		list.add(square48);
		list.add(square49);
		list.add(square50);
		list.add(square51);
		list.add(square52);
		list.add(square53);
		list.add(square54);
		list.add(square55);
		list.add(square56);
		list.add(square57);
		list.add(square58);
		list.add(square59);
		list.add(square60);
		list.add(square61);
		list.add(square62);
		list.add(square63);
	}
	public void onMousePressed(MouseEvent e) {
		int col = (int) (e.getX()/100);
		int row = (int) (e.getY()/100);
		if(selected == null) {
			selectedPos = 8*row+col;
			if(board.getBoard()[selectedPos] == null) 
				return;
			if((board.isWhiteMove() && board.getBoard()[selectedPos].isWhite()) || (!board.isWhiteMove() && !board.getBoard()[selectedPos].isWhite()))
				selected = board.getBoard()[selectedPos];	
		}
		else {
			int move = (8*row+col)-selected.getPos();
			ArrayList<Integer> moves = new ArrayList<Integer>();
			moves.addAll(board.getBoard()[selectedPos].listPossibleMoves(board.getBoard()));
			for(int i = 0; i < moves.size(); i++) {
				if(moves.get(i) == move) {
					board.move(selected, move);
				}
			}
			selected = null;
			paint();
		}
	}
}
