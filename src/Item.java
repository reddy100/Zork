
public class Item {
	private String name;
	private String message;
	private boolean canCarry;
	public Item()
	{
		this.name = "";
		this.message = "";
		this.canCarry = false;
	}
	public Item(String name, String message, boolean canCarry)
	{
		this.name = name;
		this.message = message;
		this.canCarry = canCarry;
	}
	public boolean equals(Item i) 
	 {
		if (i == null) return false;
	    if (i.getClass() != getClass()) return false;
	    if (!name.equals(i.name)) return false;
	    if (!message.equals(i.message)) return false;
	    if (canCarry!=i.canCarry) return false;
	    return true;
	  }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isCanCarry() {
		return canCarry;
	}
	public void setCanCarry(boolean canCarry) {
		this.canCarry = canCarry;
	}
}
