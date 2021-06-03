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
        //checking if head is null
        if(head==null)
            return head;
        //dealing with TC where single node exists
        if(head.next==null)
        {
            Node temp=new Node(head.val);
            if(head.random==head)
                temp.random=temp;
            return temp;
        }
        
        //creating a treemap to maintain the order
        TreeMap<Integer,Node>hmap=new TreeMap<Integer,Node>();
        
        //dealt with first node explicitly
        Node copy=new Node(head.val);
        Node copy_ptr=copy;
        Node ptr=head.next;
        hmap.put(0,head);
        int count=1;
        copy.random=head;
        head.next=copy;
        Node next=ptr.next;
        
        //establishing connections and storing reference of original LL in TreeMap
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
        hmap.put(count,null);//explicitly inserting null value in the end
        
        //connecting random pointers of copy LL 
        ptr=copy;
        while(ptr!=null)
        {
            //dealing with cases where random might be pointing to null directly
            try{
                ptr.random=ptr.random.random.next;  
            }
            catch(Exception e)
            {
                ptr.random=null;
            }
            ptr=ptr.next;
        }
        
        //restoring the real connection of original linkedlist
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