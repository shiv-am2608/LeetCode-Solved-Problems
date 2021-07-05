class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res=new ArrayList<Integer>();
        int count1=0,count2=0;
        int num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==num1)
                count1++;
            else if(nums[i]==num2)
                count2++;
            else if(count1==0)
            {
                num1=nums[i];
                count1=1;
            }
            else if(count2==0)
            {
                num2=nums[i];
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==num1)
                count1++;
            if(nums[i]==num2)
                count2++;
        }
        if(count1>nums.length/3)
            res.add(num1);
        if(count2>nums.length/3)
            res.add(num2);
        return res;
            
    }
}