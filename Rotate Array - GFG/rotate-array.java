import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    public static void reverse(int arr[],int i,int j)
    {
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public static void print(int arr[])
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	public static void main (String[] args)
	{
	 //code
	    Scanner sc=new Scanner(System.in);
	    int test=sc.nextInt();
	    while(test-->0)
	    {
	        int n=sc.nextInt();
	        int k=sc.nextInt();
	        int arr[]=new int[n];
	        for(int i=0;i<n;i++)
	            arr[i]=sc.nextInt();
	        reverse(arr,0,k-1);
	        reverse(arr,k,n-1);
	        reverse(arr,0,n-1);
	        print(arr);
	    }
	}
}