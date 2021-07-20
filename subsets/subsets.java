class Solution {
    public void powerSet(List<Integer>res,int nums[],List<List<Integer>>ans,boolean visited[],int i)
    {
        ans.add(new ArrayList<>(res));
        if(i==nums.length)
            return;
        for(;i<nums.length;i++)
        {
            if(!visited[i])
            {
                res.add(nums[i]);
                visited[i]=true;
                powerSet(res,nums,ans,visited,i+1);
                visited[i]=false;
                res.remove(res.size()-1);
            }
        }
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        List<Integer>res=new ArrayList<Integer>();
        boolean visited[]=new boolean[nums.length];
        powerSet(res,nums,ans,visited,0);
        return ans;
    }
}