package game;

import java.util.ArrayList;

import static java.lang.Long.parseLong;

public class BitBoards {

    public static ArrayList<Boolean> bitBoardToBoolArr(long l) {
        ArrayList<Boolean> res = new ArrayList<>();
        String binary = Long.toBinaryString(l);
        String padding = String.format("%64s", binary).replace(' ', '0');
        char[] s = padding.toCharArray();
        for(char c : s) {
            if(c == 1)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
    public static long BoolArrToBitboard(ArrayList<Boolean> list) {
        String s = "";
        long res;
        for(boolean value : list) {
            if(value)
                s+="1";
            else
                s+="0";
        }
        if (s.length() < 64) {
            res = Long.parseLong(s, 2);
        } else {
            res = Long.parseLong(s.substring(1), 2);
            if (s.charAt(0) == '1') {
                res |= (1L << 63);
            }
        }
        return res;
    }
}
