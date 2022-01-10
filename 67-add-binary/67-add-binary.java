class Solution {
    public String modify(String a,String b)
    {
        int diff=a.length()-b.length();
        for(int i=0;i<diff;i++)
            b='0'+b;
        return b;
    }
    public String addBinary(String a, String b) {
        if(a.length()<b.length())
            return addBinary(b,a);
        b=modify(a,b); 
        int carry=0;
        String ans="";
        for(int i=a.length()-1;i>=0;i--)
        {
            char ad=a.charAt(i);
            char bd=b.charAt(i);
            int add=0;
            if(ad=='1' && bd=='1')
            {
                if(carry==1)
                    add=1;
                else
                {
                    add=0;
                    carry=1;
                }
            }
            else if(ad=='0' && bd=='0')
            {
                if(carry==1)
                {
                    add=1;
                    carry=0;
                }
                else
                    add=0;
            }
            else
            {
                if(carry==1)
                    add=0;
                else
                    add=1;
            }
            ans=add+ans;
        }
        if(carry==1)
            ans='1'+ans;
        return ans;
    }
}