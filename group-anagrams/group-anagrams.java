class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hmap=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char temp[]=strs[i].toCharArray();
            Arrays.sort(temp);
            String sorted=String.valueOf(temp);
            if(hmap.containsKey(sorted))
                hmap.get(sorted).add(strs[i]);
            else
                hmap.put(sorted,new ArrayList<String>(Arrays.asList(strs[i])));
        }
        List<List<String>>res=new ArrayList<List<String>>();
        for(Map.Entry<String,List<String>>x:hmap.entrySet())
            res.add(x.getValue());
        return res;
    }
}