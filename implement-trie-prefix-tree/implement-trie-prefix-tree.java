class TrieNode
{
    boolean isPresent=false;
    TrieNode arr[]=new TrieNode[26];
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.arr[index]==null)
                curr.arr[index]=new TrieNode();
            curr=curr.arr[index];
        }
        curr.isPresent=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.arr[index]==null)
                return false;
            curr=curr.arr[index];
        }
        return curr.isPresent;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            int index=prefix.charAt(i)-'a';
            if(curr.arr[index]==null)
                return false;
            curr=curr.arr[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */