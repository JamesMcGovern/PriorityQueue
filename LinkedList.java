public class LinkedList //This class creates the linked list as well as the functions needed to edit it.
{

    private Node head;//Sets up the head node.
    
    public int size = 0; //This integer grows and shrinks with the size of the list.
    
    public Node getHead() { //Gets the head of the list.
    	return head;
    }
    
    public int size() { //Returns the size of the linked list.
    	return size;
    }
    
    //The following methods are involved with finding specific information from the list.
    
    public int getPos(Tickets value) {//Gets the position of a ticket in the list. Takes a tickets as a param and returns its index.
    	Node n = head;
    	int count = 0;
    	while(n != null && n.getValue().getID() != value.getID()) {//Loops until the ticket has been found.
    		n = n.next;
    		count++;
    	}
    	return count;
    }
    
    public Node get(Tickets value) { //Takes a ticket as a param and returns the ID of that ticket.
    	Node n = head;//n is a container for the node as i don't want to change the head with this method.
        while (n != null && n.getValue().getID() != value.getID()) {//Keeps looping until the ID's match.
        	n = n.next;
        }
    	return n;
    }
    
    public Tickets tickAt(Tickets i) {//This method gets a specific ticket from the list, then returns the location.
    	Node n = head;
    	Tickets ticket = null;//Creates the ticket variable that will be returned.
    	
    	while (n != null && n.getValue() != i) {//Loops until the ticket is found.
    		n = n.next;
    	}
    	
    	ticket = n.getValue();//Gets the ticket at n index of the list.
    	return ticket;
    }
    
    public Node at(int i) { //Takes the param of i index and returns the node at that position.
    	Node n = head;
    	int count = 0;
    	while (n != null) {//Loops until the count gets to i.
    		if(count != i) {
    			count++;
    			} else {
    				return n;//Returns the found node.
    			}
    		n = n.next;
    	}
    	return null;
    }
    
    public void traverse() {//Prints all tickets in the list.
    	Node n = head;
    	System.out.println();
    	System.out.println("ID\tCreator\tOwner\tPriority");//\t Means tab, i'm using this for a more clear output.
    	System.out.println();
    	while (n != null) {
    		System.out.println(n.getValue().getID() + "\t" + n.getValue().getCreator() + "\t" + n.getValue().getOwner() + "\t" + n.getValue().getPriority());//Producing all details about each ticket.
    		n = n.next;
    	}

    }
    
    public boolean contains(Node i,int value) {//Takes a node and a value as params and returns a boolean value if the ID is part of the defined ticket.
    	Node n = head;
    	while (n != null && n.getValue().getID() != value && i != n) {//Loops until the ID's match.
    		n = n.next;
    	}
    	if(n == null) {//If the head doesn't hold an element then false is returned.
    		return false;
    	}
    	return true;
    }
    
    public void priority(int value) {//Takes a priority value and prints all tickets with that priority.
    	Node n = head;
    	System.out.println("ID\tCreator\tOwner\tPriority");//\t Means tab, i'm using this for a more clear output.
    	System.out.println();
    	while (n != null) {
    		if(n.getValue().getPriority() == value) {//If the priority matches then value then print.
    		System.out.println(n.getValue().getID() + "\t" + n.getValue().getCreator() + "\t" + n.getValue().getOwner() + "\t" + n.getValue().getPriority());//Prints the creator of the ticket.
    		}
    		n = n.next;
    	}
    }
    
    //The following methods are involved with adding tickets to the list.
    
    public boolean check() {//Performs a validation check to make sure that the tickets have the correct information.
    	Node n = head;
    	int count = 0;
    	while (n != null && n.getValue().getPriority() >= 1 && n.getValue().getPriority() <= 4) {//Checks that the priority is between 1 and 4.
    		n = n.next;
    		count++;
    		if (count == size) {//Loops until all elements are checked.
    	    	for (int i = 0; i < size-1; i++) { //Basic nested for loop that compares each element in the list.
    	    		   for (int k = i+1; k < size; k++) { 
    	    		      if(at(i).getValue().getID() == at(k).getValue().getID()) {//Checks that the IDs are all unique.
    	    		    	  return false;
    	    		      }   
    	    		   }
    	    	}
    	    	return true;
    		}
    	}
    	return false;
    }
    	

    public void add(Tickets value) {//Takes a ticket as a param and adds it to the linked list in order of priority.
    	
        Node newTick = new Node(value);//Creates the new node.
        Node temp = null;//Creates a temporary container for the required element.
        Node n = head;
        
        while (n != null && value.getPriority() >= n.getValue().getPriority()) {//Loops until the added elements priority is in the correct position.
        	temp = n;
        	n = n.next;
        }    
        if (temp == null) {//If the temp node is null, insert new node into the list.
        	newTick.next = head;
        	head = newTick;
        } else {//If the temp node contains an element, set that next node to the newly created node and so on for the one after.
        	temp.next = newTick;
        	newTick.next = n;
        }
    	size++;
    }
    
    //The following methods are involved with removing/changing tickets in the list.
    
    public void rPrio() { //Removes the node at the top of the list (highest priority).

        if (head == null) {//First check is to see if the list is empty.
        	System.out.println("List is Empty.");
        } else if (head.next == null) {//Next check is to see if the list has one element in it.
        	head = null;
        	size--;
        } else {//final checks if the list has 2+ elements.
        	head = head.next;
        	size--;
        }
    }
    
    public void remove(int i) {//The parameter takes an index and then removes the node at that position.
        int count = 0;
        Node n = head;
        Node temp = null;
        
        while (n != null && count < i) {//Count increases the index count by i and loops until count == i.
            temp = n;
            n = n.next;
            count++;
        }
        
        if (n != null && temp == null) {
            if (n.next != null) {
                head = n.next;//Makes the head of the list equal to the next element to allow removal.
            }
            else {
                head = null;//Moving the list down once one element is removed and set the head to null.
            }
        }
        else if (n != null) {
            temp.next = n.next;//Refreshes the temp.next node.
        }
        size--;
    }
    
    public void remNode(Tickets i) {//The parameter takes the ticket that you want to remove and removes that node.
        Node n = head;
        Node temp = null;
        
        while (n != null && i != n.getValue()) {//Loops until the ticket is found in the list.
            temp = n;
            n = n.next;
        }
        
        if (n != null && temp == null) {
            if (n.next != null) {
                head = n.next;//Makes the head of the list equal to the next element.
            }
            else {
                head = null;//Moving the list down once one element is removed an setting the head to null.
            }
        }
        else if (n != null) {
            temp.next = n.next;//Refreshes the temp.next node.
        }
        size--;
    }
    

    public void cPrio(Tickets i, int prio){//Takes the parameters of the ticket and the new priority then returns the ticket with the new priority to the list.
    	Tickets replace = tickAt(i);//Acts as a temporary container for the ticket.
    	replace.setPriority(prio);//Changes the priority of the ticket.
		
    	remNode(i);//I then remove the ticket from the list and place it back in with the new priority.
		add(replace);
    }
}
