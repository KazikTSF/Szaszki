package game;

import java.util.ArrayList;

import static java.lang.Long.parseLong;

public class BitBoards {

    public static String bitBoardToString(long l) {
        String binary = Long.toBinaryString(l);
        return String.format("%64s", binary).replace(' ', '0');
    }
}
