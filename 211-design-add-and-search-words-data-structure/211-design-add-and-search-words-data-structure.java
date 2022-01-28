class TrieNode
{
    TrieNode children[]=new TrieNode[26];
    boolean isEnd=false;
}
class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            int ch=word.charAt(i)-'a';
            if(curr.children[ch]==null)
                curr.children[ch]=new TrieNode();
            curr=curr.children[ch];
        }
        curr.isEnd=true;
    }
    public boolean find(TrieNode root,String word)
    {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z')
            {
                if(curr.children[ch-'a']==null)
                    return false;
                curr=curr.children[ch-'a'];
            }
            else
            {
                for(int j=0;j<26;j++)
                {
                    if(curr.children[j]!=null && find(curr.children[j],word.substring(i+1)))
                        return true;
                }
                return false;
            }
        }
        return curr.isEnd;
    }
    public boolean search(String word) {
        return find(root,word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */