class Solution {
    boolean isNegative=false;
    public String prepString(String s)
    {
        s=s.trim();
        if(s.length()==0)
            return s;
        char first=s.charAt(0);
        int i=0;
        boolean flag=false;
        if(first=='+')
        {
            i++;
            flag=true;
        }
        else if(first=='-')
        {
            i++;
            isNegative=true;
            flag=true;
        }
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
            i++;
        if(flag)
            return s.substring(1,i);
        return s.substring(0,i);
    }
    public int generateNumber(String target)
    {
        int res=0;
        for(int i=0;i<target.length();i++)
            res=(res*10)+(target.charAt(i)-'0');
        return res;
    }
    public int myAtoi(String s) {
        String target=prepString(s);
        int j=0;
        while(j<target.length() && target.charAt(j)=='0')
            j++;
        target=target.substring(j,target.length());
        //System.out.println(target+" "+isNegative);
        if(target.length()>10)
        {
            if(isNegative)
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        if(target.length()==10)
        {
         
            String temp=target.substring(0,target.length()-1);
            int numUpto9Digits=generateNumber(temp);
            if(numUpto9Digits>Integer.MAX_VALUE/10)
            {
                if(isNegative)
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            else if(numUpto9Digits==Integer.MAX_VALUE/10)
            {
                char lastDigit=target.charAt(target.length()-1);
                //System.out.println(lastDigit);
                if(isNegative && lastDigit>='8')
                    return Integer.MIN_VALUE;
                if(!isNegative && lastDigit>='7')
                    return Integer.MAX_VALUE;
            }
        }
        int ans=generateNumber(target);
        if(isNegative)
            return -1*ans;
        return ans;
    }
}