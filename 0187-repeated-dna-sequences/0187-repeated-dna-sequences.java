class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for(int i=10;i<=s.length();i++){
            String subsequence = s.substring(i-10,i);
            if(!hs.contains(subsequence))
                hs.add(subsequence);
            else if(!ans.contains(subsequence))
                ans.add(subsequence);
        }
        return ans;
    }
}