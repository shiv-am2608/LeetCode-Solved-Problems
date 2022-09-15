class Solution {
    public int[] findOriginalArray(int[] changed) {
        int zero[]=new int[0];
        if(changed.length%2!=0)
            return zero;
        ArrayList<Integer>ans=new ArrayList<Integer>();
        TreeSet<Integer>tset=new TreeSet<Integer>();
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i:changed)
        {
            tset.add(i);
            if(hmap.containsKey(i))
                hmap.put(i,hmap.get(i)+1);
            else
                hmap.put(i,1);
        }
        for(int i:tset)
        {
            if(!hmap.containsKey(i))
                continue;
            if(i==0)
            {
                if(hmap.get(i)%2!=0)
                    return zero;
            }
            int twotimes = 2*i;
            if(!hmap.containsKey(twotimes) || hmap.get(twotimes)<hmap.get(i))
                return zero;
            int diff = hmap.get(twotimes)-hmap.get(i);
            for(int j=0;j< (i==0?hmap.get(i)/2:hmap.get(i));j++)
                ans.add(i);
            if(diff==0)
                hmap.remove(twotimes);
            else
                hmap.put(twotimes,diff);
        }
        int res[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i]=ans.get(i);
        return res;
    }
}