package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pieces.Pawn;
import pieces.Piece;

public class BoardController {
	private Piece[] board;
	private Image blackPawn = new Image(getClass().getResourceAsStream("/images/blackPawn.png"));
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
        for(int i = 0; i < board.length; i++) {
        	if(board[i] == null)
        		continue;
        	//TODO
        		
        }
    }
	public BoardController(Piece[] board) {
		this.board = board;
	}
}
