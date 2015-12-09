package fanny;

import java.util.List;

public class PlayerList {
	
	
	public PlayerList(List<Player> theList, int numberOfPositions) {
		super();
		this.thePostionList = theList;
		this.numberOfPositions = numberOfPositions;
	}

	private List<Player> thePostionList;
	private int numberOfPositions;

	public List<Player> getTheList() {
		return thePostionList;
	}

	public void setTheList(List<Player> theList) {
		this.thePostionList = theList;
	}

	public int getNumberOfPositions() {
		return numberOfPositions;
	}

	public void setNumberOfPositions(int numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}


}
