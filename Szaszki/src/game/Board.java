package game;

import javafx.scene.control.ChoiceDialog;
import pieces.*;

import java.util.ArrayList;
import java.util.Optional;

public class Board 
{
	private ArrayList<Long> board = new ArrayList<>();
	private int fiftyMoveRule = 0;
	private long enPassant;
	// 0 - wP
	// 1 - wR
	// 2 - wN
	// 3 - wB
	// 4 - wQ
	// 5 - wK
	// 6 - bP
	// 7 - bR
	// 8 - bN
	// 9 - bB
	// 10 - bQ
	// 11 - bK
	public ArrayList<Long> convertFEN(String fen) {
		ArrayList<Long> res = new ArrayList<>();
		ArrayList<ArrayList<Boolean>> binaries = new ArrayList<>(12);
		String[] sFEN = fen.split("\\s+");
		fiftyMoveRule = (int)sFEN[4].toCharArray()[0]-48;
		char[] temp;
		temp = sFEN[3].toCharArray();
		if(temp[0] == '-')
			enPassant = 0;
		else {
			int pos = ((int)temp[0]-97)+((int)temp[1]-48)*8;
			ArrayList<Boolean> tList = new ArrayList<>();
			for(int i = 0; i < 64; i++) {
				if(i == pos)
					tList.add(true);
				else {
					tList.add(false);
				}
			}
			enPassant = BitBoards.BoolArrToBitboard(tList);
		}
		/*
		if(Character.isDigit(c)) {
			for(int i = 0; i < (int)c-48; i++) {
				for(int j = 0; j < 12; j++) {
					binaries.get(j).add(false);
				}
			}
		*/
		return res;
	}
}
