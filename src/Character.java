import java.util.Random;

public class Character {

	protected String name;
	protected Inventory backPack;
	protected int hp;
	protected int attack;
	protected int currentPos;
	
	public int getCurrentPos() {
		return currentPos;
	}
	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Inventory getBackPack() {
		return backPack;
	}
	public void setBackPack(Inventory backPack) {
		this.backPack = backPack;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hP) {
		hp = hP;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int attack()
	{
		Random rand = new Random();
		return this.attack/2+rand.nextInt(this.attack);
	}
	
	public void getDamage(int enemyAttack)
	{
		if(enemyAttack >= this.hp)
		{
			System.out.println("You have died");
			//call report
			System.exit(0);
		}
		else
		{
			this.hp-=enemyAttack;
		}
	}
	
	
}
