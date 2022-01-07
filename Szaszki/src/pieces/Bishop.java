package pieces;

import game.Board;

import java.util.ArrayList;

public class Bishop extends Piece implements CrossMove {

	private int pos;
	
	public Bishop(boolean isWhite, int pos) {
		super(isWhite, PieceType.BISHOP, 3);
		this.pos = pos;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves = new ArrayList<>();
		ArrayList<ArrayList<Integer>> temp = new ArrayList<>(CrossMove.crossMove(pos));
		for(int i = 0; i < 4; i++)
			moves.addAll(temp.get(i));
		return moves;
	}

	@Override
	public boolean isMovePossibleWhite(Board board, int move) {
		int finalPos = pos+move;
		if(move < 0 && move%7 == 0) {
			for (int i = pos - 7; i >= finalPos; i -= 7) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move > 0 && move%9 == 0) {
			for (int i = pos + 9; i <= finalPos; i += 9) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move > 0 && move%7 == 0) {
			for (int i = pos + 7; i <= finalPos; i += 7) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else {
			for (int i = pos - 9; i >= finalPos; i -= 9) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
	}

	@Override
	public boolean isMovePossibleBlack(Board board, int move) {
		int finalPos = pos+move;
		if(move < 0 && move%7 == 0) {
			for (int i = pos - 7; i >= finalPos; i -= 7) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move > 0 && move%9 == 0) {
			for (int i = pos + 9; i <= finalPos; i += 9) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move > 0 && move%7 == 0) {
			for (int i = pos + 7; i <= finalPos; i += 7) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < 0 && move%9 == 0) {
			for (int i = pos - 9; i >= finalPos; i -= 9) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
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
