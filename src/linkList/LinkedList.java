package linkList;
class Node {
	 
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
    Node() {
    	data = -1;
    	next = null;
    }
    public int length(Node node){
    	
    	int i=0;
    	Node curr=node;
    	
    	while (curr !=null){
    		i++;
    		curr=curr.next;
    	}
    	return i;
    }
}
class LinkedList {
	Node head;
    /* Function to reverse the linked list */
	LinkedList() {
		head = null;
	}
	LinkedList(int[] arr) {
		int size = arr.length;
		int i=0;
		Node prev = null;
		Node curr;
		
		while(i < size) {
			curr = new Node(arr[i]);
			if(prev != null)
				prev.next = curr;
			else
				head = curr;
			prev=curr;
			i++;
			
		}
		
        
	}
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
    int carry;
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "-> ");
            node = node.next;
        }
    }
    public Node addSameLen(Node l1, Node l2){
    	
    	if(l1 == null)
    		return l2;
    	
    	int sum;
    	Node res= new Node();
    	res.next = addSameLen(l1.next,l2.next);
    	
    	sum = l1.data+ l2.data+carry;
    	carry = sum/10;
    	sum=sum%10;
    	res.data=sum;
    	// System.out.println("The Sum is " + sum + "  :"+ res.data);
    	
    	
    	return res;
    }
    public Node addtoRem(Node l1,Node res,Node tmp) {
    	if(l1 == tmp)
    		return res;
    	
    	int sum;
    	Node sol = new Node();
    	sol.next = addtoRem(l1.next,res,tmp);
    	sum = carry+l1.data;
    	carry = sum/10;
    	sum=sum%10;
    	sol.data = sum;
    	return sol;
    	
    }
public Node add(Node l1, Node l2){
    	int len1 = l1.length(l1);
    	int len2 = l2.length(l2);
    	int diff=0;
    	Node tmp,res;
    	if (len1 > len2) {
    		diff = len1-len2;
    	} else if (len1 < len2 ){
    		diff = len2-len1;
    		tmp = l1;
    		l1=l2;
    		l2=tmp;
    	}
    	if(diff > 0) {
    		int i = diff;
    		tmp=l1;
    		while(i>0) {
    			tmp=tmp.next;
    			i--;
    		}
    		res = addSameLen(tmp,l2);
    		res = addtoRem(l1,res,tmp);
    		
    		
    	} else {
    		res = addSameLen(l1,l2);
    	}
    	
    	if(carry >0) {
    		Node c = new Node(carry);
    		c.next = res;
    		return c;
    	}
    	
    	return res;
    }
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5,4,6,7};
    	int[] arr2 = {5,8,3,3};
        LinkedList list = new LinkedList(arr);
        LinkedList list2 = new LinkedList(arr2);
        System.out.println("");
        System.out.println("Original Linked list1 is :");
        list.printList(list.head);
        /*list.head = list.recReverse(list.head);
        System.out.println("");
        System.out.println("Reversed linked list : ");
        list.printList(list.head);
          */
        System.out.println("");
        System.out.println("Original Linked list2 is :");
        list2.printList(list2.head);
        /*
        list2.head = list.recReverse(list2.head);
        System.out.println("");
        System.out.println("Reversed linked list : ");
        list2.printList(list2.head);*/
        LinkedList sum = new LinkedList();
        sum.head = sum.add(list.head,list2.head);System.out.println("");
        System.out.println("Sum Linked list : ");
        sum.printList(sum.head);
        
        
    }
}