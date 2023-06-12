class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String>ans=new ArrayList<String>();
        if(nums.length==0)
            return ans;
        int n=nums.length;
        if(n==1)
        {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int last=-1;
        for(int i=1;i<nums.length;i++)
        {
            int a=nums[i-1];
            int k=a+1;
            while(i<nums.length && k==nums[i])
            {
                k++;
                i++;
            }
            if(k==a+1)
                ans.add(String.valueOf(a));
            else
            {
                last=k-1;
                ans.add(String.valueOf(a)+"->"+String.valueOf(k-1));
            }
        }
        if(last!=nums[n-1])
            ans.add(String.valueOf(nums[n-1]));
        return ans;
    }
}