// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
        


// Solution class to implement function largestAndSecondLargest
class Solution{
    
    // Function to find largest and second largest element in the array
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[])
    {
        //code here.
        int first=-1,second=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>first)
            {
                second=first;
                first=arr[i];
            }
            else if(arr[i]<first && arr[i]>second)
                second=arr[i];
        }
        ArrayList<Integer>ans=new ArrayList<Integer>();
        ans.add(first);
        ans.add(second);
        return ans;
    }
}

// { Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    int arr[] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int index = 0;index < sizeOfArray; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.largestAndSecondLargest(sizeOfArray, arr);
		    System.out.println(res.get(0) + " " + res.get(1) );
		}
	}
}  // } Driver Code Ends