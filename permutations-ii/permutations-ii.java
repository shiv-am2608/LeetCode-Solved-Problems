class Solution {
    public void permute(List<Integer>arr,boolean visited[],HashSet<List<Integer>>ans,int nums[])
    {
        if(arr.size()==visited.length)
        {
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                arr.add(nums[i]);
                permute(arr,visited,ans,nums);
                arr.remove(arr.size()-1);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean visited[]=new boolean[nums.length];
        List<Integer>arr=new ArrayList<Integer>();
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        HashSet<List<Integer>>hs=new HashSet<List<Integer>>();
        permute(arr,visited,hs,nums);
        for(List<Integer>temp:hs)
            ans.add(temp);
        return ans;
    }
}