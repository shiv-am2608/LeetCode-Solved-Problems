class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, count = 0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            sum = sum+nums[i];
            while(sum * (i-j+1) >=k && j<=i){
                sum = sum-nums[j];
                j++;
            }
            count+=(i-j+1);
        }
        return count;
    }
}