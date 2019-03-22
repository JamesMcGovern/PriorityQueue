
public class Main {
	   public static void main(String [] args) {
	    	LinkedList myList = new LinkedList();
	    	
	    	System.out.println("My Linked List adds new elements and sorts them by priority, using a priority queue, when doing so.");
	    	System.out.println();
	    	System.out.println("The below tests cover searching, removing and changing a tickets priority within the list.");
	    	System.out.println();
	    	System.out.println("There are 4 priorities: ");
	    	System.out.println("Security Issues - 1");
	    	System.out.println("Network Issue - 2");
	    	System.out.println("Software/App Installation - 3");
	    	System.out.println("New Computer Configuration - 4");
	    	System.out.println();
	    	
	    	System.out.println("The head of the list before any additions is: " + myList.getHead());
	    	System.out.println();
	    	
	    	Tickets one = new Tickets(1,"James","Steve", 1);//Creating the tickets.
	    	Tickets two = new Tickets(2,"John","Lewis", 4);
	    	Tickets three = new Tickets(3,"Jack","Mike",2);
	    	Tickets four = new Tickets(4, "Jim", "James", 1);
	    	Tickets five = new Tickets(5, "Shane", "Blake", 3);
	    	
	    	myList.add(one);//Adding the elements to the list.
	    	
	    	myList.add(two);
	    	
	    	myList.add(three);
	    	
	    	myList.add(four);
	    	
	    	myList.add(five);
	    	
	    	if(myList.check()) { //Runs a validation check to ensure the Tickets have valid data.
	    		outSep();
	    		System.out.println("Here is the list in full once all 5 tickets have been added, in order of priority.");
	    		myList.traverse();
	    		outSep();
	    	
	    		System.out.println("The priority method prints out the tickets that have n priority, in this case the highest priority(1)");
	    		System.out.println();
	    		myList.priority(1);
	    		
	    		outSep();
	    		
	    		System.out.println("The contains method checks if the given elements contains 'n' ID. In this case, the first node created contains the ID of 1.");
	    		System.out.println();
	    		System.out.println(myList.contains(myList.get(one),1));
	    		System.out.println("The ID for element at position " + myList.getPos(one) + " is " + myList.get(one).getValue().getID());
	    		outSep();
	    	
	    		System.out.println("The traverse function traverses and prints to console all elements in the list, in order of priority.");
	    		myList.traverse();
	    		outSep();
	    		
	    		System.out.println("The cPrio function changes the priority of an element, thus changing its position in the list.");
	    		System.out.println();
	    		System.out.println("Here i am changing ticket 3's priority to 4, notice the change in the list.");
	    		myList.cPrio(three, 4);
	    		
	    		myList.traverse();
	    		outSep();
	    	
	    		System.out.println("The rPrio function removes the element at the head of the list (element with the highest priority) in order to mark that ticket as complete.");
	    		myList.rPrio();
	    		System.out.println();
	    		
	    		System.out.println("Traversing again to show that the head has been removed.");
	    		myList.traverse();
	    		outSep();;
	    		
		    	System.out.println("I then check to see whats at node 2, then remove that node once discovered.");
		    	System.out.println("The ticket at node 2's ID is " + myList.at(2).getValue().getID());
		    	System.out.println();
	    		
	    		System.out.println("The remove function removes the element at 'n' position of the list. In this case position 2 (baring in mind the position starts at 0 rather than 1).");
	    		myList.remove(2);
	    		System.out.println();
	    		
	    		System.out.println("Traversing again to show that the element at position 2 has been removed.");
	    		myList.traverse();
	    		outSep();
	    		
	    		System.out.println("I then print the ID along with the creator of the ticket.");
	    		System.out.println(one.getID());
	    		System.out.println(one.getCreator());
	    		outSep();
	    		
	    		System.out.println("I then perform the same test with a different element.");
	    		System.out.println(two.getID());
	    		System.out.println(two.getCreator());
	    		outSep();
	    	
	    		System.out.println("Here i'm getting the new head of the list and printings its data.");
	    		System.out.println();
	    		System.out.println("                         ID\tCreator\tOwner\tPriority");
	    		System.out.println();
	    		System.out.println("The head of the list is: " + myList.getHead().getValue().getID() + "\t" + myList.getHead().getValue().getCreator() + "\t" + myList.getHead().getValue().getOwner() + "\t" + myList.getHead().getValue().getPriority());
	    		outSep();
	    		
	    		System.out.println("I finally display the size of the list in its new state.");
	    		System.out.println("The size of the list is: " + myList.size());
	    	}else {//Error message gets printed if ticket details are incorrect.
	    		System.out.println("Please enter a unique ID and/or make sure all priorities are between 1 and 4.");//Input error handling.
	    	}
	    }
   	public static void outSep() {//A separator to make the output look better.
		System.out.println("----------------------------------------------------------------------------------------");
	}
}
