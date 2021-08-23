class Solution {
    public String vals(char x)
    {
        String ch=Character.toString(x);
        if("qwertyuiop".contains(ch))
            return "qwertyuiop";
        if("asdfghjkl".contains(ch))
            return "asdfghjkl";
        return "zxcvbnm";
    }
    public String[] findWords(String[] words) {
        List<String>res=new ArrayList<String>();
        for(String x:words)
        {
            String i=x.toLowerCase();
            String find=vals(i.charAt(0));
            int j=1;
            for(j=1;j<i.length();j++)
                if(!find.contains(Character.toString(i.charAt(j))))
                    break;
            if(j==i.length())
                res.add(x);
        }
        String ans[]=new String[res.size()];
        for(int j=0;j<res.size();j++)
            ans[j]=res.get(j);
        return ans;
    }
}