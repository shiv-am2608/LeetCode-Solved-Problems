import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc=new Scanner(System.in);
    	 int test=sc.nextInt();
    	 while(test-->0)
    	 {
    	     int a=sc.nextInt();
    	     int b=sc.nextInt();
    	     int c=sc.nextInt();
    	     int n=sc.nextInt();
    	     int sum=a+b+c;
    	     for(int i=4;i<n;i++)
    	     {
    	         int temp=sum;
    	         sum=sum+b+c;
                a=b;
                b=c;
                c=temp;
    	     }
    	        System.out.println(sum);
    	 }
	 }
}