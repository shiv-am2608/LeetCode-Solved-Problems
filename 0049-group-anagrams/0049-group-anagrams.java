class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hmap=new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++)
        {
            char letters[]=strs[i].toCharArray();
            Arrays.sort(letters);
            String sorted=String.valueOf(letters);
            if(hmap.containsKey(sorted))
                hmap.get(sorted).add(strs[i]);
            else
            {
                List<String>temp=new ArrayList<String>();
                temp.add(strs[i]);
                hmap.put(sorted,temp);
            }
        }
        List<List<String>>ans=new ArrayList<List<String>>();
        for(List<String>x:hmap.values())
            ans.add(x);
        return ans;
    }
}