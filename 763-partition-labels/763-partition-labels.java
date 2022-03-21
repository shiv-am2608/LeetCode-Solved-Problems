class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<Integer>();
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for(int i=s.length()-1; i>=0; i--){
    		char ch = s.charAt(i);
    		if(!map.containsKey(ch))
    			map.put(ch, i);
    	}
    	int start=0;
    	int end=0;
    	while(end<s.length()){
    		for(int i=start; i<=end; i++){
    			end = Math.max(end, map.get(s.charAt(i)));
    		}
    		list.add(end-start+1);
    		end++;
    		start=end;
    	}
    	return list;
    }
}