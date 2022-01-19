// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String ans;
    public void dfs(int start,ArrayList<ArrayList<Integer>>edges,boolean visited[])
    {
        visited[start]=true;
        for(int i:edges.get(start))
            if(!visited[i])
                dfs(i,edges,visited);
        ans=(char)(start+'a')+""+ans;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>>edges=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<K;i++)
            edges.add(new ArrayList<Integer>());
        for(int i=0;i<N-1;i++)
        {
            String word1=dict[i];
            String word2=dict[i+1];
            for(int j=0;j<(int)Math.min(word1.length(),word2.length());j++)
            {
                char x=word1.charAt(j);
                char y=word2.charAt(j);
                if(x!=y)
                {
                    edges.get(x-'a').add(y-'a');
                    break;
                }
            }
        }
        boolean visited[]=new boolean[K];
        ans="";
        for(int i=0;i<K;i++)
            if(!visited[i])
                dfs(i,edges,visited);
        return ans;
        
    }
}