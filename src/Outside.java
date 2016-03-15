import java.util.ArrayList;

public class Outside extends AbstractRoom{
	private Inventory stash;
	private ArrayList<Character> enemies;;
	//private Character player;
	private boolean isHere;
	private String message;
	private boolean north;
	private boolean south;
	private int[] accessibleRooms;
	
	public Inventory getStash() {
		return stash;
	}
	public void setStash(Inventory stash) {
		this.stash = stash;
	}
	public void emptyStash()
	{
		this.stash.emptyInventory();
	}
	public ArrayList<Character> getEnemies() {
		return enemies;
	}
	public void setEnemies(ArrayList<Character> enemies) {
		this.enemies = enemies;
	}
	public void addEnemy(Character enemy)
	{
		this.enemies.add(enemy);
	}
	public boolean isHere() {
		return isHere;
	}
	public void setHere(boolean isHere) {
		this.isHere = isHere;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isNorth() {
		return north;
	}
	public void setNorth(boolean north) {
		this.north = north;
	}
	public boolean isSouth() {
		return south;
	}
	public void setSouth(boolean south) {
		this.south = south;
	}
	public boolean isEast() {
		return east;
	}
	public void setEast(boolean east) {
		this.east = east;
	}
	public boolean isWest() {
		return west;
	}
	public void setWest(boolean west) {
		this.west = west;
	}
	public int[] getAccessibleRooms() {
		return accessibleRooms;
	}
	public void setAccessibleRooms(int[] accessibleRooms) {
		this.accessibleRooms = accessibleRooms;
	}
	private boolean east;
	private boolean west;
	private int[] accesssibleRooms;
	
	public Outside()
	{
		super.name="";
		this.stash=null;
		this.enemies = new ArrayList<Character>();
		super.isHere=false;
		this.message="";
		this.accesssibleRooms=new int[4];
	}
	public Outside(String name, Inventory stash, ArrayList<Character> enemies, boolean isHere, String message, int [] accesssibleRooms)
	{
		super.name=name;
		this.stash=stash;
		this.enemies = enemies;
		super.isHere=isHere;
		this.message=message;
		this.accesssibleRooms = accesssibleRooms;
	}
	@Override
	public String giveOption()
	{
		String finalMessage= "You cannot go back into the house so press (1) to end the game";
		
		return finalMessage;
	}

}
