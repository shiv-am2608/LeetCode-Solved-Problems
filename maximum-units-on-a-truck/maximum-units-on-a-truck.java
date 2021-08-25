class Solution {
  
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new java.util.Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(b[1], a[1]);
            }
        });
        int ans=0;
        for(int i[]:boxTypes)
        {
            // System.out.println(i[0]+" "+i[1]);
            if(truckSize>i[0])
            {
                ans+=i[0]*i[1];
                truckSize-=i[0];
            }
            else
            {
                ans+=truckSize*i[1];
                break;
            }
        }
        return ans;
    }
}