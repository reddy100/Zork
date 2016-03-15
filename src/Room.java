import java.util.ArrayList;

public class Room extends AbstractRoom{
	
	private Inventory stash;
	private ArrayList<Character> enemies;;
	//private Character player;
	private boolean isHere;
	private String message;
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	private int[] accessibleRooms;
	
	public Room()
	{
		super.name="";
		this.stash=null;
		this.enemies = new ArrayList<Character>();
		super.isHere=false;
		this.message="";
		this.accessibleRooms=new int[4];
	}
	public Room(String name, Inventory stash, ArrayList<Character> enemies, boolean isHere, String message, int [] accessibleRooms)
	{
		super.name=name;
		this.stash=stash;
		this.enemies = enemies;
		super.isHere=isHere;
		this.message=message;
		this.accessibleRooms = accessibleRooms;
	}
	public Inventory getStash() {
		if(stash!=null)
			return stash;
		else 
			return null;
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
	public void addEnemy(Character enemy)
	{
		this.enemies.add(enemy);
	}
	
	public boolean isNorth() {
		return north;
	}
	public boolean isSouth() {
		return south;
	}
	public boolean isEast() {
		return east;
	}
	public boolean isWest() {
		return west;
	}
	public void setDirections(boolean north, boolean south, boolean east, boolean west)
	{
		this.north=north;
		this.south=south;
		this.east=east;
		this.west=west;
	}
	public int[] getAccessibleRooms()
	{
		return this.accessibleRooms;
	}
	public void setaccessibleRooms(int[] accessibleRooms) {
		this.accessibleRooms = accessibleRooms;
	}
	@Override
	public String giveOption()
	{
		String option = "You can press ";
		if(this.north)
		{
			option+="(n)To go north ";
		}
		if(this.south)
		{
			option+=" (s)To go south ";
		}
		if(this.east)
		{
			option+=" (e)To go east ";
		}
		if(this.west)
		{
			option+=" (w)To go west ";
		}
		return option;
	}
}
