// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


 // } Driver Code Ends

class Solution{
    
    //Function to find minimum adjacent difference in a circular array.
    // arr[]: input array
    // n: size of array
    public static int minAdjDiff(int arr[], int n) {
        
        // Your code here
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++)
            min=Math.min(min,Math.abs(arr[i]-arr[i+1]));
        min=Math.min(min,Math.abs(arr[n-1]-arr[0]));
        return min;
        
    }
}


// { Driver Code Starts.


class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0)//While testcases exist
		{
		    //Input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    
		    //Array of size n
		    int arr[] = new int[n];
		    
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //input elements of array
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.minAdjDiff(arr, n));
		}
	}
}
  // } Driver Code Ends