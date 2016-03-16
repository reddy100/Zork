import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestInventory {
	//Checking default,overloaded constructors, getters and setters
	@Test
	public void testDefaultGetItem() {
		Inventory i = new Inventory();
		assertEquals("Inventory get default stash test: ", i.getStash().size(), 0);
	}
	@Test
	public void testDefaultGetMoney() {
		Inventory i = new Inventory();
		assertEquals("Inventory get default money test: ", i.getMoney(), 0);
	}
	@Test
	public void testDefaultSetItem() {
		Inventory i = new Inventory();
		Item it = new Item();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(it);
		i.setStash(items);
		assertEquals("Inventory set default stash test: ", i.getStash(), items);
	}
	@Test
	public void testDefaultSetMoney() {
		Inventory i = new Inventory();
		i.setMoney(100);
		assertEquals("Inventory set default money test: ", i.getMoney(), 100);
	}
	@Test
	public void testGetItem() {
		Item it = new Item();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(it);
		Inventory i = new Inventory(items, 0);
		assertEquals("Inventory get stash test: ", i.getStash(), items);
	}
	@Test
	public void testGetMoney() {
		Item it = new Item();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(it);
		Inventory i = new Inventory(items, 200);
		assertEquals("Inventory get money test: ", i.getMoney(), 200);
	}
	@Test
	public void testEmptyInventory1()
	{
		Item it = new Item();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(it);
		Inventory i = new Inventory(items, 200);
		i.emptyInventory();
		assertTrue(i.getStash()==null);
	}
	@Test
	public void testEmptyInventory2()
	{
		Item it = new Item();
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(it);
		Inventory i = new Inventory(items, 200);
		i.emptyInventory();
		assertTrue(i.getMoney()==0);
	}
	@Test
	public void testTakeItems()
	{
		Item i = new Item("sword", "picked up sword", true);
		Item j = new Item("bat", "bats fly", false);
		Item k = new Item("spiders", "spider webs everywhere", true);
		Item l = new Item("book", "picked up a book on  finance", true);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);items.add(j);items.add(k);items.add(l);
		Inventory bag = new Inventory(items, 200);
		bag.takeItem(2);
		items.remove(2);
		assertEquals("Inventory take Item test: ", bag.getStash(), items);
	}
	@Test
	public void testAddAllItemsToInventory()
	{
		Item i = new Item("sword", "picked up sword", true);
		Item j = new Item("bat", "bats fly", false);
		Item k = new Item("spiders", "spider webs everywhere", true);
		Item l = new Item("book", "picked up a book on  finance", true);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);items.add(j);items.add(k);items.add(l);
		Inventory bag1 = new Inventory(items, 200);
		Inventory bag2 = new Inventory();
		bag2.addItemsToInventory(bag1);
		assertEquals("Inventory add all items to Inventory test: ", bag2.getStash(), bag1.getStash());
	}
	@Test
	public void testFillMoney()
	{
		int j=Inventory.fillMoney();
		assertTrue(j>=1 && j<=300);
	}
	@Test
	public void testMakeFoyerStash()
	{
		Item i = new Item("a dead scorpion", "You see a dead scorpion", true);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);
		Inventory inv = new Inventory();
		inv.makeFoyerStash();
		assertTrue(inv.getStash().get(0).equals(i));
	}
	@Test
	public void testMakeFrontRoomStash()
	{
		Item i = new Item("a piano", "You see a piano", false);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);
		Inventory inv = new Inventory();
		inv.makeFrontRoomStash();
		assertTrue(inv.getStash().get(0).equals(i));
	}
	@Test
	public void testMakeLibraryStash()
	{
		Item i = new Item("spiders", "Spiders line the bookshelves", true);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);
		Inventory inv = new Inventory();
		inv.makeLibraryStash();
		assertTrue(inv.getStash().get(0).equals(i));
	}
	@Test
	public void testMakeKitchenStash()
	{
		Item i = new Item("bats", "Bats fly out of the kitchen as you walk in", true);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);
		Inventory inv = new Inventory();
		inv.makeKitchenStash();
		assertTrue(inv.getStash().get(0).equals(i));
	}
	@Test
	public void testMakeDiningRoomStash()
	{
		Item i = new Item("dusty boxes", "There are a lot of dusty boxes on the dining table", false);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);
		Inventory inv = new Inventory();
		inv.makeDiningRoomStash();
		assertTrue(inv.getStash().get(0).equals(i));
	}
	@Test
	public void testMakeVaultStash()
	{
		Item i = new Item("a sword", "An ancient sword lies on the ground", true);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);
		Inventory inv = new Inventory();
		inv.makeVaultStash();
		assertTrue(inv.getStash().get(0).equals(i));
	}
	@Test
	public void testMakeParlorStash()
	{
		Item i = new Item("a treasure chest", "A treasure chest lies on the parlor floor. It is locked",false);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);
		Inventory inv = new Inventory();
		inv.makeParlorStash();
		assertTrue(inv.getStash().get(0).equals(i));
	}
	@Test
	public void testMakeSecretRoomStash()
	{
		Item i = new Item("piles of gold", "piles of gold line the floor",true);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(i);
		Inventory inv = new Inventory();
		inv.makeSecretRoomStash();
		assertTrue(inv.getStash().get(0).equals(i));
	}
	@Test
	public void testMakeSkullStashStash()
	{
		Inventory inv = new Inventory();
		inv.makeSkullStash();
		assertEquals(inv.getMoney(), 500);
	}
}