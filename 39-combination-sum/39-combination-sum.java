class Solution {
    public void powerSet(List<Integer>res,int nums[],HashSet<List<Integer>>hs,int sum)
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
        for(int i=0;i<nums.length;i++)
        {
                res.add(nums[i]);
                powerSet(res,nums,hs,sum-nums[i]);
                res.remove(res.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        HashSet<List<Integer>>hs=new HashSet<List<Integer>>();
        List<Integer>res=new ArrayList<Integer>();
        powerSet(res,candidates,hs,target);
        for(List<Integer>i:hs)
            ans.add(i);
        return ans;
    }
}