//Author:Sayeed Gulmahamad
//Project2
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
				// The name of the file to open.
		        String fileName = "";

		        
		        if (args.length != 1)
		        {
		        	System.out.println("Please pass the file name as a commandline paramater");
		        	return;
		        }
		       
		        fileName = args[0];
		        
		        // This will reference one line at a time
		        String line = null;
		        String prevLine = null;

		        try {
		            // FileReader reads text files in the default encoding.
		            FileReader fileReader = 
		                new FileReader(fileName);

		            //  wraps FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);
		            
		            while((line = bufferedReader.readLine()) != null) {
		            
		            	System.out.println("************************************************");
		            	System.out.println(line);
		            	 // split the read line based on a blank space 
		            	String[] numbers = line.split(" ");
		                
		            	BinaryTree bst = new BinaryTree();
		            	
		                for (int i = 0; i < numbers.length; i++)
		                {
		                	
		                		             
		                	bst = BinaryTree.insert(bst, Integer.parseInt( numbers[i]));
		                }
		                
		                System.out.println("Right Threading the Binary Search Tree");
		                bst.right_thread(bst.getRoot(), null);
		                bst.printThreads(bst.getRoot());
		                System.out.println("Printing the non-recursive inorder traversal of the right threaded binary search tree");
		                bst.nonRecursiveInorder(bst.getRoot());
		            
		            }
		            
		            
		            // Always close files.
		            bufferedReader.close();         
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + 
		                fileName + "'");                
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + fileName + "'");                  
		           
		        } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    
		           
	}

}
