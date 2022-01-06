package game;

public class Game {

	Board board;
	public Game(String FEN) {
		board = new Board(FEN);
		
	}
	public Board getBoard() {
		return board;
	}
	public static String convertFromPos(int pos) {
		String s = "";
		int col = pos%8;
		int row = 8-pos/8;
		switch (col) {
			case 0:
				s+="a";
				break;
			case 1:
				s+="b";
				break;
			case 2:
				s+="c";
				break;
			case 3:
				s+="d";
				break;
			case 4:
				s+="e";
				break;
			case 5:
				s+="f";
				break;
			case 6:
				s+="g";
				break;
			case 7:
				s+="h";
				break;
		}
		s+=row;
		return s;
	}
	

}
