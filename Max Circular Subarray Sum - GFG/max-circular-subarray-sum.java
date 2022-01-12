// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int kadane(int arr[])
    {
        int sum=arr[0],ans=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            sum=Math.max(sum+arr[i],arr[i]);
            ans=Math.max(ans,sum);
        }
        return ans;
    }
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        int normalSum=kadane(a);
        if(normalSum<0)
            return normalSum;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=a[i];
            a[i]=-a[i];
        }
        int circularSum=sum+kadane(a);
        return Math.max(circularSum,normalSum);
        
    }
    
}

