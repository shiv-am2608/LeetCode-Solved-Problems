import java.util.*;
import java.lang.*;
import java.io.*;
class Pair{
    int data,freq;
    Pair(int x,int y){
        data=x;
        freq=y;
    }
}
class GFG
 {
	public static void main (String[] args)
	{
	 //code
	    Scanner sc=new Scanner(System.in);
	    int test=sc.nextInt();
	    while(test-->0)
	    {
	        int n=sc.nextInt();
	        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
	        for(int i=0;i<n;i++)
	        {
	            int val=sc.nextInt();
	            if(hmap.containsKey(val))
	                hmap.put(val,hmap.get(val)+1);
	            else
	                hmap.put(val,1);
	        }
	        Pair arr[] =new Pair[hmap.size()];
	        int i=0;
	        for(Map.Entry<Integer,Integer>x:hmap.entrySet())
	            arr[i++]=new Pair(x.getKey(),x.getValue());
	        Arrays.sort(arr,(t1,t2)->(t1.freq-t2.freq)!=0?(t2.freq-t1.freq):(t1.data-t2.data));
	        for(Pair p:arr)
	            for(int j=0;j<p.freq;j++)
	                System.out.print(p.data+" ");
	        System.out.println();
	    }
	    
	    
	}
}