class TrieNode
{
    TrieNode children[];
    TrieNode()
    {
        children =new TrieNode[2];
    }
}
class Solution {
    public TrieNode insertArray(int arr[])
    {
        TrieNode root=new TrieNode();
        for(int x:arr)
        {
            TrieNode curr=root;
            for(int i=31;i>=0;i--)
            {
                int currDigit=(x>>i)&1;
                if(curr.children[currDigit]==null)
                    curr.children[currDigit]=new TrieNode();
                curr=curr.children[currDigit];
            }
        }
        return root;
    }
    public int findMax(TrieNode root,int arr[])
    {
        int max=0;
        for(int x:arr)
        {
            TrieNode curr=root;
            int ans=0;
            for(int i=31;i>=0;i--)
            {
                int reqDigit= 1-((x>>i)&1);
                if(curr.children[reqDigit]!=null)
                {
                    ans = ans| (1<<i);
                    curr=curr.children[reqDigit];
                }
                else
                    curr=curr.children[1-reqDigit];
            }
            max=Math.max(max,ans);
        }
        return max;
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root=insertArray(nums);
        return findMax(root,nums);
    }
}