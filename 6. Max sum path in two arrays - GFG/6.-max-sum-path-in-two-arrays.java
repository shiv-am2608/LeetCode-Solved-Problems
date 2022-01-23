// { Driver Code Starts
import java.util.*;

class ArrPathSum1
{
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		Solution g = new Solution();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}// } Driver Code Ends


class Solution
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int arr1[], int arr2[])
    {
        // Your code here
        int i=0,j=0;
        int sum1=0,sum2=0,sum=0;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                sum1+=arr1[i];
                i++;
            }
            else if(arr1[i]>arr2[j])
            {
                sum2+=arr2[j];
                j++;
            }
            else
            {
                sum+=Math.max(sum1,sum2)+arr1[i];
                sum1=0;
                sum2=0;
                i++;
                j++;
            }
        }
        while(i<arr1.length)
            sum1+=arr1[i++];
        while(j<arr2.length)
            sum2+=arr2[j++];
        sum+=Math.max(sum1,sum2);
        return sum;
    }
}