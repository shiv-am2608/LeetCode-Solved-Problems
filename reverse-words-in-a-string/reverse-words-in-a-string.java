class Solution {
    public String reverseWords(String s) {
        String str="";
        if(s.charAt(0)!=' ')
            str+=s.charAt(0);
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)==' ' && s.charAt(i-1)==' ')
                continue;
            else
                str+=s.charAt(i);
        String arr[]=str.split(" ");
        int i=0,j=arr.length-1;
        while(i<j)
        {
            String temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
            i++;
            j--;
        }
        return String.join(" ",arr);
    }
}