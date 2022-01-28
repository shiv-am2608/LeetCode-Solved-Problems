// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends


class Solution
{
    //Function to insert heap.
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    public static void insertHeap(int x)
    {
        // add your code here
        max.add(x);
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
       if(max.size()>min.size()+1)
            min.add(max.poll());
        if(!min.isEmpty()&&max.peek()>min.peek())
        {
            max.add(min.poll());
            min.add(max.poll());
        }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(max.size()==min.size())
            return (double) (max.peek()+min.peek())/2;
        return max.peek();
    }
    
}