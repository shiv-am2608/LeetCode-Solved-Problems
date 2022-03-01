// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Array {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//taking testcases
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    //input size of Array
		    int sizeOfArray=sc.nextInt();
		    
		    int arr[]=new int[sizeOfArray];
		    
		    //inserting elements in the array
		    for(int i=0;i<sizeOfArray-1;i++)
		    {
		        int x;
		        x=sc.nextInt();
		        arr[i]=x;
		    }
		    
		    //input element to be inserted
		    int element=sc.nextInt();
		    
		    Insert obj=new Insert();
		    
		    //calling insertAtEnd() function
		    obj.insertAtEnd(arr,sizeOfArray,element);
		    
		    //printing the elements of the array
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        System.out.print(arr[i]+" ");
		        
		    }
		    
		    System.out.println();
		}
	}
}



 // } Driver Code Ends
//User function Template for Java

class Insert
{
    // You only need to insert the given element at 
    // the end, i.e., at index sizeOfArray - 1. You may 
    // assume that the array already has sizeOfArray - 1
    // elements. 
    public void insertAtEnd(int arr[],int sizeOfArray,int element)
    {
        //Your code here
        arr[arr.length-1]=element;
    }
}

// { Driver Code Starts.

  // } Driver Code Ends