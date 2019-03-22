
public class Tickets {//This class sets up the variables for each ticket that's made.
	private int ID;
	private String creator;
	private String owner;
	private int priority;
	
	public Tickets(int n, String j, String k, int i) {//The method called when a new ticket is created.
		ID = n;
		creator = j;
		owner = k;
		priority = i;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getCreator() {
		return creator;
	}

	public String getOwner() {
		return owner;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int i) {//Sets a new priority.
		priority = i;
	}
}