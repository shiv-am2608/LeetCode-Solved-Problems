class Solution {
    public List<List<Integer>>twoSum(int nums[],int start,int end,int target)
    {
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        List<Integer>res=new ArrayList<Integer>();
        while(start<end)
        {
            if(nums[start]+nums[end]==target)
            {
                res.add(nums[start]);
                res.add(nums[end]);
                ans.add(new ArrayList<>(res));
                res.clear();
                start++;
                end--;
            }
            else if(nums[start]+nums[end]<target)
                start++;
            else
                end--;
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        if(nums.length<3)
            return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            List<List<Integer>>temp=twoSum(nums,i+1,nums.length-1,-nums[i]);
            if(temp.size()>0)
            {
                //for a number,multiples pairs can exist have sum equal to that value
                for(List<Integer>x:temp)
                {
                    x.add(0,nums[i]);
                    res.add(new ArrayList<>(x));
                }
            }
        }
        
        //maintains unique set of triplets
        //Eg. TC ->[0,0,0,0] -->[[0,0,0],[0,0,0]]
        Set<List<Integer>> s = new LinkedHashSet<List<Integer>>(res); 
        res.clear();
        for(List<Integer>t:s)
            res.add(t);
        return res;
    }
}