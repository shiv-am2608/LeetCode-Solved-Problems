// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    String list[] = new String[n];
                    for(int i = 0;i<n;i++)
                        list[i] = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.countWords(list, n));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countWords(String list[], int n)
    {
        // code here 
        HashMap<String,Integer>hmap=new HashMap<String,Integer>();
        for(String x:list)
        {
            if(hmap.containsKey(x))
                hmap.put(x,hmap.get(x)+1);
            else
                hmap.put(x,1);
        }
        int count=0;
        for(Map.Entry<String,Integer>t:hmap.entrySet())
            if(t.getValue()==2)
                count++;
        return count;
    }
}