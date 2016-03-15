import java.util.ArrayList;

abstract  class AbstractRoom {
	protected String name;
	protected boolean isHere;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHere() {
		return isHere;
	}
	public void setHere(boolean isHere) {
		this.isHere = isHere;
	}
	
	abstract public  Inventory getStash();
	abstract public  void setStash(Inventory stash);
	abstract  public void emptyStash();
	abstract  public ArrayList<Character> getEnemies() ;
	abstract  public void setEnemies(ArrayList<Character> enemies);
	abstract  public String getMessage();
	abstract public  void setMessage(String message);
	abstract  public void addEnemy(Character enemy);
	abstract public  boolean isNorth();
	abstract public  boolean isSouth();
	abstract public  boolean isEast();
	abstract public  boolean isWest();
	abstract public  int[] getAccessibleRooms();
	abstract public  String giveOption();
}
