package game;

import javafx.scene.control.ChoiceDialog;
import pieces.*;

import java.util.ArrayList;
import java.util.Optional;

public class Board 
{
	boolean whiteMove;
	Piece[] board = new Piece[64];
	int enPassantPos = -1;
	ArrayList<Move> possibleMovesWhite = new ArrayList<>();
	ArrayList<Move> possibleMovesBlack = new ArrayList<>();
	Move lastMove;
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
			switch (pos[size - i]) {
				case 'K' -> Kcastle = true;
				case 'Q' -> Qcastle = true;
				case 'q' -> qcastle = true;
				case 'k' -> kcastle = true;
				case 'w' -> whiteMove = true;
				case 'b' -> whiteMove = false;
			}
		}
		int currentPos;
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
	public void update() {
		possibleMovesWhite = new ArrayList<>();
		possibleMovesBlack = new ArrayList<>();
		for (Piece piece : board) {
			if (piece != null) {
				piece.update(this);
				ArrayList<Integer> moves = piece.getPossibleMoves();
				if (piece.isWhite()) {
					for (int move : moves) {
						possibleMovesWhite.add(new Move(move, piece.getPos(), piece));
					}
				} else {
					for (int move : moves) {
						possibleMovesBlack.add(new Move(move, piece.getPos(), piece));
					}
				}
			}
		}

	}

	public void move(Piece piece, int move) {
		possibleMovesWhite = new ArrayList<>();
		possibleMovesBlack = new ArrayList<>();
		whiteMove = !whiteMove;
		if(piece.getType() == PieceType.PAWN) {
			if(piece.isWhite()) {
				if(piece.getPos()/8 == 1) {
					enPassantPos = -1;
					if(promote(piece, move))
						return;
					update();
					return;
				}
			}
			else {
				if(piece.getPos()/8 == 6) {
					enPassantPos = -1;
					if(promote(piece, move))
						return;
					update();
					return;
				}
			}

		}
		else if(piece.getType() == PieceType.KING) {

			if(move == 2) {
				if(piece.isWhite()) {
					KCastleWhite((King) piece);
				}
				else {
					KCastleBlack((King) piece);
				}
				update();
				enPassantPos = -1;
				return;
			}
			else if(move == -2) {
				if(piece.isWhite()) {
					QCastleWhite((King) piece);
				}
				else {
					QCastleBlack((King) piece);
				}
				update();
				enPassantPos = -1;
				return;
			}
			else
				piece = new King(piece.isWhite(), piece.getPos(), false, false);
		}
		else if(piece.getType() == PieceType.ROOK) {
			King temp = (King)board[60];
			if(temp != null) {
				if (piece.isWhite()) {
					if (board[60].getType() == PieceType.KING) {
						if (piece.getPos() == 63)
							board[60] = new King(true, 60, temp.canQCastle(), false);
						if (piece.getPos() == 56)
							board[60] = new King(true, 60, false, temp.canQCastle());
					}
				} else {
					if (board[4].getType() == PieceType.KING) {
						if (piece.getPos() == 7)
							board[4] = new King(false, 4, temp.canQCastle(), false);
						if (piece.getPos() == 0)
							board[4] = new King(false, 4, false, temp.canQCastle());
					}
				}
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
		if(!enPassantMove)
			enPassantPos = -1;
		lastMove = new Move(move, piece.getPos()-move, piece);
	}
	public void unmakeMove(Move move) {
		whiteMove = !whiteMove;
		board[move.getFINAL_POS()] = null;
		board[move.getINITIAL_POS()] = move.getPiece();
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
			return true;
		board[piece.getPos()] = null;
		switch (choice) {
			case "QUEEN" -> board[finalPos] = new Queen(piece.isWhite(), piece.getPos());
			case "BISHOP" -> board[finalPos] = new Bishop(piece.isWhite(), piece.getPos());
			case "ROOK" -> board[finalPos] = new Rook(piece.isWhite(), piece.getPos());
			case "KNIGHT" -> board[finalPos] = new Knight(piece.isWhite(), piece.getPos());
		}
		return false;
	}
	public void KCastleWhite(King king) {
		Rook rook = (Rook)board[63];
		king.setPos(62);
		rook.setPos(61);
		board[62] = new King(king.isWhite(), king.getPos(), false, false);
		board[61] = rook;
		board[60] = null;
		board[63] = null;
	}
	public void KCastleBlack(King king) {
		Rook rook = (Rook)board[7];
		king.setPos(6);
		rook.setPos(5);
		board[6] = new King(king.isWhite(), king.getPos(), false, false);
		board[5] = rook;
		board[4] = null;
		board[7] = null;
	}
	public void QCastleWhite(King king) {
		Rook rook = (Rook)board[56];
		king.setPos(58);
		rook.setPos(59);
		board[58] = new King(king.isWhite(), king.getPos(), false, false);
		board[59] = rook;
		board[60] = null;
		board[56] = null;
	}
	public void QCastleBlack(King king) {
		Rook rook = (Rook)board[0];
		king.setPos(2);
		rook.setPos(3);
		board[2] = new King(king.isWhite(), king.getPos(), false, false);
		board[3] = rook;
		board[4] = null;
		board[0] = null;
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

	public ArrayList<Move> getPossibleMovesWhite() {
		return possibleMovesWhite;
	}

	public ArrayList<Move> getPossibleMovesBlack() {
		return possibleMovesBlack;
	}

	public Move getLastMove() {
		return lastMove;
	}

}
