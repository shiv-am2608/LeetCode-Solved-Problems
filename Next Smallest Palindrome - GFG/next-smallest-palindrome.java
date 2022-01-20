// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    Vector<Integer> case1(int arr[],int n)
    {
        int i,c=1;
        for(i=(n-1)/2;i>=0;i--)
        {
            if(arr[i]==9)
                arr[i]=0;
            else
            {
                arr[i]++;
                break;
            }
        }
        Vector<Integer>res=new Vector<Integer>();
        if(i==-1)
            res.add(1);
        for(int j=0;j<(n+1)/2;j++)
            res.add(arr[j]);
        for(int j=(n/2)-1;j>=0;j--)
            res.add(arr[j]);
        if(i==-1)
            res.add(1);
        return res;
    }
    Vector<Integer>case2(int arr[],int n)
    {
        Vector<Integer>res=new Vector<Integer>();
        for(int j=0;j<(n+1)/2;j++)
            res.add(arr[j]);
        for(int j=(n/2)-1;j>=0;j--)
            res.add(arr[j]);
        return res;
    }
    Vector<Integer>case3(int n)
    {
        Vector<Integer>res=new Vector<Integer>();
        res.add(1);
        for(int i=1;i<=n-1;i++)
            res.add(0);
        res.add(1);
        return res;
    }
    Vector<Integer> generateNextPalindrome(int arr[], int n) {
        // code here
        if(n==1 && arr[0]<9)
            return new Vector<Integer>(Arrays.asList(arr[0]+1));
        int x=(n+1)/2;
        boolean allNine=true;
        for(int j=(n/2)-1;j>=0;j--)
        {
            if(arr[j]!=9 || arr[x]!=9)
                allNine=false;
            if(arr[j]>arr[x])
                return case2(arr,n);
            else if(arr[j]<arr[x])
                return case1(arr,n);
            x++;
        }
        if(allNine)
            return case3(n);
        return case1(arr,n);
    }
}