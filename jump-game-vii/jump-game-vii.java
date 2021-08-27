class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1)=='1')
            return false;
        int maxLimit=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty())
        {
            int curr=q.poll();
            if(curr==s.length()-1)
                return true;
        for(int i=Math.max(curr+minJump,maxLimit);i<=Math.min(curr+maxJump,s.length()-1);i++)
        {
            if(s.charAt(i)=='0')
                q.offer(i);
        }
            maxLimit=Math.max(maxJump+curr,maxLimit);
        }
        return false;
    }
}