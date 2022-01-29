// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(inputLine[0]);
		    int n = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(m, n));
		}
	}
}



// } Driver Code Ends


class Solution{
    long factorial(long n,HashMap<Long,Long>hmap)
    {
        if(n<=1)
            return 1;
        if(hmap.containsKey(n))
            return hmap.get(n);
        long temp=factorial(n-1,hmap);
        hmap.put(n,temp*n);
        return temp*n;
    }
    long numberOfPaths(int m, int n) {
        // Code Here
        HashMap<Long,Long>hmap=new HashMap<Long,Long>();
        long num=factorial(m+n-2,hmap);
        long de1=factorial(m-1,hmap);
        long de2=factorial(n-1,hmap);
        return num/(de1*de2);
    }
    
}