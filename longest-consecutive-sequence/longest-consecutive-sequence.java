class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        TreeSet<Integer>tset=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++)
            tset.add(nums[i]);
        ArrayList<Integer>arr=new ArrayList<Integer>();
        for(int x:tset)
            arr.add(x);
        //System.out.println(arr.size());
        int max=1;
        int res=1;
        for(int i=0;i<arr.size()-1;i++)
        {
            if(arr.get(i)==arr.get(i+1)-1)
            {
                max++;
                res=Math.max(max,res);
            }
            else
                max=1;
        }
        return res;
    }
}