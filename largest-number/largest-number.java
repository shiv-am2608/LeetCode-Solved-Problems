class Solution {
    public String largestNumber(int[] nums) {
        String arr[]=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            arr[i]=Integer.toString(nums[i]);
       Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        String ans="";
        for(String i:arr)
            ans=ans+i;
        if(ans.charAt(0)=='0' && ans.charAt(ans.length()-1)=='0')
            return "0";
        return ans;
    }
}