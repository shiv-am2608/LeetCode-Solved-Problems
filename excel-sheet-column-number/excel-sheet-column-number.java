class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int factor = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--)
        {
            sum += (columnTitle.charAt(i) - 'A' + 1) * factor;
            factor *= 26;
        }
        return sum;
        
    }
}