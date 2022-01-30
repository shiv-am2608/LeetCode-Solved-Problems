// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int prefix=0;
        int len=0;
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            prefix+=arr[i];
            if(prefix==0)
                len=Math.max(len,i+1);
            if(hmap.containsKey(prefix))
                len=Math.max(i-hmap.get(prefix),len);
            else
                hmap.put(prefix,i);
        }
        return len;
    }
}