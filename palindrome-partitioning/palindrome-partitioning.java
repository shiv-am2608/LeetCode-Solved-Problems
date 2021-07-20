class Solution {
    public boolean isPalindrome(String s)
    {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public void powerSet(List<String>res,String s,HashSet<List<String>>hs,int j)
    {
        if(s.length()==0)
        {
            List<String>temp=new ArrayList<String>(res);
            hs.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<s.length();i++)
        {
                if(isPalindrome(s.substring(0,i+1)))
                {
                    res.add(s.substring(0,i+1));
                    powerSet(res,s.substring(i+1),hs,i+1);
                    res.remove(res.size()-1);
                }

        }
        
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<List<String>>();
        HashSet<List<String>>hs=new HashSet<List<String>>();
        List<String>res=new ArrayList<String>();
        powerSet(res,s,hs,0);
        for(List<String>i:hs)
            ans.add(i);
        return ans;
    }
}