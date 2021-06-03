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
            return head;
        if(head.next==null)
        {
            Node temp=new Node(head.val);
            if(head.random==head)
                temp.random=temp;
            return temp;
        }
        TreeMap<Integer,Node>hmap=new TreeMap<Integer,Node>();
        Node copy=new Node(head.val);
        Node copy_ptr=copy;
        Node ptr=head.next;
        hmap.put(0,head);
        int count=1;
        copy.random=head;
        head.next=copy;
        Node next=ptr.next;
        while(ptr!=null)
        {
            Node temp=new Node(ptr.val);
            copy_ptr.next=temp;
            copy_ptr=copy_ptr.next;
            copy_ptr.random=ptr;
            hmap.put(count,ptr);
            ptr.next=temp;
            count++;
            ptr=next;
            if(next==null)
                break;
            next=next.next;
        }
        hmap.put(count,null);
        //Node check=head;
        // while(check!=null)
        // {
        //     System.out.println(check.val+" "+" "+check.next.val);
        //     check=check.next;
        // }
        ptr=copy;
        while(ptr!=null)
        {
            try{
                ptr.random=ptr.random.random.next;
            }
            catch(Exception e)
            {
                ptr.random=null;
            }
            ptr=ptr.next;
        }
        ptr=head;
        for(Map.Entry<Integer,Node>temp:hmap.entrySet())
        {
            if(temp.getKey()==0)
                continue;
            ptr.next=temp.getValue();
            ptr=ptr.next;
        }
        return copy;
        
    }
}