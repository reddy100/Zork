
public class Player extends Character{
	private int moneyPurse;
	public Player()
	{
		super.name = "";
		super. backPack = new Inventory();
		super.hp = 0;
		super.attack = 0;
		super.currentPos = 0;
		this.moneyPurse=0;
	}
	public Player(String name, Inventory backPack, int moneyPurse,int hp, int attack, int currentPos)
	{
		super.name = name;
		super. backPack = backPack;
		super.hp = hp;
		super.attack = attack;
		super.currentPos = currentPos;
		this.moneyPurse=moneyPurse;
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
}
