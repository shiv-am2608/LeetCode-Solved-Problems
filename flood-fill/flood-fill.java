class Solution {
    public void dfs(int image[][],int x,int y,int old,int newColor)
    {
        if(x<0 || y<0 || x>=image.length || y>=image[0].length || image[x][y]!=old)
            return;
        image[x][y]=newColor;
        dfs(image,x+1,y,old,newColor);
        dfs(image,x,y+1,old,newColor);
        dfs(image,x-1,y,old,newColor);
        dfs(image,x,y-1,old,newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int old=image[sr][sc];
        if(old!=newColor)
            dfs(image,sr,sc,old,newColor);
        return image;
    }
}