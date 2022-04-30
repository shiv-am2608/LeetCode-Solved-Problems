class Solution {
    public void buildGraphs(HashMap<String,HashMap<String,Double>> hmap,List<List<String>>equations,double values[])
    {
        for(int i=0;i<values.length;i++)
        {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            if(!hmap.containsKey(x))
                hmap.put(x,new HashMap<String,Double>());
            if(!hmap.containsKey(y))
                hmap.put(y,new HashMap<String,Double>());
            hmap.get(x).put(y,values[i]);
            hmap.get(y).put(x,1/values[i]);
        }
    }
    
    public double calculate(HashMap<String,HashMap<String,Double>> hmap,String src,String dest,HashSet<String>visited)
    {
        if(!hmap.containsKey(src) || !hmap.containsKey(dest))
            return -1.0;
        if(src.equals(dest))
            return 1.0;
        visited.add(src);
        for(Map.Entry<String,Double>x:hmap.get(src).entrySet())
        {                  
            if(!visited.contains(x.getKey()))
            {
                double ans=calculate(hmap,x.getKey(),dest,visited);
                if(ans!=-1.0)
                    return x.getValue()*ans;
            }
                
        }
        visited.remove(src);
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>>hmap=new HashMap<>();
        buildGraphs(hmap,equations,values);
        double ans[]=new double[queries.size()];
        for(int i=0;i<ans.length;i++)
        {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            ans[i]=calculate(hmap,src,dest,new HashSet<String>());
        }
        return ans;
    }
}