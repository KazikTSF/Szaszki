package game;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Board 
{
	boolean whiteMove;
	Piece[] board = new Piece[64];
	int enPassantPos = -1;
	
	public Board(String pos) 
	{
		convertFEN(pos);
	}
	private void convertFEN(String position)
	{
		char[] pos = position.toCharArray();
		int size = pos.length-1;
		int spacecount = 1;		
		boolean Kcastle = false;
		boolean Qcastle = false;
		boolean kcastle = false;
		boolean qcastle = false;
		
		if(Character.isDigit(pos[size])) {
			int row = 8 - ((int)pos[size]-48);
			int col = (int)pos[size-1]-97;
			enPassantPos=row*8+col;
			spacecount--;
		}

		for(int i = 2; spacecount < 3; i++)
		{
			if(pos[size-i] == ' ') {
				spacecount++;
				continue;
			}
			switch(pos[size-i]) {
				case 'K':
					Kcastle = true;
					break;
				case 'Q':
					Qcastle = true;
					break;
				case 'q':
					qcastle = true;
					break;
				case 'k':
					kcastle = true;
					break;
				case 'w':
					whiteMove = true;
					break;
				case 'b':
					whiteMove = false;
					break;
			}
		}
		int currentPos = 0;
		int i = 0;
		
		for(int row = 0; row < 8; row++) 
		{
			char c = pos[i];
			for(int col = 0; c != '/' && c != ' ' && col <= 8; col++)
			{
				c = pos[i];
				i++;
				if(Character.isDigit(c)) {
					for(int j = 0; j < (int)c-48; j++) {
						col++;
					}
					col--;
					continue;
				}
				
				currentPos = row*8+col;
				
				if (c == 'n') {
					board[currentPos] = new Knight(false, currentPos);
				} 
				else if (c == 'r') {
					board[currentPos] = new Rook(false, currentPos);
				} 
				else if (c == 'b') {
					board[currentPos] = new Bishop(false, currentPos);
				} 
				else if (c == 'q') {
					board[currentPos] = new Queen(false, currentPos);
				} 
				else if (c == 'k') {
					board[currentPos] = new King(false, currentPos, qcastle, kcastle);
				} 
				else if (c == 'p') {
						board[currentPos] = new Pawn(false, currentPos);
				} 
				else if (c == 'N') {
					board[currentPos] = new Knight(true, currentPos);
				} 
				else if (c == 'R') {
					board[currentPos] = new Rook(true, currentPos);
				} 
				else if (c == 'B') {
					board[currentPos] = new Bishop(true, currentPos);
				} 
				else if (c == 'Q') {
					board[currentPos] = new Queen(true, currentPos);
				} 
				else if (c == 'K') {
					board[currentPos] = new King(true, currentPos, Qcastle, Kcastle);
				} 
				else if (c == 'P') {
						board[currentPos] = new Pawn(true, currentPos);
				}
			}
		}
	}
	public boolean isWhiteMove() {
		return whiteMove;
	}
	public Piece[] getBoard() {
		return board;
	}
	public int getEnPassantPos() {
		return enPassantPos;
	}
	
}
