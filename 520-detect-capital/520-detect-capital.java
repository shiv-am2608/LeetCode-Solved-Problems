class Solution {
    public int getCase(String word)
    {
        char ch1=word.charAt(0);
        char ch2=word.charAt(1);
        if((ch1>='A' && ch1<='Z') && (ch2>='A' && ch2<='Z'))
            return 1;
        if((ch1>='a' && ch1<='z') && (ch2>='a' && ch2<='z'))
            return 2;
        if((ch1>='A' && ch1<='Z') && (ch2>='a' && ch2<='z'))
            return 3;
        return -1;
    }
    public boolean detectCapitalUse(String word) {
        if(word.length()<=1)
            return true;
        int i=getCase(word);
        if(i==-1)
            return false;
        for(int j=2;j<word.length();j++)
        {
            char ch=word.charAt(j);
            if(i==1 && Character.isLowerCase(ch))
                return false;
            if(i==2 && Character.isUpperCase(ch))
                return false;
            if(i==3 && Character.isUpperCase(ch))
                return false;
        }
        return true;
    }
}