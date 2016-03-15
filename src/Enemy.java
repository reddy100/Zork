
public class Enemy extends Character{

	public Enemy()
	{
		super.name = "";
		super.backPack = new Inventory();
		super.hp = 0;
		super.attack = 0;
		super.currentPos = 0;
	}
	
	public Enemy(String name, Inventory stash, int hp, int attack, int currentPos)
	{
		super.name = name;
		super.backPack = stash;
		super.hp = hp;
		super.attack = attack;
		super.currentPos = currentPos;
	}
	
	
}
