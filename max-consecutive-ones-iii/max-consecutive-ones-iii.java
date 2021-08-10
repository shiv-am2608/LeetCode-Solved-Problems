class Solution {
    public int longestOnes(int[] nums, int k) {
        int count=0,start=0,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) 
        {
            if(nums[i]==0)
                count++;
            while(count>k)
            {
                if(nums[start]==0)
                    count--;
                start++;
            }
             max=Math.max(max,i-start+1);
        }
        return max;
    }
}