/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int count=0;
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        return prev;
    }
    public int[] nextLargerNodes(ListNode head) {
        if(head==null)
            return new int[]{};
        if(head.next==null)
            return new int[]{0};
        head=reverse(head);
        int arr[]=new int[count];
        Stack<Integer>st=new Stack<Integer>();
        ListNode ptr=head;
        arr[count-1]=0;
        st.push(ptr.val);
        ptr=ptr.next;
        int idx=count-2;;
        while(ptr!=null)
        {
            while(!st.isEmpty() && ptr.val>=st.peek())
                st.pop();
            if(st.isEmpty())
                arr[idx--]=0;
            else
                arr[idx--]=st.peek();
            st.push(ptr.val);
            ptr=ptr.next;
        }
        return arr;
    }
}