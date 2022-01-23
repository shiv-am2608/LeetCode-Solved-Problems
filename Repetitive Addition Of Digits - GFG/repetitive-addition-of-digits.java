// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            int ans  = ob.singleDigit(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int singleDigit(long N){
        // code here
        while(N>9)
        {
            long sum=0;
            while(N>0)
            {
                sum+=N%10;
                N=N/10;
            }
            N=sum;
        }
        return (int)N;
    }
}