import java.util.ArrayList;
import java.util.Scanner;

public class Zork {
	private static boolean exit = false;
	private static House house = new House();
	private static Inventory backPack = new Inventory();
	private static Player player = new Player("abishek", backPack, 0,100, 50, 0);
	public static void main(String[] args) {
		house.makeHouse();							//fill house with rooms	
		house.moveInto(0, 0);
		
		while(!exit)
		{
			System.out.println("Here");
			move();
		}
		
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
		if(house.getRooms()[newPosition].getClass().getName()=="Outside")
		{
			exit=true;
			return;
		}
		System.out.println("Where");

		//move player into new position
		house.moveInto(newPosition, currentPosition);
		player.movePlayer(newPosition);
		
		AbstractRoom newRoom = house.getRooms()[newPosition];
		Inventory roomStash = newRoom.getStash();
		//player takes stuff from room and room gets emptied 
		player.takeStuff(roomStash);
		house.getRooms()[newPosition].emptyStash();
		
	}
	
	public static int promptUser(Scanner sc, String prompt1, String prompt2)
	{
		int userInput=0;
		System.out.println(prompt1);
		System.out.println(prompt2);
		userInput = sc.nextInt();
		return userInput;
	}
}
