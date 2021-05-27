class Solution {
    public void rec(List<Integer> arr,boolean check[],int nums[],List<List<Integer>> ans)
    {
        if(arr.size()==check.length)
        {
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int i=0;i<check.length;i++)
        {
            if(check[i]!=true)
            {
            arr.add(nums[i]);
            check[i]=true;
            rec(arr,check,nums,ans);
            arr.remove(arr.size()-1);
            check[i]=false;
            }
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        List<Integer>arr=new ArrayList<Integer>();
        boolean check[]=new boolean[nums.length];
        rec(arr,check,nums,ans);
        return ans;
    }
}