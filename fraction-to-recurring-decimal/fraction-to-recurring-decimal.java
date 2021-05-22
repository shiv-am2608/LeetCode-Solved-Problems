class Solution {
    public String fractionToDecimal(int num, int den) {
        StringBuilder res=new StringBuilder();
        if((num>0)^(den>0) && num!=0)
            res.append("-");
        long n=(long)Math.abs(num);
        long d=(long)Math.abs(den);
        long q=Math.abs(n/d);
        long rem=n%d;
        res.append(q);
        if(rem==0)
            return res.toString();
        res.append(".");
        HashMap<Long,Integer>hmap=new HashMap<Long,Integer>();
        while(rem!=0)
        {
            if(hmap.containsKey(rem))
            {
                res.insert(hmap.get(rem),"(");
                res.append(")");
                break;
            }
            hmap.put(rem,res.length());
            rem*=10;
            q=Math.abs(rem/d);
            res.append(q);
            rem=rem%d;
        }
        return res.toString();
    }
}