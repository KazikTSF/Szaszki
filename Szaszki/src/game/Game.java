package game;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Game {

	Board board;
	public Game(String FEN) {
		board = new Board(FEN);
		
	}
	

}
