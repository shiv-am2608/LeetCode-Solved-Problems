class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[]=new int[n];
        for(int i[]:trust)
            arr[i[0]-1]=1;
        int potentialJudge=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                if(potentialJudge==-1)
                    potentialJudge=i;
                else
                    return -1;
            }
        }
        Arrays.fill(arr,0);
        for(int i[]:trust)
            if(i[1]==potentialJudge+1)
                arr[i[0]-1]=1;
        for(int i=0;i<n;i++)
            if(arr[i]==0 && i!=potentialJudge)
                return -1;
        return potentialJudge+1;
    }
}