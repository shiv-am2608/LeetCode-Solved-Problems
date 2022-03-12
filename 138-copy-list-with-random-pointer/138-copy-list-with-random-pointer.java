/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node curr=head;
        while(curr!=null)
        {
            Node temp=new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            curr=temp.next;
        }
        curr=head;
        while(curr!=null)
        {
            if(curr.random!=null)
                curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        curr=head;
        Node temp=head.next;
        Node h2=temp;
        while(temp.next!=null)
        {
            curr.next=curr.next.next;
            temp.next=temp.next.next;
            curr=curr.next;
            temp=temp.next;
        }
        curr.next=null;
        return h2;
    }
}