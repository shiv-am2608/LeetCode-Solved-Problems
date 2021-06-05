class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>res=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int temp=Math.abs(nums[i])-1;
            if(nums[temp]<0)
                res.add(temp+1);
            nums[temp]=-nums[temp];
        }
        return res;
    }
}