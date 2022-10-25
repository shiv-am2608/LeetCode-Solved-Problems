class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String w1="",w2="";
        for(String str:word1)
            w1=w1+str;
        for(String str:word2)
            w2=w2+str;
        return w1.equals(w2);
    }
}