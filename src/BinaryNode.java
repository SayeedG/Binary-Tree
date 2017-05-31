//Author:Sayeed Gulmahamad
//BinaryNode
public class BinaryNode {
	Object element; // Friendly data accessible by any class in the same package
	BinaryNode left, right; 
	
	// (Flag Variable) Used to indicate whether the right pointer is a normal
    // right pointer or a pointer to inorder successor.
    boolean isThreaded;
	
	BinaryNode()
	{
		element = null;
	}
	
	BinaryNode(Object e){
		this(e, null, null);
	}
	
	BinaryNode(Object e, BinaryNode ln, BinaryNode rn){
		element = e;
		left = ln;
		right = rn;
	}
	
	// methods associated with the class, and not any instance
	static int nodeCount(BinaryNode n)  //counts nodes
	{
		if (n == null)
			return 0;
		else
			return 1 + nodeCount(n.left) + nodeCount(n.right);
	}
	
	static int height(BinaryNode n)    // returns height
	{
		if (n == null)
		{
			return -1;			
		}
		else
		{
			return 1 + Math.max(height(n.left), height(n.right));
		}
	}
	
	
}


