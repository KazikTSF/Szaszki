package pieces;

import java.util.ArrayList;

public class Pawn extends Piece implements SlideMove {
	private int pos;
	private int enPassantPos;
	public Pawn(boolean isWhite, int pos) {
		super(isWhite, PieceType.PAWN, 1);
		this.pos = pos;
	}

	@Override
	protected ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		if(super.isWhite()) {
			if(pos > 46 && pos < 56) {
				moves.add(-16);
			}
			moves.add(-8);
		}
		else {
			if(pos > 7 && pos < 16) {
				moves.add(16);
			}
			moves.add(8);
		}
		if(super.isWhite()) {
				moves.add(-7);
				moves.add(-9);
		}
		else {
				moves.add(9);
				moves.add(7);
		}
			
		return moves;
	}
	@Override
	public boolean isMovePossible(Piece[] board, int move) {
		if(move == -16) {
			if(board[pos-8] == null || board[pos+move] == null)
				return true;
		}
		else if(move == 16) {
			if(board[pos+8] == null || board[pos+move] == null)
				return true;
		}
		else if(move == -8) {
			if(board[pos-8] == null)
				return true;
		}
		else if(move == 8) {
			if(board[pos+move] == null)
				return true;
		}
		else if((move == 7 || move == 9 || move == -7 || move == -9) && board[pos+move] != null){
			if((pos+move) == enPassantPos)
				return true;
			if(super.isWhite()) {
				if(!board[pos+move].isWhite())
					return true;
			}
			else {
				if(board[pos+move].isWhite())
					return true;
			}	
		}
		return false;
	}
	@Override
	public int getPos() {
		return pos;
	}

	public void setEnPassantPos(int enPassant) {
		this.enPassantPos = enPassant;
	}

	@Override
	public void setPos(int pos) {
		this.pos = pos;
	}
	
}
