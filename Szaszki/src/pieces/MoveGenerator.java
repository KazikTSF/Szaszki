package pieces;

import game.BitBoards;
import game.Move;
import game.MoveType;

import java.util.ArrayList;

public class MoveGenerator {
    private final long NOT_A_FILE = 0B1111111011111110111111101111111011111110111111101111111011111110L;
    private final long NOT_H_FILE = 0B0111111101111111011111110111111101111111011111110111111101111111L;
    private final long NOT_AB_FILE = 0B1111110011111100111111001111110011111100111111001111110011111100L;
    private final long NOT_GH_FILE = 0B0011111100111111001111110011111100111111001111110011111100111111L;
    public static ArrayList<Move> wPawnsMoves(long pawnsPos, long usBoard, long ThemBoard) {
        ArrayList<Move> res = new ArrayList<>();
        long board = usBoard | ThemBoard;
        long single;
        long temp;
        //single pushes generator
        temp = pawnsPos >>> 8;
        single = temp ^ board;
        single = single & temp;
        char[] tempBB = BitBoards.bitBoardToString(single).toCharArray();
        for(int i = 0; i < 64; i++) {
            if(tempBB[i] == '1')
                res.add(new Move(i - 8, i, PieceType.PAWN, MoveType.QUIET));
        }
        //double push generator
        long pawnsOn2nd = 0B0000000011111111000000000000000000000000000000000000000000000000L;
        pawnsOn2nd = pawnsOn2nd & pawnsPos;
        pawnsOn2nd = pawnsOn2nd >>> 8;
        temp = pawnsOn2nd ^ board;
        temp = temp & pawnsOn2nd;
        pawnsOn2nd = temp >>> 8;
        temp = pawnsOn2nd ^ board;
        pawnsOn2nd = temp & pawnsOn2nd;
        tempBB = BitBoards.bitBoardToString(pawnsOn2nd).toCharArray();
        for(int i = 0; i < 64; i++) {
            if(tempBB[i] == '1')
                res.add(new Move(i - 16, i, PieceType.PAWN, MoveType.QUIET));
        }
        return res;
    }
    public ArrayList<Move> knightMove(long knightPos, long usBoard, long themBoard) {
        ArrayList<Move> res = new ArrayList<>();
        long lres = 0;
        int pos;
        lres = lres | (knightPos & NOT_H_FILE) << 17;
        lres = lres | (knightPos & NOT_GH_FILE) << 10;
        lres = lres | (knightPos & NOT_GH_FILE) >> 6;
        lres = lres | (knightPos & NOT_H_FILE) >> 15;
        lres = lres | (knightPos & NOT_A_FILE) << 15;
        lres = lres | (knightPos & NOT_AB_FILE) << 6;
        lres = lres | (knightPos & NOT_AB_FILE) >> 10;
        lres = lres | (knightPos & NOT_A_FILE) >> 17;
        lres = lres & (~usBoard);
        char[] cres = BitBoards.bitBoardToString(lres).toCharArray();
        for (char c : cres) {
            if (c != '0') ; //TODO move generation
        }
        return res;
    }
}
