package fanny;

public class Player {
	public Player(){;}
	
	public Player(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}
	private String name;
	private int    value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
