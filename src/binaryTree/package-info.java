/**
 * 
 */
/**
 * @author labuser
 *
 */
package binaryTree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

class Node {
	 
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = right = null;
    }
}
 
// An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
class Res {
    public int val;
}

class QItem
{
   Node node;
   int hd;
   public QItem(Node n, int h)
   {
        node = n;
        hd = h;
   }
}
class BinaryTree {
 
    // Root of the Binary Tree
    Node root;
    int maxlevel=0;
    static int preIndex = 0;
    static int postIndex = 0;
    // This function returns overall maximum path sum in 'res'
    // And returns max path sum going through root.
    int findMaxUtil(Node node, Res res)
    {
 
        if(node == null)
        	return 0;
        int l = findMaxUtil(node.left,res);
        int r = findMaxUtil(node.right,res);
        
        int maxSingle = Math.max(Math.max(l, r) + node.data, node.data);
        
        int maxTop =  Math.max(maxSingle,l+r+node.data);
        
        res.val = Math.max(res.val, maxTop);
        return maxSingle;
    }
 
    Node lca(Node root, int a,int b) {
    	if(root == null)
    		return root;
    	if (root.data < a && root.data < b)
    		return lca(root.right,a,b);
    	if (root.data > a && root.data > b)
    		return lca(root.left,a,b);
    	return root;
    }
    int findMaxSum() {
        return findMaxSum(root);
    }
 
