class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
            if(hmap.containsKey(nums[i]))
                hmap.put(nums[i],hmap.get(nums[i])+1);
            else
                hmap.put(nums[i],1);
        int max=0;
        for(int i=0;i<nums.length;i++)
                max=Math.max(max,hmap.get(nums[i]));

        List<Integer>arr=new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer>temp:hmap.entrySet())
            if(temp.getValue()==max)
                arr.add(temp.getKey());
        int res=0;
        int final_res=Integer.MAX_VALUE;
        for(Integer temp:arr)
        {
            res=Integer.MAX_VALUE;
            int i;
            for(i=0;i<nums.length;i++)
                if(nums[i]==temp)
                    break;
            int j;
            for(j=nums.length-1;j>=0;j--)
                if(nums[j]==temp)
                    break;
            int size=j-i+1;
            res=Math.min(size,res);
            final_res=Math.min(final_res,res);
        }
        return final_res;
            
            
    }
}