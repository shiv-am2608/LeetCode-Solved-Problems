// { Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	    int num=0,i=0;
	    boolean isPositive=true;
	    if(str.charAt(i)=='-')
	    {
	        isPositive=false;
	        i++;
	    }
    	for(;i<str.length();i++)
    	    if(!Character.isDigit(str.charAt(i)))
    	        return -1;
    	    else
    	        num=(num*10)+(str.charAt(i)-'0');
    	return isPositive?num:-1*num;
    }
}
