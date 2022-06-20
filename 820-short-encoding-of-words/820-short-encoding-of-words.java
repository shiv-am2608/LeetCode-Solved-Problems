class Solution {
class TrieNode{
TrieNode []children;

    TrieNode(){
        children = new TrieNode[26];
    }
}
TrieNode root;
public boolean helper(String word){
    
    boolean flag = true;
    TrieNode curr = root;
    
    for(int i=word.length()-1;i>=0;i--){
        char ch = word.charAt(i);
        if(curr.children[ch-'a'] == null){
            flag = false;
            curr.children[ch - 'a'] = new TrieNode();
        }
        curr = curr.children[ch-'a'];
    }
    return flag;
}
public int minimumLengthEncoding(String[] words) {
    
    root = new TrieNode();
    Arrays.sort(words,(a,b) ->{
        return b.length() - a.length();
    });
    
    int count = 0;
    for(int i=0;i<words.length;i++){
        if(!helper(words[i])){
            count += words[i].length() + 1;
        }
    }
    return count;
}
}