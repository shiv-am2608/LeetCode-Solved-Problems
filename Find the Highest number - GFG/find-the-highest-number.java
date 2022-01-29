// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>(); 
            for( int i = 0; i < n; i++)
            {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);

        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int findPeakElement(List<Integer> a)
    {
        // Code here
        int low=0,high=a.size()-1;
        while(low<=high)
        {
            int mid=high-(high-low)/2;
            if((mid>0 && a.get(mid-1)<a.get(mid)) && (mid<a.size()-1 && a.get(mid)>a.get(mid+1)))
                return a.get(mid);
            if(mid>0 && a.get(mid)<a.get(mid-1))
                high=mid-1;
            else
                low=mid+1;
        }
        return a.get(a.size()-1);
    }
}