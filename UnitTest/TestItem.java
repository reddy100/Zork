import static org.junit.Assert.*;

import org.junit.Test;

public class TestItem {

	@Test
	public void testGetName() {
		Item i = new Item("sword", "picked up sword", true);
		assertEquals("Item get name test: ", i.getName(), "sword");
	}
	@Test
	public void testGetMessage() {
		Item i = new Item("sword", "picked up sword", true);
		assertEquals("Item get message test: ", i.getMessage(), "picked up sword");
	}
	@Test
	public void testGetCanCarry() {
		Item i = new Item("sword", "picked up sword", true);
		assertTrue(i.isCanCarry());
	}
	@Test
	public void testSetName() {
		Item i = new Item();
		i.setName("dead scorpion");
		assertEquals("Item get name test: ", i.getName(), "dead scorpion");
	}
	@Test
	public void testSetMessage() {
		Item i = new Item();
		i.setMessage("picked up dead scorpion");
		assertEquals("Item get message test: ", i.getMessage(), "picked up dead scorpion");
	}
	@Test
	public void testSetCanCarry() {
		Item i = new Item();
		i.setCanCarry(false);
		assertFalse(i.isCanCarry());
	}
}
