// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class Bits{
    public static void main(String[] arsg)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            long n=Long.parseLong(br.readLine());
            GfG g=new GfG();
            g.count(n);
        }
    }
}


 // } Driver Code Ends
//User function Template for Java

class GfG{
    public void count(long n){
        // your code here.
        int s=0,ns=0;
        while(n>0)
        {
            if((n&1)==0)
                ns++;
            else
                s++;
            n=n>>1;
        }
        System.out.println(s+" "+ns);
    }
}

// { Driver Code Starts.
  // } Driver Code Ends