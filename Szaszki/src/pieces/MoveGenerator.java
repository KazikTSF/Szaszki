package pieces;

import game.Move;

import java.util.ArrayList;

public class MoveGenerator {
    public static ArrayList<Move> pawnsMoves(long pawnsPos, long whiteboard, long blackBoard, boolean isWhite) {
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
}
