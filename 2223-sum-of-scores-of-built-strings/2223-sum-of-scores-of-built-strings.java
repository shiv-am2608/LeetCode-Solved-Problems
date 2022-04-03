class Solution {
    public long[] calculateZArray(String s){
        long arr[]=new long[s.length()];
        int left=0,right=0;
        for(int i=1;i<s.length();i++){
            if(i>right){
                left=i;
                right=i;
                while(right<s.length() && s.charAt(right-left)==s.charAt(right))
                    right++;
                arr[i]=right-left;
                right--;
            }
            else{
                int k1=i-left;
                if(arr[k1]<right-i+1)
                    arr[i]=arr[k1];
                else{
                    left=i;
                    while(right<s.length() && s.charAt(right-left)==s.charAt(right))
                        right++;
                    arr[i]=right-left;
                    right--;
                }
            }
        }
        return arr;
    }
    public long sumScores(String s) {
        long arr[]=calculateZArray(s);
        long sum=0;
        for(long x:arr)
        {
            sum+=x;
        }
        return sum+s.length();
    }
}