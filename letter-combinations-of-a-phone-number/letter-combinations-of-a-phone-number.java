class Solution {
    public String letters(int n)
    {
        if(n=='2')
            return "abc";
        if(n=='3')
            return "def";
        if(n=='4')
            return "ghi";
        if(n=='5')
            return "jkl";
        if(n=='6')
            return "mno";
        if(n=='7')
            return "pqrs";
        if(n=='8')
            return "tuv";
        return "wxyz";
    }
    public void generate(String digits,String curr,List<String>res)
    {
        if(digits.length()==0)
        {
            res.add(curr);
            return;
        }
        char num=digits.charAt(0);
        String list=letters(num);
        for(int i=0;i<list.length();i++)
        {
            curr=curr+list.charAt(i);
            generate(digits.substring(1),curr,res);
            curr=curr.substring(0,curr.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<String>();
        if(digits.length()==0)
            return res;
        generate(digits,"",res);
        return res;
    }
}