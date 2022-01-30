class Solution {
    public boolean solve(int nums[],int k,int end,int target,int currSum,boolean visited[])
    {
        if(k==0)
            return true;
        if(currSum==target)
            return solve(nums,k-1,nums.length-1,target,0,visited);//one subset removed and then reset
        for(int i=end;i>=0;i--)
        {
            if(visited[i])
                continue;
            
            //deals with TC -> [2,2,2,2,2,2]
            if(i+1<nums.length && nums[i]==nums[i+1] && !visited[i+1])
                continue;
            if(currSum+nums[i]>target)
                continue;
            
            //backtracking
            visited[i]=true;
            if(solve(nums,k,i-1,target,currSum+nums[i],visited))
                return true;
            visited[i]=false;
        }
        return false;
        
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //no division | insufficient length to divide
        if(k==1 || k>nums.length)
            return true;
        int sum=0;
        for(int i:nums)
            sum+=i;
        if(sum%k!=0)
            return false;
        Arrays.sort(nums);
        boolean visited[]=new boolean[nums.length];
        return solve(nums,k,nums.length-1,sum/k,0,visited);
    }
}