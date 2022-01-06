package game;

import java.util.ArrayList;
import java.util.Optional;

import javafx.scene.control.ChoiceDialog;
import pieces.*;

public class Board 
{
	boolean whiteMove;
	Piece[] board = new Piece[64];
	int enPassantPos = -1;
	
	public Board(String pos) 
	{
		convertFEN(pos);
		for(int i = 0; i < 64; i++)
			if(board[i] != null)
				board[i].update(this);
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
	private void update() {
		for(int i = 0; i < board.length; i++) {
			if(board[i] != null)
				board[i].update(this);
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
	public void move(Piece piece, int move) {
		if(piece.getType() == PieceType.PAWN) {
			if(piece.isWhite() && piece.getPos()/8 == 1) {
				promote(piece, move);
				update();
				return;
			}
			else if(!piece.isWhite() && piece.getPos()/8 == 6) {
				promote(piece, move);
				update();
				return;
			}
		}

		boolean enPassantMove = false;
		int finalPos = piece.getPos()+move;
		if(piece.getType() == PieceType.PAWN) {
			if(move == 16 || move == -16) {
				enPassantPos = piece.getPos() + (move / 2);
				enPassantMove = true;
			}
			else if(piece.getPos()+move == enPassantPos)
				if(enPassantPos > 32)
					board[enPassantPos - 8] = null;
				else
					board[enPassantPos + 8] = null;
		}
		board[finalPos] = piece;
		board[piece.getPos()] = null;
		board[finalPos].setPos(piece.getPos()+move);
		update();
		if(whiteMove)
			whiteMove = false;
		else
			whiteMove = true;
		if(!enPassantMove)
			enPassantPos = -1;
}
	public boolean promote(Piece piece, int move) {
		int finalPos = piece.getPos()+move;
		ArrayList<String> choices = new ArrayList<>();
		choices.add("QUEEN");
		choices.add("BISHOP");
		choices.add("ROOK");
		choices.add("KNIGHT");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("QUEEN", choices);
		dialog.setTitle("Promotion");
		dialog.setHeaderText("Your pawn made it!!!");
		dialog.setContentText("Choose your promotion:");
		Optional<String> result = dialog.showAndWait();
		String choice;
		if (result.isPresent())
			choice = result.get();
		else
			return false;
		board[piece.getPos()] = null;
		switch (choice) {
			case "QUEEN":
				board[finalPos] = new Queen(piece.isWhite(), piece.getPos());
				break;
			case "BISHOP":
				board[finalPos] = new Bishop(piece.isWhite(), piece.getPos());
				break;
			case "ROOK":
				board[finalPos] = new Rook(piece.isWhite(), piece.getPos());
				break;
			case "KNIGHT":
				board[finalPos] = new Knight(piece.isWhite(), piece.getPos());
				break;
		}

		return true;
	}
}
