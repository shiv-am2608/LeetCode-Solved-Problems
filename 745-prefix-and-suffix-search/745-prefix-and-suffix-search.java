class TrieNode{
    TrieNode arr[]=new TrieNode[256];
    HashSet<String>hs=new HashSet<String>();
}
class WordFilter {
    TrieNode pre,suf;
    HashMap<String,Integer>hmap;
    public WordFilter(String[] words) {
        pre=new TrieNode();
        suf=new TrieNode();
        hmap=new HashMap<String,Integer>();
        insert(words);
    }
    
    public void insert(String words[])
    {
        int j=0;
        for(String str:words)
        {
            hmap.put(str,j);
            j++;
            TrieNode ptr1=pre,ptr2=suf;
            for(int i=0;i<str.length();i++)
            {
                char start= str.charAt(i);
                if(ptr1.arr[start]==null)
                    ptr1.arr[start]=new TrieNode();
                ptr1=ptr1.arr[start];
                ptr1.hs.add(str);
                
                char end = str.charAt(str.length()-1-i);
                if(ptr2.arr[end]==null)
                    ptr2.arr[end]=new TrieNode();
                ptr2=ptr2.arr[end];
                ptr2.hs.add(str);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode ptr1=pre;
        for(int i=0;i<prefix.length();i++)
        {
            char ch = prefix.charAt(i);
            if(ptr1.arr[ch]==null)
                return -1;
            ptr1=ptr1.arr[ch];
        }
        
        TrieNode ptr2=suf;
        for(int i=suffix.length()-1;i>=0;i--)
        {
            char ch = suffix.charAt(i);
            if(ptr2.arr[ch]==null)
                return -1;
            ptr2=ptr2.arr[ch];
        }
        
        int index=-1;
        for(String str:ptr1.hs)
            if(ptr2.hs.contains(str))
                index=Math.max(index,hmap.get(str));
        return index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */