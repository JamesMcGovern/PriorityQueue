public class Node{ //This class turns the ticket into a node for the linked list.

        public Tickets data;
        public Node next;

        public Node(Tickets x) { //Creates the new node.
            data = x;
        }
        
        public Tickets getValue() {//Allows the retrieval of data from the ticket.
        	return data;
        }
        
        public Node getNext() {//Method to get the next node in the list.
        	return next;
        }
}