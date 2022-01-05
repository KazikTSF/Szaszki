package pieces;

import java.util.ArrayList;

public interface SlideMove {
	
	default ArrayList<Integer> slideMove(int pos) {
		
		ArrayList<Integer> moves = new ArrayList<Integer>();
		int row = pos/8;
		int col = pos%8;
		
		for(int i = col; i < 63; i+=8) {
			int currPos = row*8+i;
			if(currPos == pos)
				continue;
			moves.add(currPos-pos);
		}
		for(int i = 0; i < 8; i++) {
			int currPos = row*8+i;
			if(currPos == pos)
				continue;
			moves.add(currPos-pos);
		}
		return moves;
	}
}
