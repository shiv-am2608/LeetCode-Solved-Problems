class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<int[]>((t1,t2)->t2[0]-t1[0]);
        pq.offer(new int[]{nums[0],0});
        int ans=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            while(pq.peek()[1]<i-k)
                pq.poll();
            int temp[]=new int[2];
            temp[0]=pq.peek()[0]+nums[i];
            temp[1]=i;
            pq.offer(temp);
            if(i==nums.length-1)
                ans=temp[0];
        }
        return ans;
    }
}