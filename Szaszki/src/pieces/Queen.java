package pieces;

import game.Board;

import java.util.ArrayList;

public class Queen extends Piece implements SlideMove, CrossMove {
	private int pos;
	
	public Queen(boolean isWhite, int pos) {
		super(isWhite, PieceType.QUEEN, 9);
		this.pos = pos;
	}

	@Override
	public ArrayList<Integer> possibleMoves() {
		ArrayList<Integer> moves = new ArrayList<>();
		ArrayList<ArrayList<Integer>> temp = new ArrayList<>(SlideMove.slideMove(pos));
		for(int i = 0; i < 4; i++)
			moves.addAll(temp.get(i));
		temp = new ArrayList<>(CrossMove.crossMove(pos));
		for(int i = 0; i < 4; i++)
			moves.addAll(temp.get(i));
		return moves;
	}

	@Override
	public boolean isMovePossibleWhite(Board board, int move) {
		int finalPos = pos+move;
		int cmoves[] = {-63, -54, -45, -36, -27, -18, -9,
				9, 18, 27, 36, 45, 54, 63,
				-49, -42, -35, -28, -21, -14, -7,
				7, 14, 21, 28, 35, 42, 49};
		int hmoves[] = {-7, -6, -5, -4, -3, -2, -1,
				1, 2, 3, 4, 5, 6, 7,
				-56, -48, -40, -32, -24, -16, -8,
				8, 16, 24, 32, 40, 48, 56};
		int col = pos%8;
		int row = pos/8;
		if(move == -7) {
			if(row == 0 && col != 7)
				return false;
			if(col == 7) {
				for(int i = pos-1; i <= finalPos; i--) {
					if(board.getBoard()[i] != null) {
						if(i-pos == move && !board.getBoard()[i].isWhite())
							break;
						return false;
					}
				}
				return true;
			}
			else {
				if(board.getBoard()[finalPos] != null) {
					if(board.getBoard()[finalPos].isWhite())
						return false;
				}
				return true;
			}
		}
		else if(move == 7) {
			if(row ==  7 && col != 0)
				return false;
			if(col == 0) {
				for(int i = pos+1; i <= finalPos; i++) {
					if(board.getBoard()[i] != null) {
						if(i-pos == move && !board.getBoard()[i].isWhite())
							break;
						return false;
					}
				}
				return true;
			}
			else {
				if(board.getBoard()[finalPos] != null) {
					if(board.getBoard()[finalPos].isWhite())
						return false;
				}
				return true;
			}
		}
		//BISHOPLIKE MOVES
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
		else if(move < 0 && move%9 == 0) {
			for (int i = pos - 9; i >= finalPos; i -= 9) {
				if (board.getBoard()[i] != null) {
					if (i - pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		//ROOKLIKE MOVES
		if(move > 7) {
			for(int i = pos+8; i <= finalPos; i+=8) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < -7) {
			for(int i = pos-8; i >= finalPos; i-=8) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < 0) {
			for(int i = pos-1; i >= finalPos; i--) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && !board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		for(int i = pos+1; i <= finalPos; i++) {
			if(board.getBoard()[i] != null) {
				if(i-pos == move && !board.getBoard()[i].isWhite())
					break;
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isMovePossibleBlack(Board board, int move) {
		int finalPos = pos+move;
		int cmoves[] = {-63, -54, -45, -36, -27, -18, -9,
				9, 18, 27, 36, 45, 54, 63,
				-49, -42, -35, -28, -21, -14, -7,
				7, 14, 21, 28, 35, 42, 49};
		int hmoves[] = {-7, -6, -5, -4, -3, -2, -1,
				1, 2, 3, 4, 5, 6, 7,
				-56, -48, -40, -32, -24, -16, -8,
				8, 16, 24, 32, 40, 48, 56};
		int col = pos%8;
		int row = pos/8;
		if(move == -7) {
			if(row == 0 && col != 7)
				return false;
			if(col == 7) {
				for(int i = pos-1; i <= finalPos; i--) {
					if(board.getBoard()[i] != null) {
						if(i-pos == move && board.getBoard()[i].isWhite())
							break;
						return false;
					}
				}
				return true;
			}
			else {
				if(board.getBoard()[finalPos] != null) {
					if(!board.getBoard()[finalPos].isWhite())
						return false;
				}
				return true;
			}
		}
		else if(move == 7) {
			if(row ==  7 && col != 0)
				return false;
			if(col == 0) {
				for(int i = pos+1; i <= finalPos; i++) {
					if(board.getBoard()[i] != null) {
						if(i-pos == move && board.getBoard()[i].isWhite())
							break;
						return false;
					}
				}
				return true;
			}
			else {
				if(board.getBoard()[finalPos] != null) {
					if(!board.getBoard()[finalPos].isWhite())
						return false;
				}
				return true;
			}
		}
		//BISHOPLIKE MOVES
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
		//ROOKLIKE MOVES
		if(move > 7) {
			for(int i = pos+8; i <= finalPos; i+=8) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < -7) {
			for(int i = pos-8; i >= finalPos; i-=8) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		else if(move < 0) {
			for(int i = pos-1; i >= finalPos; i--) {
				if(board.getBoard()[i] != null) {
					if(i-pos == move && board.getBoard()[i].isWhite())
						break;
					return false;
				}
			}
			return true;
		}
		for(int i = pos+1; i <= finalPos; i++) {
			if(board.getBoard()[i] != null) {
				if(i-pos == move && board.getBoard()[i].isWhite())
					break;
				return false;
			}
		}
		return true;
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
