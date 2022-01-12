// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int r = Integer.parseInt(inputLine[0]);
            int c = Integer.parseInt(inputLine[1]);
            boolean[][] mat = new boolean[r][c];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = (Integer.parseInt(inputLine[i * c + j]) == 1);
                }
            }

            int ans = new Solution().maxArea(mat, r, c);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public int histogram(int arr[])
    {
        Arrays.sort(arr);
        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        left[0]=-1;
        Stack<Integer>st=new Stack<Integer>();
        st.push(0);
        for(int i=1;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                left[i]=-1;
            else
                left[i]=st.peek();
            st.push(i);
        }
        st.clear();
        right[arr.length-1]=arr.length;
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                right[i]=arr.length;
            else
                right[i]=st.peek();
            st.push(i);
        }
        int max=-1;
        for(int i=0;i<arr.length;i++)
        {
            int area=arr[i]*(right[i]-left[i]-1);
            max=Math.max(max,area);
        }
        return max;
    }
    int maxArea(boolean[][] mat, int r, int c) {
        // code here
        int grid[][]=new int[r+1][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
            {
                if(mat[i][j]==false)
                    grid[i+1][j]=0;
                else
                    grid[i+1][j]=grid[i][j]+1;
            }
        int max=-1;
        for(int i=0;i<r;i++)
            max=Math.max(max,histogram(grid[i+1]));
        return max;
    }
}