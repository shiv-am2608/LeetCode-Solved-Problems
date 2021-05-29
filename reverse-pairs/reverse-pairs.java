class Solution {
    public void merge(int[] nums, int l, int m, int h) {
        int i=0, j=0, k=l, n1= m+1-l, n2=h-m, swaps=0 ;
        int[] left= new int[m+1-l], right = new int[h-m];
        
        for(int z=0; z<n1; z++) left[z]= nums[l+z];
        for(int z=0; z<n2; z++) right[z]= nums[m+1+z];
        
        while(i<n1 && j<n2) {
            if(left[i]<=right[j]) nums[k++] = left[i++];
            else nums[k++] = right[j++]; 
        }
        while(i<n1) nums[k++] = left[i++];
        while(j<n2) nums[k++] = right[j++]; 
    }
    
    public int mergeSort(int[] nums, int l, int h) {
        int c=0;
        if(l<h) {
            int m= l+(h-l)/2;
            c+= mergeSort(nums, l, m);
            c+= mergeSort(nums, m+1, h);
            
            int j=m+1;
            for(int i=l; i<=m; i++) {
			long x=2;
                while(j<=h && nums[i]> x*nums[j]) j++;
                c+= j-m-1;
            }
            merge(nums, l, m, h);
        }
        return c;
    }
    
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
}