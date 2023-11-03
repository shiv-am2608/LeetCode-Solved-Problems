class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String>ans=new ArrayList<String>();
        int i=0;
        int count_push=0,count_pop=0;
        for(int j=1;j<=n;j++){
            if(j==target[i]){
                while(count_pop>0){
                    ans.add("Pop");
                    count_pop--;
                }
                i++;
            }
            else
                count_pop++;
            ans.add("Push");
            if(i==target.length)
                    break;
        }
        return ans;
    }
}