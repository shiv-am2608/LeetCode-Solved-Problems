class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Pair<Integer, Integer>> dq = new LinkedList<>();
        dq.offer(new Pair(0,nums[0]));
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            while(!dq.isEmpty() && dq.peekFirst().getKey()<i-k)
                dq.pollFirst();
            max=nums[i]+(dq.isEmpty()?0:dq.peekFirst().getValue());
            while(!dq.isEmpty() && max>dq.peekLast().getValue())
                dq.pollLast();
            dq.offerLast(new Pair(i,max));
        }
        return max;
    }
}