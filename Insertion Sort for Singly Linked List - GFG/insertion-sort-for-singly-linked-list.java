// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node insert(Node head,Node curr)
    {
        Node ptr=head,prev=null;
        while(ptr!=null && ptr.data<curr.data)
        {
            prev=ptr;
            ptr=ptr.next;
        }
        curr.next=ptr;
        if(prev==null)
            return curr;
        prev.next=curr;
        return head;
    }
    public static Node getLast(Node head)
    {
        if(head==null)
            return head;
        Node ptr=head;
        while(ptr.next!=null)
            ptr=ptr.next;
        return ptr;
    }
    public static Node insertionSort(Node head)
    {
        //code here
        if(head==null || head.next==null)
            return head;
        Node prev=head,curr=head.next;
        while(curr!=null)
        {
            Node next=curr.next;
            curr.next=null;
            prev.next=null;
            head=insert(head,curr);
            prev=getLast(head);
            prev.next=next;
            curr=next;
        }
        return head;
    }
}