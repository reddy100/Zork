import java.util.ArrayList;

public class Room {
	private String name;
	private Inventory stash;
	private ArrayList<Character> enemies;;
	private Character player;
	private boolean isHere;
	private String message;
	
	public Room()
	{
		this.name="";
		this.stash=null;
		this.enemies = new ArrayList<Character>();
		this.player=new Player();
		isHere=false;
		message="";
	}
	
}
