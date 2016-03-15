import java.util.ArrayList;
import java.util.Random;

public class Inventory {
	private ArrayList<Item> stash;
	private int money;
	
	public Inventory()
	{
		this.stash = new ArrayList<Item>();
		this.money = 0;
	}
	
	public Inventory(ArrayList<Item> stash, int money)
	{
		this.stash = stash;
		this.money = money;
	}
	
	public ArrayList<Item> getStash() {
		return stash;
	}
	public void setStash(ArrayList<Item> stash) {
		this.stash = stash;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void emptyInventory()
	{
		this.stash = null;
		this.money = 0;
	}
	public ArrayList<Item> takeItems()
	{
		ArrayList<Item> temp = this.stash;
		this.stash = null;		
		return temp;
		
	} 
	public int takeMoney()
	{
		int temp = this.money;
		this.money = 0;
		return temp;
	}
	public Item takeItem(int ind)
	{
		Item temp = new Item();
		temp=null;
		if(ind>=0 && ind<this.stash.size() && this.stash.get(ind)!=null)
		{
			temp = this.stash.get(ind);
			this.stash.remove(ind);	
		}
		return temp;
	}
	public void addItemsToInventory(Inventory i)
	{
		if(i!=null)
		{
			this.money+=i.getMoney();
			if(i.getStash()!=null && i.getStash().size()>0)
			{
				this.stash.addAll(i.getStash());
			}
		}
		else
			return;
	}
	//randomly assigns between 1 to 300 money in every room
	public static int fillMoney()
	{
		Random rand = new Random();
		return (1+ rand.nextInt(301));
	}
	
	public void makeFoyerStash()
	{
		ArrayList<Item> items= new ArrayList<Item>();
		Item scorpion = new Item("dead scorpion", "You see a dead scorpion", true);
		items.add(scorpion);
		this.stash = items;
		this.money=fillMoney();
	}
	public void makeFrontRoomStash()
	{
		ArrayList<Item> items= new ArrayList<Item>();
		Item piano = new Item("piano", "You see a piano", false);
		items.add(piano);
		this.stash = items;
		this.money=fillMoney();	
	}
	public void makeLibraryStash()
	{
		ArrayList<Item> items= new ArrayList<Item>();
		Item spiders = new Item("spiders", "Spiders line the bookshelves", true);
		items.add(spiders);
		this.stash = items;
		this.money=fillMoney();	
	}
	public void makeKitchenStash()
	{
		ArrayList<Item> items= new ArrayList<Item>();
		Item bats = new Item("bats", "Bats fly out of the kitchen as you walk in", true);
		items.add(bats);
		this.stash = items;
		this.money=fillMoney();	
	}
	public void makeDiningRoomStash()
	{
		ArrayList<Item> items= new ArrayList<Item>();
		Item dustyBoxes = new Item("bats", "There are a lot of dusty boxes on the dining table", false);
		items.add(dustyBoxes);
		this.stash = items;
		this.money=fillMoney();	
	}
	public void makeVaultStash()
	{
		ArrayList<Item> items= new ArrayList<Item>();
		Item dustyBoxes = new Item("sword", "An ancient sword lies on the ground", true);
		items.add(dustyBoxes);
		this.stash = items;
		this.money=fillMoney();	
	}
	public void makeParlorStash()
	{
		ArrayList<Item> items= new ArrayList<Item>();
		Item chest = new Item("treasure chest", "A treasure chest lies on the parlor floor. It is locked",false);
		items.add(chest);
		this.stash = items;
		this.money=fillMoney();	
	}
	public void makeSecretRoomStash()
	{
		ArrayList<Item> items= new ArrayList<Item>();
		Item gold = new Item("piles of gold", "piles of gold line the floor",true);
		items.add(gold);
		this.stash = items;
		this.money=2000;	
	}
	public void makeSkullStash()
	{
		this.money = 500;
	}
}
