// { Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}// } Driver Code Ends


/*complete the Function*/

class Solution {
    public void generateIpAddress(String s,List<String>ans,int dots,String res){
        if(s.length()==0 && dots==-1){
            ans.add(res.substring(0,res.length()-1));
            return;
        }
        if(dots==-2 || s.length()==0)
            return;
        if(s.charAt(0)=='0'){
            generateIpAddress(s.substring(1),ans,dots-1,res+"0.");
        }
        else{
            for(int i=1;i<Math.min(4,s.length()+1);i++){
            if(Integer.parseInt(s.substring(0,i))<=255)
                generateIpAddress(s.substring(i),ans,dots-1,res+s.substring(0,i)+".");
            }
        }
    }
    public ArrayList<String> genIp(String s) {
        // code here
        ArrayList<String>ans=new ArrayList<String>();
        if(s.length()<4 || s.length() >12)
            return ans;
        generateIpAddress(s,ans,3,"");
        return ans;
    }
}