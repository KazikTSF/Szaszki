package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Game
{
	private HashMap<String, Long> board = new HashMap<>();
	private int fiftyMoveRule = 0;
	private long enPassant;
	private boolean whiteMove;
	public Game(String fen) {
		board.put("wP", 0L);
		board.put("wR", 0L);
		board.put("wN", 0L);
		board.put("wB", 0L);
		board.put("wQ", 0L);
		board.put("wK", 0L);
		board.put("bP", 0L);
		board.put("bR", 0L);
		board.put("bN", 0L);
		board.put("bB", 0L);
		board.put("bQ", 0L);
		board.put("bK", 0L);
		convertFEN(fen);
	}

	private void convertFEN(String fen) {
		String[] sFEN = fen.split("\\s+");
		char c = sFEN[4].toCharArray()[0];
		fiftyMoveRule = (int)c-48;
		char[] temp;
		temp = sFEN[3].toCharArray();
		if(temp[0] == '-')
			enPassant = 0;
		else {
			int pos = ((int)temp[0]-97)+((int)temp[1]-48)*8;
			long tEnPassant = Long.MIN_VALUE;
			enPassant = tEnPassant >>> pos;
		}
		//TODO CASTLING

		temp = sFEN[1].toCharArray();
		whiteMove = (temp[0] == 'w');

		String[] tempPos = sFEN[0].split("/");
		int currentPos;
		for(int i = 7; i > -1; i--) {
			int col = 0;
			for(int j = 0; j < tempPos[i].length(); j++) {
				long l = Long.MIN_VALUE;
				currentPos = (7-i)*8+col;
				char current = tempPos[i].toCharArray()[j];
				if(Character.isDigit(current)) {
					col+=(int)current-48;
					continue;
				}
				long put, tl;
				switch (current) {
					case 'R' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("wR") | l;
						board.replace("wR", put);
					}
					case 'N' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("wN") | l;
						board.replace("wN", put);
					}
					case 'B' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("wB") | l;
						board.replace("wB", put);
					}
					case 'Q' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("wQ") | l;
						board.replace("wQ", put);
					}
					case 'K' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("wK") | l;
						board.replace("wK", put);
					}
					case 'P' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("wP") | l;
						board.replace("wP", put);
					}
					case 'r' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("bR") | l;
						board.replace("bR", put);
					}
					case 'n' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("bN") | l;
						board.replace("bN", put);
					}
					case 'b' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("bB") | l;
						board.replace("bB", put);
					}
					case 'q' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("bQ") | l;
						board.replace("bQ", put);
					}
					case 'k' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("bK") | l;
						board.replace("bK", put);
					}
					case 'p' -> {
						tl = l >>> currentPos;
						l = tl;
						put = board.get("bP") | l;
						board.replace("bP", put);
					}
				}
				col++;
			}
		}
	}

	public HashMap<String, Long> getBoard() {
		return board;
	}
}
