// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        if(head==null || head.next==null)
            return head;
        Node zeroh=new Node(0);
        Node oneh=new Node(0);
        Node twoh=new Node(0);
        Node zeroptr=zeroh;
        Node oneptr=oneh;
        Node twoptr=twoh;
        Node ptr=head;
        while(ptr!=null)
        {
            if(ptr.data==0)
            {
                zeroptr.next=ptr;
                ptr=ptr.next;
                zeroptr=zeroptr.next;
                zeroptr.next=null;
            }
            else if(ptr.data==1)
            {
                oneptr.next=ptr;
                ptr=ptr.next;
                oneptr=oneptr.next;
                oneptr.next=null;
            }
            else
            {
                twoptr.next=ptr;
                ptr=ptr.next;
                twoptr=twoptr.next;
                twoptr.next=null;
            }
        }
        if(zeroh.next!=null)
        {
            head = zeroh.next;
            if(oneh.next!=null)
            {
                zeroptr.next=oneh.next;
                if(twoh.next!=null)
                    oneptr.next=twoh.next;
            }
            else if(twoh.next!=null)
                zeroptr.next=twoh.next;
        }
        else if(oneh.next!=null)
        {
            head=oneh.next;
            if(twoh.next!=null)
                oneptr.next=twoh.next;
        }
        else 
            head=twoh.next;
        return head;
    }
}


