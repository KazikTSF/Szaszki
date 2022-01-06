package pieces;

import game.Board;

import java.util.ArrayList;

public class King extends Piece implements SlideMove {

	private boolean canQCastle;
	private boolean canKCastle;
	private int pos;
	
	public King(boolean isWhite, int pos, boolean canQCastle, boolean canKCastle) {
		super(isWhite, PieceType.KING, 200);
		this.pos = pos;
		this.canKCastle = canKCastle;
		this.canQCastle = canQCastle;
	}
	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> fmoves = new ArrayList<>();
		int[] moves = new int[8];
		int row = pos/8;
		int col = pos%8;
		moves[0] = -9;
		moves[1] = -8;
		moves[2] = -7;
		moves[3] = -1;
		moves[4] = 1;
		moves[5] = 9;
		moves[6] = 8;
		moves[7] = 7;
		if(col == 0) {
			moves[0] = 64;
			moves[3] = 64;
			moves[7] = 64;
		}
			
		if(col == 7) {
			moves[2] = 64;
			moves[4] = 64;
			moves[5] = 64;
		}
		if(row == 0) {
			moves[0] = 64;
			moves[1] = 64;
			moves[2] = 64;
		}
		if(row == 7) {
			moves[5] = 64;
			moves[6] = 64;
			moves[7] = 64;
		}
		for(int i = 0; i < moves.length; i++) {
			if(moves[i] != 64)
				fmoves.add(moves[i]);
		}
			
		return fmoves;
	}

	@Override
	public boolean isMovePossibleWhite(Board board, int move) {
			if(board.getBoard()[pos+move] == null || !board.getBoard()[pos+move].isWhite())
				return true;
		return false;
	}

	@Override
	public boolean isMovePossibleBlack(Board board, int move) {
		if(board.getBoard()[pos+move] == null || board.getBoard()[pos+move].isWhite())
			return true;
		return false;
	}

	public boolean canQCastle() {
		return canQCastle;
	}

	public void setCanQCastle(boolean canQCastle) {
		this.canQCastle = canQCastle;
	}

	public boolean canKCastle() {
		return canKCastle;
	}

	public void setCanKCastle(boolean canKCastle) {
		this.canKCastle = canKCastle;
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
