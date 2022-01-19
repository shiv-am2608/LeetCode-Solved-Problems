class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<names.length; i++)
        {
            String key = names[i];
            int count = map.containsKey(key) ? map.get(key) : 0;
            while(map.containsKey(key))  
                key = names[i] + "(" + ++count + ")";
            map.put(key, 0);                 
            map.put(names[i], count);       
            names[i] = key;          
        }
        return names;
    }
}