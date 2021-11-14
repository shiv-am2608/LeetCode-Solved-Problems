class Solution {
    public double calculate(int n,int k)
    {
        double numerator=(2*n)-(k*k)-k;
        double denominator=(2*k)+2;
        return numerator/denominator;
    }
    public int consecutiveNumbersSum(int n) {
        int k=0,count=0;
        while(true)
        {
            double value=calculate(n,k);
            if(value<=0)
                break;
            if(value-(int)value==0.0)
                count++;
            k++;
        }
        return count;
    }
}