    // Returns maximum path sum in tree with given root
    int findMaxSum(Node node) {
 
        // Initialize result
        // int res2 = Integer.MIN_VALUE;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
 
        // Compute and return result
        findMaxUtil(node, res);
        return res.val;
    }
    void printLeaves(Node node) {
    	if (node== null)
    		return;
    	if(node.left != null)
    		printLeaves(node.left);
    	if(node.right != null)
    		printLeaves(node.right);
    	
    	if (node.left==null && node.right == null)
    		System.out.println("  " + node.data);
    	
    }
    void levelOrder() {
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		Node curr = queue.poll();
    		System.out.print(curr.data+ "   ");
    		if (curr.left != null)
    			queue.add(curr.left);
    		if (curr.right != null)
    			queue.add(curr.right);
       	}
    	
    }
    int height(Node root) {
    	if (root == null)
    		return 0;
    	int lh=0,rh=0;
    	
    	if(root.left != null)
    		lh  = height(root.left);
    	if(root.right != null)
    		rh  = height(root.right);
    	return Math.max(lh, rh) + 1;
    }
    void revLevelOrder() {
    	Queue<Node> queue = new LinkedList<Node>();
    	Stack<Integer> st = new Stack<Integer>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		Node curr = queue.poll();
    		st.push(curr.data);
    		//System.out.print(curr.data+ "   ");
    		if (curr.left != null)
    			queue.add(curr.left);
    		if (curr.right != null)
    			queue.add(curr.right);
       	
    	}
    	while(!st.isEmpty()) {
    		int tmp = st.pop();
    		System.out.print(tmp + " ");
    		
    	}
    	
    }
    /*
     * Print Each Level in new line
     */
    void levelbylevel() {
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	int height = height(root);
    	int flag = 0;
    	//System.out.println("Height of the tree is " + height);
    	queue.add(root);
    	while(true) {
    		int nodeCount = queue.size();
    		if (nodeCount == 0 )
    			break;
    		else {
    			/*
    			 * Just beautification
    			 */
    			if(flag == 0) {
    				flag =1;
    			}else {
    				System.out.println("");
    				/*System.out.println("");
    				System.out.println("");*/
    			}
    		}
    		int sp = height--;
    		while(sp> 0) {
    			System.out.print("  ");
    			sp--;
    		}
    		/*
			 * Beautification ends here
			 */
    		while (nodeCount > 0) {
    			Node curr = queue.poll();
    			
    			System.out.print(curr.data+ "  ");
        		if (curr.left != null)
        			queue.add(curr.left);
        		if (curr.right != null)
        			queue.add(curr.right);
        		nodeCount--;
    		}	
    		
    	}
    	
    }
    
    void leftView(Node root, int curr) {
    	if (root == null)
    		return;
    	if(curr > maxlevel) {
    		System.out.println(root.data);
    		maxlevel=curr;
    	} 
    	leftView(root.left,curr+1);
    	leftView(root.right,curr+1);
    	
    	return;
    }
    void rightView(Node root, int curr) {
    	if (root == null)
    		return;
    	if(curr > maxlevel) {
    		System.out.println(root.data);
    		maxlevel=curr;
    	}  
    	rightView(root.right,curr+1);
    	rightView(root.left,curr+1);
    	
    	
    	return;
    }
    int getRangeCount(Node node, int lo, int hi) {
    	if (node == null)
    		return 0;
    	if (node.data ==lo && node.data == hi) {
    		return 1;
    	}
    	
    	if (node.data <= hi &&node.data >= lo) {
    		return 1 + getRangeCount(node.left,lo,hi) + getRangeCount(node.right,lo,hi);
    		
    	}
    	else if (node.data < lo) {
    		return getRangeCount(node.right,lo,hi);
    		
    	}
    	else 
    		return getRangeCount(node.left,lo,hi);
    		
    	
    }
    void topView(Node root) {
    	if (root == null)
    		return;
    	
    	
    	 HashSet<Integer> set = new HashSet<>();
    	 
         // Create a queue and add root to it
         Queue<QItem> queue = new LinkedList<QItem>();
         queue.add(new QItem(root, 0)); // Horizontal distance of root is 0
         
         while(!queue.isEmpty()) {
     		QItem q = queue.poll();
     		Node curr = q.node;
     		int hd = q.hd;
     		
     		if (!set.contains(hd)) {
     			set.add(hd);
     			System.out.print(curr.data+ "   ");
     		}
     		;
     		if (curr.left != null)
     			queue.add(new QItem(curr.left,hd-1));
     		if (curr.right != null)
     			queue.add(new QItem(curr.right,hd+1));
        	}
    }
    void bottommiew(Node root) {
    	if (root == null)
    		return;
    	
    	Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
    	 
         // Create a queue and add root to it
         Queue<QItem> queue = new LinkedList<QItem>();
         queue.add(new QItem(root, 0)); // Horizontal distance of root is 0
         
         while(!queue.isEmpty()) {
     		QItem q = queue.poll();
     		Node curr = q.node;
     		int hd = q.hd;
     		
     		map.put(hd, curr.data);
     		
     		if (curr.left != null)
     			queue.add(new QItem(curr.left,hd-1));
     		if (curr.right != null)
     			queue.add(new QItem(curr.right,hd+1));
        	}
         
         Set<Entry<Integer,Integer>> set = map.entrySet();
         Iterator<Entry<Integer,Integer>> it = set.iterator();
         System.out.println("BOttom View is ");
         while (it.hasNext()) {
        	 Map.Entry<Integer,Integer> me = it.next();
        	 System.out.print(me.getValue() + "   ");
         }
    }
    public Node toDLinkList(Node root) {
    	
    	if (root==null)
    		return root;

    	if(root.left != null) {
    		Node left = toDLinkList(root.left);
    		for(;left.right != null;left = left.right);
    		
    		left.right = root;
    		root.left= left;
    	}
    	if(root.right != null) {
    		Node right = toDLinkList(root.right);
    		for(;right.left != null;right = right.left);
    		
    		right.left = root;
    		root.right= right;
    	}
    	return root;
    }
    public Node binTreetoDll(Node root) {
    	if (root == null)
    		return root;
    	Node node = toDLinkList(root);
    	
    	while (node.left != null)
    		node = node.left;
    	return node;
    }
    public Node arraytoBinTree(int[] arr, int s, int e) {
    	if (s > e)
    		return null;
    	int mid = (s+e)/2;
    	Node node = new Node(arr[mid]);
    	node.left = arraytoBinTree(arr,s,mid-1);
    	node.right = arraytoBinTree(arr,mid+1,e);
    	
    	return node;
    	
    	
    }
    public void printLevel(Node node, int n,int flag) {
    	if (node == null)
    		return;
    	if(n == 1)
    		System.out.print(node.data + "   ");
    	else if(n> 1) {
    		if (flag == 1) {
    			printLevel(node.left,n-1,flag);
    			printLevel(node.right,n-1,flag);
    		} else {
    			printLevel(node.right,n-1,flag);
    			printLevel(node.left,n-1,flag);
    		}
    		
    	}
    		
    }
    public Node createInPre(int[]in,int[]pre,int s, int e) {
    	
    	if(s > e)
    		return null;
    	Node root = new Node(pre[preIndex++]);
    	if(s == e)
    		return root;
    	
    	int inIndex= search(in,s,e,root.data);
    	
    	root.left = createInPre(in,pre,s,inIndex-1);
    	root.right = createInPre(in,pre,inIndex+1,e);
    	return root;
    }
    public int diameter(Node node){
    	if(node == null)
    		return 0;
    	int lh = height(node.left);
    	int rh = height(node.right);
    	
    	int leftD = diameter(node.left);
    	int rightD = diameter(node.right);
    	
    	return Math.max(lh+rh+1,  Math.max(leftD,rightD));
    	
    }
 public Node createInPost(int[]in,int[]post,int s, int e) {
    	
    	if(s > e || postIndex < 0)
    		return null;
    	System.out.println("  " + postIndex+ "  ");
    	Node root = new Node(post[postIndex--]);
    	if(s == e)
    		return root;
    	
    	int inIndex= search(in,s,e,root.data);
    	
    	
    	root.right = createInPost(in,post,inIndex+1,e);
    	root.left = createInPost(in,post,s,inIndex-1);
    	return root;
    }
    private int search(int[]ar, int s,int e, int key){
    	int i;
    	for(i = s;i<= e;i++) {
    		if(ar[i] == key)
    			return i;
    	}
    	return i;
    }
    public void preOrder(Node root) {
    	if (root == null)
    		return;
    	System.out.print("   " + root.data);
    	preOrder(root.left);
    	preOrder(root.right);
    }
    public void postOrder(Node root) {
    	if (root == null)
    		return;
    	
    	preOrder(root.left);
    	preOrder(root.right);
    	System.out.print("   " + root.data);
    }
    static void printList(Node node) {
    	 while (node != null) {
    		 System.out.print(node.data + " ");
             node = node.right;
    	 }
    	 
    }
    public void printLeft(Node node) {
    	if (node == null)
    		return;
    	if(node.left != null) {
    		System.out.println(node.data);
    		printLeft(node.left);
    	} else if(node.right != null) {
    		System.out.println(node.data);
    		printLeft(node.right);
    	}
    	  	
    }
    private void printPath(Node node,int[] arr,int index){
    	if(node == null)
    		return;
    	arr[index]=node.data;
    	//index++;
    	if(node.left == null && node.right==null)
    		printArr(arr,index);
    	else {
    		printPath(node.left,arr,index+1);
    		printPath(node.right,arr,index +1);
    	}
    }
    
    private void printArr(int[] arr,int size){
    	int i=0;
    	while(i <= size) {
    		System.out.print(arr[i] + "  ");
    		i++;
    	}
    	System.out.println("  ");
    	
    	
    }
    public void printPaths(Node node) {
    	int[] arr = new int[1000];
    	
    	printPath(node,arr,0);
    }
    
    public void printRight(Node node) {
    	if (node == null)
    		return;
    	if(node.right != null) {
    		System.out.println(node.data);
    		printRight(node.right);
    	} else if(node.left != null) {
    		System.out.println(node.data);
    		printLeft(node.left);
    	}
    	  	
    }
    public Node createMirror(Node t2) {
    	if(t2 == null)
    		return null;
    	
    	Node node = new Node(t2.data);
    	node.left = createMirror(t2.right);
    	node.right = createMirror(t2.left);
    	
    	return node;
    	
    	
    }
    Node prev;
    public boolean isBst2(Node node) {
    	if(node != null) {
    		if(!isBst2(node.left))
    			return false;
    		
    		if(prev!=null && node.data < prev.data)
    			return false;
    		prev=node;
    		return isBst2(node.right);
    	}
    	return true;
    		
    	
    }
    public boolean isBst(Node node,int min, int max) {
    	if(node == null)
    		return true;
    	
    	if(node.data < min || node.data > max)
    		return false;
    	return (isBst(node.left,min,node.data-1) && isBst(node.right,node.data+1,max));
    	
    }
    static boolean checkMirror(Node t1,Node t2) {
    	if (t1 == null && t2 == null)
    		return true;
    	if(t1 != null && t2!= null && t1.data == t2.data)
    		return checkMirror(t1.left,t2.right) && checkMirror(t1.right,t2.left);
    		
    	
    return false;
    }
    public boolean isBalance(Node node) {
    	if(node == null)
    		return true;
    	int lh = height(node.left);
    	int rh = height(node.right);
    	
    	if ( (Math.abs(lh-rh) <=1) && isBalance(node.left) &&isBalance(node.right))
    		return true;
    	return false;
    	
    }
    /* Driver program to test above functions */
    public static void main(String args[]) {
    	
    	int [] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        
        tree.root.left = new Node(20);
        tree.root.right = new Node(  25);
        
        tree.root.left.left = new Node(30);
        tree.root.left.right = new Node(33);
        tree.root.right.right = new Node(38);
        tree.root.right.left = new Node(35);
        
        tree.root.left.left.left = new Node(41);
        tree.root.left.left.right = new Node(42);
        tree.root.left.right.left = new Node(43);
        tree.root.left.right.right = new Node(44);
        
        tree.root.right.left.left = new Node(45);
        tree.root.right.left.right = new Node(46);
        tree.root.right.right.left = new Node(47);
        tree.root.right.right.right = new Node(48);
        tree.root.right.right.right.right = new Node(148);
        tree.root.right.right.right.right.right = new Node(248);
        
       
        System.out.println("maximum path sum is : " +
                            tree.findMaxSum());
        if( tree.isBst(tree.root, Integer.MIN_VALUE,Integer.MAX_VALUE))
        		System.out.println("Tree is Bst");
        else
        	System.out.println("Tree is not Bst");
        	
        if( tree.isBst2(tree.root))
    		System.out.println("Tree is Bst");
        else
    	System.out.println("Tree is not Bst");
        
        System.out.println("Level Order Traversal of Tree");
        tree.levelOrder();
        System.out.println("Rev Level Order Traversal of Tree");
        tree.revLevelOrder();
        System.out.println("Level by Level Traversal of Tree");
        tree.levelbylevel();
        System.out.println("\nLeft View of Tree");
        tree.leftView(tree.root, 1);
        tree.maxlevel=0;
        System.out.println("Right View of Tree");
        tree.rightView(tree.root, 1);
        System.out.println("Top View of Tree");
        tree.topView(tree.root);
        System.out.println("\nList Converted View of Tree");
        Node list = tree.binTreetoDll(tree.root);
        printList(list);
        System.out.println("\nLevel by Level Traversal of Tree");
        
        tree.root=  tree.arraytoBinTree(arr, 0, arr.length-1);
        tree.levelbylevel();
        System.out.println("Node between range 8 and 14 are:" + tree.getRangeCount(tree.root,8,14));
        System.out.println("LCA of  8 and 14 is" + tree.lca(tree.root, 2, 16).data);
        System.out.println("PreOrder is:");
        tree.preOrder(tree.root);
        int[] in = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] pre = { 8,   4,   2,   1,   3,   6,   5,   7,   12,   10,   9,   11,   14,   13, 15};
        BinaryTree t2 = new BinaryTree();
        t2.root = t2.createInPre(in,pre,0,in.length-1);
    System.out.println("\nLevel by Level Traversal of Tree");
    t2.levelbylevel();
    System.out.println("PostOrder is:");
    tree.postOrder(tree.root);
    if( tree.isBst(t2.root, Integer.MIN_VALUE,Integer.MAX_VALUE))
		System.out.println("Tree is Bst");
    else
    	System.out.println("Tree is not Bst");
    if( tree.isBst2(t2.root))
		System.out.println("Tree is Bst");
    else
    	System.out.println("Tree is not Bst");
    
    int[] post = {4,2,1,3,6,5,7,12,10,9,11,14,13,15,8};
    BinaryTree t3 = new BinaryTree();
    postIndex=post.length -1;
    t3.root = t3.createInPost(in,post,0,in.length-1);
    System.out.println("\nLevel by Level Traversal of Tree");
    t3.levelbylevel();
    
    BinaryTree mirror =new BinaryTree();
    mirror.root = mirror.createMirror(t2.root);
    System.out.println("\nLevel by Level Traversal of Tree");
    mirror.levelbylevel();
    
    if( checkMirror(t2.root,mirror.root) == true)
    	System.out.println("Mirror tree");	
    else
    	System.out.println("No Mirror tree");
    tree.levelbylevel();
    tree.printPaths(tree.root);
    System.out.println("\nLeaves of the tree are"); 
   
    tree.printLeaves(tree.root);
   
    tree.printLeft(tree.root.left);
    tree.printRight(tree.root.right);
    tree.bottommiew(tree.root);   
    System.out.println("\nPrinting Level of the tree in SPiral are");
    tree.printLevel(tree.root, 1,1);
    tree.printLevel(tree.root, 2,0);
    tree.printLevel(tree.root, 3,1);
    tree.printLevel(tree.root, 4,0); 
    System.out.println("\nMax Diameter is: " + tree.diameter(tree.root   ));
    
    if(tree.isBalance(tree.root))
    	System.out.println("It is balanced");
    else
    	System.out.println("It is not  balanced");
    
   
    }
    
}
