package model;

public class Box {
	public static final int ONE_MINE_AROUND = 1;
	public static final int TWO_MINES_AROUND = 2;
	public static final int THREE_MINES_AROUND = 3;
	public static final int FOUR_MINES_AROUND = 4;
	public static final int ZERO_MINES_AROUND = 0;
	
	private boolean isCover;
	private int numberOfMinesAround;
	private boolean isMine;
	private boolean isMark;
	
	public Box() {
		isCover = true;
	}

	public boolean isCover() {
		return isCover;
	}

	public void setCover(boolean isCover) {
		this.isCover = isCover;
	}

	public int getNumberOfMinesAround() {
		return numberOfMinesAround;
	}

	public void setNumberOfMinesAround(int numberOfMinesAround) {
		this.numberOfMinesAround = numberOfMinesAround;
	}

	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}
	
	public String imageString() {
		String returnVariable = "0"; //"Ruta/" + 0 + ".png";
		if(isMark){
			returnVariable = "M";
		}else if (isCover) {
			returnVariable = "0"; //"Ruta/" + 0 + ".png";
		}else if (isMine) {
			returnVariable = "X"; //"Ruta/" + 1 + ".png";
		}else {
			returnVariable = "" + numberOfMinesAround; //"Ruta/" +  + ".png";
		}
		
		
		return returnVariable;
	}

	public boolean isMark() {
		return isMark;
	}

	public void setMark(boolean isMark) {
		this.isMark = isMark;
	}
	
	
}
