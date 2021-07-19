class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer>p=new PriorityQueue<Integer>(Collections.reverseOrder());
        HashSet<Integer>hs=new HashSet<Integer>();
        for(int i:nums)
        {
            if(!hs.contains(i))
                p.add(i);
            hs.add(i);
        }
        int ans=p.poll();
        int third=0,i=0;
        while(i<2)
        {
            if(p.isEmpty())
                return ans;
            third=p.poll();
            i++;
        }
        return third;
    }
}