// { Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean solve(int nums[],int k,int end,int target,int currSum,boolean visited[])
    {
        if(k==0)
            return true;
        if(currSum==target)
            return solve(nums,k-1,nums.length-1,target,0,visited);//one subset removed and then reset
        for(int i=end;i>=0;i--)
        {
            if(visited[i])
                continue;
            
            //deals with TC -> [2,2,2,2,2,2]
            if(i+1<nums.length && nums[i]==nums[i+1] && !visited[i+1])
                continue;
            if(currSum+nums[i]>target)
                continue;
            
            //backtracking
            visited[i]=true;
            if(solve(nums,k,i-1,target,currSum+nums[i],visited))
                return true;
            visited[i]=false;
        }
        return false;
        
    }
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	    if(k==1 || k>a.length)
            return true;
        int sum=0;
        for(int i:a)
            sum+=i;
        if(sum%k!=0)
            return false;
        Arrays.sort(a);
        boolean visited[]=new boolean[a.length];
        return solve(a,k,a.length-1,sum/k,0,visited);
    }
}
