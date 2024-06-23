class Solution {
    public int longestSubarray(int[] nums, int limit) {
     PriorityQueue<Integer> minHeap = new PriorityQueue<>();
     PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());   
     int ans = 0,start=0,i=0;
     while(i<nums.length){
        minHeap.add(nums[i]);
        maxHeap.add(nums[i]);
        while(maxHeap.size()>0 && Math.abs(minHeap.peek() - maxHeap.peek())>limit){
            maxHeap.remove(nums[start]);
            minHeap.remove(nums[start]);
            start++;
        }
        ans=Math.max(ans, maxHeap.size());
        i++;
     }
     return ans;
    }
}