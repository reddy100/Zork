import java.util.ArrayList;

public class Player extends Character{
	private int moneyPurse;
	private ArrayList<AbstractRoom> roomsVisited;
	public Player()
	{
		super.name = "";
		super. backPack = new Inventory();
		super.hp = 0;
		super.attack = 0;
		super.currentPos = 0;
		this.moneyPurse=0;
		this.roomsVisited = new ArrayList<AbstractRoom>();
	}
	public Player(String name, Inventory backPack, int moneyPurse,int hp, int attack, int currentPos)
	{
		super.name = name;
		super. backPack = backPack;
		super.hp = hp;
		super.attack = attack;
		super.currentPos = currentPos;
		this.moneyPurse=moneyPurse;
		this.roomsVisited = new ArrayList<AbstractRoom>();

	}
	public int getMoneyPurse() {
		return moneyPurse;
	}
	public void setMoneyPurse(int moneyPurse) {
		this.moneyPurse = moneyPurse;
	}
	public ArrayList<AbstractRoom> getRoomsVisited() {
		return roomsVisited;
	}
	public void setRoomsVisited(ArrayList<AbstractRoom> roomsVisited) {
		this.roomsVisited = roomsVisited;
	}
	public void movePlayer(int pos)
	{
		super.currentPos=pos;
	}
	public void takeStuff(Inventory roomItems)
	{
		if(roomItems!=null)
		{
			this.backPack.addItemsToInventory(roomItems);
			this.moneyPurse+=roomItems.getMoney();
		}
		return;
	}
	public void roomsSeen(AbstractRoom r)
	{
		if(r!=null)
			this.roomsVisited.add(r);
	}
}
