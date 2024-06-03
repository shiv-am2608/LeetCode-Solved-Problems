class Solution {
    public int appendCharacters(String s, String t) {
        int sstart=0,tstart=0;
        while(sstart<s.length() && tstart<t.length()){
            if(s.charAt(sstart) == t.charAt(tstart))
                tstart++;
            sstart++;
        }
        return t.length() - tstart;
    }
}