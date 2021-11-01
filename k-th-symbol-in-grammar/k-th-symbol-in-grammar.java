class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) 
            return 0;
        int par = kthGrammar(n-1,(k/2)+(k%2));
        boolean iskOdd = k%2==1;
        if(par==1) 
            return iskOdd?1:0;
        return iskOdd?0:1;
    }
}