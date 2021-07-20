class Solution {
    public void powerSet(List<Integer>res,int nums[],HashSet<List<Integer>>hs,int sum,int i)
    {
        if(sum==0)
        {
            List<Integer>temp=new ArrayList<Integer>(res);
            Collections.sort(temp);
            hs.add(new ArrayList<>(temp));
            return;
        }
        if(sum<0)
            return;
        for(;i<nums.length;i++)
        {
                res.add(nums[i]);
                powerSet(res,nums,hs,sum-nums[i],i+1);
                res.remove(res.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        HashSet<List<Integer>>hs=new HashSet<List<Integer>>();
        List<Integer>res=new ArrayList<Integer>();
        powerSet(res,candidates,hs,target,0);
        for(List<Integer>i:hs)
            ans.add(i);
        return ans;
    }
}