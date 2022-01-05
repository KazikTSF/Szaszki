package pieces;

import java.util.ArrayList;

public class Rook extends Piece implements SlideMove {
	private int pos;
	
	public Rook(boolean isWhite, int pos) {
		super(isWhite, PieceType.ROOK, 5);
		this. pos = pos;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves = new ArrayList<Integer>();
		moves.addAll(SlideMove.slideMove(pos));
		return moves;
	}

	@Override
	public boolean isMovePossible(Piece[] board, int move) {
		// TODO Auto-generated method stub
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

	@Override
	public ArrayList<Integer> listPossibleMoves(Piece[] board) {
		// TODO Auto-generated method stub
		return null;
	}
}
