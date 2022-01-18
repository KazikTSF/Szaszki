package pieces;

import game.BitBoards;
import game.Move;

import java.util.ArrayList;

public class MoveGenerator {
    private final long NOT_A_FILE = 0B1111111011111110111111101111111011111110111111101111111011111110L;
    private final long NOT_H_FILE = 0B0111111101111111011111110111111101111111011111110111111101111111L;
    private final long NOT_AB_FILE = 0B1111110011111100111111001111110011111100111111001111110011111100L;
    private final long NOT_GH_FILE = 0B0011111100111111001111110011111100111111001111110011111100111111L;
    public ArrayList<Move> pawnsMoves(long pawnsPos, long whiteboard, long blackBoard, boolean isWhite) {
        ArrayList<Move> res = new ArrayList<>();
        long board = whiteboard | blackBoard;
        long single;
        long temp;
        if(isWhite) {
            temp = pawnsPos >>> 8;
            long t = temp ^ board;
            t = t & temp;
        }
        return res;
    }
    public ArrayList<Move> knightMove(long knightPos, long usBoard, long themBoard) {
        ArrayList<Move> res = new ArrayList<>();
        long lres = 0;
        int pos;
        lres = lres | (knightPos & NOT_H_FILE) << 17;
        lres = lres | (knightPos & NOT_GH_FILE) << 10;
        lres = lres | (knightPos & NOT_GH_FILE) >>  6;
        lres = lres | (knightPos & NOT_H_FILE) >> 15;
        lres = lres | (knightPos & NOT_A_FILE) << 15;
        lres = lres | (knightPos & NOT_AB_FILE) <<  6;
        lres = lres | (knightPos & NOT_AB_FILE) >> 10;
        lres = lres | (knightPos & NOT_A_FILE) >> 17;
        lres = lres & (~usBoard);
        char[] cres = BitBoards.bitBoardToString(lres).toCharArray();
        for(char c : cres) {
            if(c != '0'); //TODO move generation
        }
        return res;
    }
}
