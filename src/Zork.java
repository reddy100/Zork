import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//add ghost 
public class Zork {
	private static boolean exit = false;
	private static boolean secretRoom = false;
	private static House house = new House();
	private static Inventory backPack = new Inventory();
	private static Player player = new Player("abishek", backPack, 0,100, 50, 0);
	public static void main(String[] args) {
		house.makeHouse();							//fill house with rooms	
		movePlayer(0, 0);
		pickUpStuff(0);
		while(!exit)
		{
			move();
		}
		report();
	}
	
	public static void move()
	{
		Scanner sc = new Scanner(System.in);
		int currentPosition = player.getCurrentPos();
		AbstractRoom current = house.getRooms()[currentPosition];
		int newPosition = -1;
		int userInput=0;
		//if it is an invalid move getAccessibleRooms returns -1
		while(house.getRooms()[userInput]==null || newPosition==-1)
		{
			userInput = promptUser(sc, "You are currently in "+current.getName()+"\n"+current.getMessage(), current.giveOption());
			newPosition=current.getAccessibleRooms()[userInput];
			if(house.getRooms()[userInput]==null)
				System.out.println("There");
		}
		
		//check if the player has stepped outside the house
		checkIfOutside(newPosition);
		//move player into new position
		movePlayer(newPosition,currentPosition);
		//player picks up items and money and room is emptied. Expand to give player choice
		pickUpStuff(newPosition);
		
		
	}
	//asks user for input
	public static int promptUser(Scanner sc, String prompt1, String prompt2)
	{
		int userInput=0;
		System.out.println(prompt1);
		System.out.println(prompt2);
		userInput = directionToInt(sc.next());
		return userInput;
	}
	//takes a string input and returns int
	public static int directionToInt(String dir)
	{
		if(dir.equals("n"))
			return 0;
		else if(dir.equals("s"))
			return 1;
		else if(dir.equals("e"))
			return 2;
		else if(dir.equals("w"))
			return 3;
		else
			return -1;
	}
	//Performs all the checks and print statements when player exits the house
	public static void checkIfOutside(int newPosition)
	{
		if(house.getRooms()[newPosition].getClass().getName()=="Outside")
		{
			Random rand = new Random();
			int ghost = 1+rand.nextInt(4);
			System.out.println("You exited the house");
			if(ghost==1)
			{
				System.out.println("Don't look back. You're being followed by the GHOST OF ZORK");
			}
			exit=true;
			return;
		}
	}
	
	
	//calls all methods related to movement of player
	//changes house attributes in house and changes position attributes for player
	public static void movePlayer(int newPosition, int currentPosition)
	{
		house.moveInto(newPosition, currentPosition);
		player.movePlayer(newPosition);
		player.roomsSeen(house.getRooms()[newPosition]);
	}
	//calls all methods related to adding to player inventory
	//and emptying room's inventory
	public static void pickUpStuff(int newPosition)
	{
		AbstractRoom newRoom = house.getRooms()[newPosition];
		Inventory roomStash = newRoom.getStash();
		//player takes stuff from room and room gets emptied 
		if(roomStash!=null && roomStash.getStash()!=null )
		{
			System.out.println("You picked up "+roomStash.getStash().get(0).getName()+" and "+roomStash.getMoney()+" gold");
			player.takeStuff(roomStash);
			house.getRooms()[newPosition].emptyStash();
		}
	}
	public static void report()
	{
		String itemsPickedUp ="Items in bag: ";
		String roomsSeen="Rooms visited: ";
		System.out.println("Current Money in purse: "+player.getMoneyPurse());
		for(int i=0;i<player.getBackPack().getStash().size();i++)
		{
			itemsPickedUp+=player.getBackPack().getStash().get(i).getName();
			if(i<player.getBackPack().getStash().size()-1)
			{
				itemsPickedUp+=", ";
			}
		}
		for(int j=0;j<player.getRoomsVisited().size()-1;j++)
		{
			roomsSeen+=player.getRoomsVisited().get(j).getName();
			if(j<player.getRoomsVisited().size()-2)
			{
				roomsSeen+=", ";
			}
		}
		System.out.println(itemsPickedUp);
		System.out.println("Number of rooms visited: "+(player.getRoomsVisited().size()-1));
		System.out.println(roomsSeen);

	}
}
