class Solution {
    public boolean rotateString(String s, String goal) {
        String str=s+s;
        return goal.length()==s.length() && str.indexOf(goal)>=0;
        //return false;
    }
}