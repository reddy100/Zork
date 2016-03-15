import java.util.ArrayList;
import java.util.Scanner;

public class House {
	private int numberOfRooms;
	private AbstractRoom[] rooms;
	
	public House()
	{
		this.numberOfRooms = 0;
		this.rooms = new AbstractRoom [9];

	}
	public House(AbstractRoom[] rooms)
	{
		this.numberOfRooms = rooms.length;
		this.rooms = rooms;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public AbstractRoom[] getRooms() {
		return rooms;
	}
	public void setRooms(AbstractRoom[] rooms) {
		this.rooms = rooms;
	}
	public void makeHouse()
	{
		//make inventory for each room
		Inventory one = new Inventory();one.makeFoyerStash();
		Inventory two = new Inventory();two.makeFrontRoomStash();
		Inventory three = new Inventory();three.makeLibraryStash();
		Inventory four = new Inventory();four.makeKitchenStash();
		Inventory five = new Inventory();five.makeDiningRoomStash();
		Inventory six = new Inventory();six.makeVaultStash();
		Inventory seven = new Inventory();seven.makeParlorStash();
		Inventory eight = new Inventory();eight.makeSecretRoomStash();
		Inventory skullStash = new Inventory();skullStash.makeSkullStash();
		
		
		Enemy skeleton = new Enemy("skeleton", skullStash, 100, 10, 5);
		ArrayList<Character> vaultEnemy = new ArrayList<Character>();vaultEnemy.add(skeleton);
		
		Room foyer = new Room("The foyer", one, null, false, "You see a dead scorpion" , new int[] {1,8,-1,-1});
		Room frontRoom = new Room("The front room", two, null, false, "You see a piano" , new int[] {-1,0,3,2});
		Room library = new Room("The library", three, null, false, "You see a lot of spiders on the bookshelves" , new int[] {4,-1,1,-1});
		Room kitchen = new Room("The kitchen", four, null, false, "Bats fly out of the kitchen as you walk in" , new int[] {6,-1,-1,1});
		Room diningRoom = new Room("The dining room", five, null, false, "There are a lot of dusty boxes on the dining table" , new int[] {-1,2,-1,-1});
		Vault vault = new Vault("The vault", six, vaultEnemy, false, "Three walking skeletons guard the vault" , new int[] {-1,-1,6,-1});
		Room parlor = new Room("Parlor", seven, null, false, "A treasure chest lies on the floor. It is locked" , new int[] {-1,3,-1,5});
		Room secretRoom = new Room("A secret room", eight, null, false, "Piles of gold line the floor" , new int[] {-1,5,-1,-1});
		Outside outside = new Outside("the great outdoors", null, null,false, "You leave the house. But do you still have your sanity?", new int[]{-1, -1, -1, -1});
		
		foyer.setDirections(true, true, false, false);
		frontRoom.setDirections(false, true, true, true);
		library.setDirections(true, false, true, false);
		kitchen.setDirections(true, false, false, true);
		diningRoom.setDirections(false, true, false, false);
		vault.setDirections(false, false, true, false);
		parlor.setDirections(false, true, false, true);
		secretRoom.setDirections(false, true, false, false);
		
		//adding rooms to house
		rooms[0]=foyer;
		rooms[1]=frontRoom;
		rooms[2]=library;
		rooms[3]=kitchen;
		rooms[4]=diningRoom;
		rooms[5]=vault;
		rooms[6]=parlor;
		rooms[7]=secretRoom;
		rooms[8]=outside;
	}
	
	//player moves from one room to another hence we set the boolean flags
	public void moveInto(int intoRoom, int outOfRoom)
	{
		this.rooms[outOfRoom].setHere(false);
		this.rooms[intoRoom].setHere(true);
		
	}
	
	public int whereIsPlayer()
	{
		for(int i =0; i<rooms.length;i++)
		{
			if(rooms[i].isHere())
			{
				return i;
			}
		}
		return -1;
	}
	
	
}
