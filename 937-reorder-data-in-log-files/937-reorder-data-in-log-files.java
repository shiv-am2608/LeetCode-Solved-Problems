class Solution {
    public int compare(String str1,String str2)
    {
        String t1[]=str1.split(" ");
        String t2[]=str2.split(" ");
        int comp=0;
        for(int i=1;i<Math.min(t1.length,t2.length);i++)
        {
            comp=t1[i].compareTo(t2[i]);
            if(comp!=0)
                return comp;
        }
        if(t1.length-t2.length!=0)
            return t1.length-t2.length;
        return t1[0].compareTo(t2[0]);
    }
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String>letters=new ArrayList<String>();
        ArrayList<String>digits=new ArrayList<String>();
        for(int i=0;i<logs.length;i++)
        {
            if(Character.isDigit(logs[i].split(" ")[1].charAt(0)))
                digits.add(logs[i]);
            else
                letters.add(logs[i]);
        }
        Collections.sort(letters,(t1,t2)->compare(t1,t2));
        for(int i=0;i<letters.size();i++)
            logs[i]=letters.get(i);
        for(int i=0;i<digits.size();i++)
            logs[i+letters.size()]=digits.get(i);
        return logs;
    }
}