package model;

import java.util.Random;

import model.Box;

public class Board{
	
	private final int[][] DIFFICULTY_SIZES = {{8,8},{16,16},{16,30}};
	private final int[] DIFFICULTY_MINES_NUMBER = {10,40,99};
	
	public static final int NOVICE = 0;
	public static final int MEDIUM = 1;
	public static final int EXPERT = 2;
	
	private Box[][] board;
	
	private int level;
	private boolean gameOver;
	
	
	public Board(int level) {
		gameOver = false;
		this.level = level;
		generateBoard();
	}
	
	// this method is responsible for initializing the board with all the mines
	public void generateBoard() {
		// Set the sizes by the difficulty level
		board = new Box[DIFFICULTY_SIZES[level][0]][DIFFICULTY_SIZES[level][1]];
		// Set the number of mines in base of the difficulty level
		int numMines = DIFFICULTY_MINES_NUMBER[level];
		
		// Initialize the matrix of boxes
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new Box();
			}
		}
		
		// Put in random order the mines in the board
		while (numMines > 0) {
			int numH = (int) (Math.random() * board.length);
			int numW = (int) (Math.random() * board[0].length);
			if (!board[numH][numW].isMine()) {
				board[numH][numW].setMine(true);
				numMines--;
			}
		}
		
		// Put the proximity numbers in the boxes that do not have mines
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!board[i][j].isMine()) {
					putProximityNumbers(i, j);
				}
			}
		}
	}
	
	public void putProximityNumbers(int x,int y) {
		for (int i = (x-1 > 0 ? x-1:0) ; i < x+2 && i < board.length; i++) {
			for (int j = (y-1 > 0 ? y-1:0); j < y+2 && j < board[0].length; j++) {
				if (board[i][j].isMine()) {
					board[x][y].setNumberOfMinesAround(board[x][y].getNumberOfMinesAround() + 1);
				}
				if (j == y && x == i) {
					j++;
				}
			}
		}
	}

	public Box[][] getBoard() {
		return board;
	}
	
	public void uncoverBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j].setCover(false);
			}
		}
		gameOver = true;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void uncoverBox(int i, int j) {
		if(!board[i][j].isCover() || board[i][j].isMark()) {
			System.out.println("Error: La casilla esta marcada o destapada!!");
		}
		else if (board[i][j].isMine()) {
			gameOver = true;
		}else {
			board[i][j].setCover(false);
		}
	}

	public boolean isGameOver() {
		return gameOver;
	}
	
	public void putMark(int i,int j) {
		board[i][j].setMark(!board[i][j].isMark());
	}
	
	public void giveClue() {
		int num = 1;
		while (num > 0) {
			int numH = (int) (Math.random() * board.length);
			int numW = (int) (Math.random() * board[0].length);
			if (!board[numH][numW].isMine()) {
				board[numH][numW].setCover(false);
				num--;
			}
		}
	}
	
	public boolean isWin() {
		int numUncover = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!board[i][j].isCover()) {
					numUncover++;
				}
			}
		}
		return numUncover + DIFFICULTY_MINES_NUMBER[level] == board.length * board[0].length;
	}
	
	

}
