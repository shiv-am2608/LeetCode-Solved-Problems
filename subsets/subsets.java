class Solution {
    public void powerSet(List<Integer>res,int nums[],List<List<Integer>>ans,int i)
    {
        ans.add(new ArrayList<>(res));
        for(;i<nums.length;i++)
        {
                res.add(nums[i]);
                powerSet(res,nums,ans,i+1);
                res.remove(res.size()-1);
        }
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        List<Integer>res=new ArrayList<Integer>();
        powerSet(res,nums,ans,0);
        return ans;
    }
}