package linkList;

class LinkedList {
	 
    static Node head;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
 
    Node recReverse(Node node) {
        if (node == null)
        	return null;
        if (node.next == null)
        	return node;
        
        Node secNode = node.next;
        node.next =null;
        
        Node rest = recReverse(secNode);
        
        secNode.next=node;
        
        return rest;
           
    }
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
    
         
        System.out.println("Original Linked list is :");
        list.printList(head);
        head = list.recReverse(head);
        System.out.println("");
        System.out.println("Reversed linked list : ");
        list.printList(head);
    }
}