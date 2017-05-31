//Author:Sayeed Gulmahamad
//BinaryTree
public class BinaryTree {

	private BinaryNode root;
	
	public BinaryTree()  // empty Binary Tree
	{
		root = null;
	}
	
	public BinaryTree(Object x)
	{
		root = new BinaryNode(x);
	}
	
	public boolean isEmpty() // boolean method to return true if the root is null, false if otherwise
	{
		return root == null;
	}
	
	public void makeEmpty() // makes the Binary Tree empty by setting root to null
	{
		root = null;
	}
	
	public int nodeCount()  // counts the number of nodes
	{
		return BinaryNode.nodeCount(root);
	}
	
	public int height()   // returns height
	{
		return BinaryNode.height(root);
	}
	
	// Returns Root
	public Object getRootObj() throws BinaryTreeException  
	{
		if (root == null)
		{
			throw new BinaryTreeException("Empty Tree");
		}
		else
		{
			return root.element;
		}
	}
	
	// Sets the Root
	public void setRootObj(Object x) throws BinaryTreeException
	{
		if (root == null)
		{
			throw new BinaryTreeException("Empty Tree");
		}
		else
		{
			root.element = x;
		}
	}
	
	
	public BinaryTree getLeft()  throws BinaryTreeException
	{
		if (root == null)
		{
			throw new BinaryTreeException("Empty Tree");
		}
		else
		{
			BinaryTree t = new BinaryTree();
			t.root = root.left;
			return t;
		}
	}
	
	public BinaryTree setLeft(BinaryTree t)  throws BinaryTreeException
	{
		if (root == null)
		{
			throw new BinaryTreeException("Empty Tree");
		}
		else
		{
			root.left = t.root;
			return t;
		}
	}
	
	public BinaryTree getRight()  throws BinaryTreeException
	{
		if (root == null)
		{
			throw new BinaryTreeException("Empty Tree");
		}
		else
		{
			BinaryTree t = new BinaryTree();
			t.root = root.right;
			
			return t;
		}
	}
	
	
	public void setRight(BinaryTree t)  throws BinaryTreeException
	{
		if (root == null)
		{
			throw new BinaryTreeException("Empty Tree");
		}
		else
		{
			root.right = t.root;
			
		}
	}
	
	public BinaryNode getRoot() // retrieves the Root
	{
		return root;
	}

	
	public class BinaryTreeException extends Exception {

	public BinaryTreeException(String err)
	   {
		   super(err);
	   }

     }

	// insert method to insert data onto the Tree
	public static BinaryTree insert (BinaryTree t, Object x) throws BinaryTreeException 
	{
		if (t.isEmpty())
		{
			return new BinaryTree(x);
		}
		else
		{
			if (((Integer)t.getRootObj()).intValue() < ((Integer)x).intValue())
			{
				t.setRight(insert(t.getRight(), x));
			}
			else
			{
				t.setLeft(insert(t.getLeft(), x));
			}
		}
		
		return t;
	}
	
	// retrieves the Max
	public static Object findMax(BinaryTree t) throws BinaryTreeException
	{
		if (t.isEmpty())
		{
			return null;
		}
		else
		{
			while (!(t.getRight()).isEmpty())
				t = t.getRight();
			
			return t.getRootObj();
		}
	}
	
	// useful method to search through the Binary Tree
	public static BinaryTree search(BinaryTree t, Object x) throws BinaryTreeException
	{
		if (t.isEmpty())
		{
			return null; // x not found
		}
		else if (((Integer)t.getRootObj()).intValue() == ((Integer)x).intValue())
		{
			return t; // x found in the root of t
		}
		else if (((Integer)t.getRootObj()).intValue() < ((Integer)x).intValue())
		{
			return search(t.getRight(), x);
		}
		else
		{
			return search(t.getLeft(), x);
		}
	}
	
	// method to turn ordinary binary tree into a right-threaded binary tree
	public void right_thread(BinaryNode N, BinaryNode P)
	{
	        if(N == null)
	        {
	            return;
	        }
	        else
	        {
	        	right_thread(N.right, P);
	            
	            if(N.right == null &&  P != null)
	            {
	                N.right = P;
	                N.isThreaded=true;
	            }
	            
	            right_thread(N.left, N);
	        }
	}
	
	// method to get the leftmost node in the binary tree rooted at the input root node
	public BinaryNode leftMostNode(BinaryNode node){
        if(node == null){
            return null;
        }else{
            // move further left if the current node's left is not null
        	while(node.left != null){
                node = node.left;
            }
            return node;
        }
    }
	
	// method to demonstrate non-recursive inorder traversal
	public void nonRecursiveInorder(BinaryNode root){
        
		// start from the root and go to the left-most node
		BinaryNode current = leftMostNode(root);
        
		// now travel using right pointers
        while (current != null)
        {
            // visit the node, and go its successor via its right link
        	System.out.print(" " + current.element);
            
        	// if the right link is a thread, it gives the successor
            // check if node has a right thread
            if(current.isThreaded)
            {
            	current = current.right;
            }                
            else // otherwise it points to a node where you go as left as possible to locate successor.
            {
            	current = leftMostNode(current.right);
            }
        }
        
        System.out.println();
    }
	
	public void printThreads(BinaryNode root)
	{
		       
		System.out.println("Printing the threads in the right threaded binary tree");
		// start from the root and go the left-most node
		BinaryNode current = leftMostNode(root);
		        
		// now travel using right pointers
		while (current != null)
		{
		    
		    // check if node has a right thread
		    if(current.isThreaded)
		    {
		    	System.out.print (" " + current.element + "->" );
		    	current = current.right;
		    	
		    	if (current != null)
		    	{
		    		System.out.print (current.element);
		    	}
		    	
		    }                
		    else // otherwise it points to a node where you go as left as possible to locate successor.
		    {
		    	current = leftMostNode(current.right);
		    }
		}
		        
		System.out.println();
	}
}
