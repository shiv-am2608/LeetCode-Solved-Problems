class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        ArrayList<Integer>rows=new ArrayList<Integer>();
        ArrayList<Integer>cols=new ArrayList<Integer>();
        rows.add(0);
        for(int i:horizontalCuts)
            rows.add(i);
        rows.add(h);
        cols.add(0);
        for(int i:verticalCuts)
            cols.add(i);
        cols.add(w);
        long max_row=0,max_col=0;
        for(int i=1;i<rows.size();i++)
            max_row=Math.max(rows.get(i)-rows.get(i-1),max_row);
        for(int i=1;i<cols.size();i++)
            max_col=Math.max(cols.get(i)-cols.get(i-1),max_col);
        long ans=(max_row*max_col)%1000000007;
        return (int)ans;
    }
}