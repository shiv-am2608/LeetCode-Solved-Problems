class Solution {
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    int billion=1000000000;
    int million=1000000;
    int thousand=1000;
    int hundred=100;
    private String helper(int num)
    {
        String str="";
        if (num>=billion)
            str=str+(helper(num/billion))+" Billion"+(num%billion!=0?" "+helper(num%billion):"");
        else if(num>=million)
            str=str+helper(num/million)+" Million"+(num%million!=0?" "+helper(num%million):"");
        else if (num>=thousand)
           str=str+helper(num/thousand)+" Thousand"+(num%1000!=0?" "+helper(num%1000):"");
        else if (num>=hundred)
            str=str+helper(num/100)+" Hundred"+(num%100!=0?" "+helper(num%100):"");
        else if (num>=20)
            str=str+tens[num/10]+(num%10!=0?" "+helper(num%10):"");
        else
            str=str+ones[num];
        return str;
        
    }
    public String numberToWords(int num)
    {
        if (num==0)
            return "Zero";
        return helper(num).trim();
    }
}