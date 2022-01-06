package pieces;

import game.Board;

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
		ArrayList<Integer> moves = new ArrayList<>();
		if(super.isWhite()) {
			if(pos > 46 && pos < 56) {
				moves.add(-16);
			}
			moves.add(-8);
			moves.add(-7);
			moves.add(-9);
		}
		else {
			if(pos > 7 && pos < 16) {
				moves.add(16);
			}
			moves.add(8);
			moves.add(9);
			moves.add(7);
		}
			
		return moves;
	}
	@Override
	public boolean isMovePossibleWhite(Board board, int move) {
		enPassantPos = board.getEnPassantPos();
		if((pos+move) == enPassantPos)
			return true;
		if(move == -16) {
			if(board.getBoard()[pos-8] == null || board.getBoard()[pos+move] == null)
				return true;
		}
		else if(move == -8) {
			if(board.getBoard()[pos-8] == null)
				return true;
		}
		else if((move == -7 || move == -9) && board.getBoard()[pos+move] != null) {
			if(!board.getBoard()[pos+move].isWhite())
				return true;
		}
		return false;
	}
	@Override
	public boolean isMovePossibleBlack(Board board, int move) {
		enPassantPos = board.getEnPassantPos();
		if((pos+move) == enPassantPos)
			return true;
		if(move == 16) {
			if(board.getBoard()[pos+8] == null || board.getBoard()[pos+move] == null)
				return true;
		}
		else if(move == 8) {
			if(board.getBoard()[pos+move] == null)
				return true;
		}
		else if((move == 7 || move == 9) && board.getBoard()[pos+move] != null) {
			if(board.getBoard()[pos+move].isWhite())
				return true;
		}
		return false;
	}

	@Override
	public int getPos() {
		return pos;
	}

	@Override
	public void setPos(int pos) {
		this.pos = pos;
	}

}
