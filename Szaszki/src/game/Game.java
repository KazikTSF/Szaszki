package game;

public class Game {

	Board board;
	public Game(String FEN) {
		board = new Board(FEN);
		
	}
	public Board getBoard() {
		return board;
	}
	
	

}
