import java.util.ArrayList;
import java.util.Random;

public class Vault extends AbstractRoom{
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
	private int secretRoom;
	private boolean secretRoomFlag;
	
	public Inventory getStash() {
		return stash;
	}
	public void setStash(Inventory stash) {
		this.stash = stash;
	}
	public void emptyStash()
	{
		if(this.stash!=null)
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
	public void setDirections(boolean north, boolean south, boolean east, boolean west)
	{
		this.north=north;
		this.south=south;
		this.east=east;
		this.west=west;
	}
	public Vault()
	{
		super.name="";
		this.stash=null;
		this.enemies = new ArrayList<Character>();
		super.isHere=false;
		this.message="";
		this.accessibleRooms=new int[4];
		this.secretRoom=0;
		this.secretRoomFlag=false;
	}
	public Vault(String name, Inventory stash, ArrayList<Character> enemies, boolean isHere, String message, int [] accessibleRooms)
	{
		super.name=name;
		this.stash=stash;
		this.enemies = enemies;
		super.isHere=isHere;
		this.message=message;
		this.accessibleRooms = accessibleRooms;
		this.secretRoom=0;
		this.secretRoomFlag=false;

	}
	@Override
	public String giveOption()
	{
		Random rand = new Random();
		this.secretRoom = 1+rand.nextInt(4);
		if(this.secretRoom==1)
		{
			this.secretRoomFlag=true;
		}
		if(this.secretRoomFlag)
		{
			this.north=true;
			this.accessibleRooms[0]=7;
			System.out.println("You have discovered the secret room");
		}
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
