// { Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}
// } Driver Code Ends


class GfG
{
    int max_sum(int arr[], int n)
    {
	// Your code here
	    int sum=0;
	    for(int i:arr)
	        sum+=i;
	    int prod=0;
	    for(int i=0;i<n;i++)
	        prod+=i*arr[i];
	   int ans=prod;
	   for(int i=0;i<n-1;i++)
	   {
	       prod=prod-(sum-arr[i])+(arr[i]*(n-1));
	       ans=Math.max(ans,prod);
	   }
	   return ans;
    }	
}
