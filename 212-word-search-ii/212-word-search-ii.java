class TrieNode
{
    TrieNode children[]=new TrieNode[26];
    String word=null;
}
class Solution {
    public TrieNode buildTrie(String words[])
    {
        TrieNode root=new TrieNode();
        for(String x:words)
        {
            TrieNode ptr=root;
            for(int i=0;i<x.length();i++)
            {
                char ch=x.charAt(i);
                if(ptr.children[ch-'a']==null)
                    ptr.children[ch-'a']=new TrieNode();
                ptr=ptr.children[ch-'a'];
            }
            ptr.word=x;
        }
        return root;
    }
    public void dfs(char grid[][],int i,int j,List<String>ans,TrieNode root)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return;
        char ch=grid[i][j];
        if(ch=='#' || root.children[ch-'a']==null)
            return;
        root=root.children[ch-'a'];
        if(root.word!=null)
        {
            ans.add(root.word);
            root.word=null;
        }
        grid[i][j]='#';
        dfs(grid,i+1,j,ans,root);
        dfs(grid,i,j+1,ans,root);
        dfs(grid,i-1,j,ans,root);
        dfs(grid,i,j-1,ans,root);
        grid[i][j]=ch;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=buildTrie(words);
        List<String>ans=new ArrayList<String>();
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                dfs(board,i,j,ans,root);
        return ans;
    }
}