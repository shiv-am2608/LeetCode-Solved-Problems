class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        TreeMap<Integer,List<Integer>>freq=new TreeMap<Integer,List<Integer>>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++)
            if(hmap.containsKey(nums[i]))
                hmap.put(nums[i],hmap.get(nums[i])+1);
            else
                hmap.put(nums[i],1);
        for(Map.Entry<Integer,Integer>temp:hmap.entrySet())
        {
            if(freq.containsKey(temp.getValue()))
            {
                List<Integer>t=freq.get(temp.getValue());
                t.add(temp.getKey());
                Collections.sort(t);
                freq.put(temp.getValue(),t);
            }      
            else
            {
                List<Integer>t=new ArrayList<Integer>();
                t.add(temp.getKey());
                freq.put(temp.getValue(),t);
            }
        }
        List<Integer>res=new ArrayList<Integer>();
        for(Map.Entry<Integer,List<Integer>>temp:freq.entrySet())
        {
            for(int i:temp.getValue())
            {
                res.add(i);
                k--;
                if(k==0)
                    break;
            }
            if(k==0)
                break;
        }
        int r[]=new int[res.size()];
        Collections.sort(res);
        for(int i=0;i<res.size();i++)
            r[i]=res.get(i);
        return r;
    }
}