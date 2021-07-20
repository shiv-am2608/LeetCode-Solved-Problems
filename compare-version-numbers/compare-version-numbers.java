class Solution {
    public int value(String s1,String s2)
    {
        int n1=Integer.parseInt(s1);
        int n2=Integer.parseInt(s2);
        if(n1>n2)
            return 1;
        else if(n1<n2)
            return -1;
        return 0;
    }
    public int compareVersion(String version1, String version2) {
        String v1[]=version1.split("\\.");
        String v2[]=version2.split("\\.");
        int i;
        for(i=0;i<v1.length && i<v2.length;i++)
        {
            if(value(v1[i],v2[i])==-1)
                return -1;
            if(value(v1[i],v2[i])==1)
                return 1;
        }
        while(i<v2.length)
        {
            int ans=value("0",v2[i]);
            if(ans!=0)
                return ans;
            i++;            
        }
        while(i<v1.length)
        {
            int ans=value(v1[i],"0");
            if(ans!=0)
                return ans;
            i++;            
        }
        return 0;
    }
}