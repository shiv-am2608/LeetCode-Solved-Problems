class Solution {
    public void powerSet(List<Integer>res,int nums[],HashSet<List<Integer>>hs,int i)
    {
        List<Integer>temp=new ArrayList<Integer>(res);
        Collections.sort(temp);
        hs.add(new ArrayList<>(temp));
        if(i==nums.length)
            return;
        for(;i<nums.length;i++)
        {
                res.add(nums[i]);
                powerSet(res,nums,hs,i+1);
                res.remove(res.size()-1);
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        HashSet<List<Integer>>hs=new HashSet<List<Integer>>();
        List<Integer>res=new ArrayList<Integer>();
        powerSet(res,nums,hs,0);
        for(List<Integer>i:hs)
            ans.add(i);
        return ans;
    }
}