class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        char grid[][]=new char[numRows][s.length()];
        boolean down=true;
        int row=0,col=0;
        for(char ch[]:grid)
            Arrays.fill(ch,'$');
        for(int i=0;i<s.length();)
        {
            if(down)
            {
                for(int j=0;j<numRows && i+j<s.length();j++)
                    grid[j][col]=s.charAt(i+j);
                down=!down;
                col++;
                i+=numRows;
            }
            else
            {
                for(int j=0;j<numRows-2 && i+j<s.length();j++)
                    grid[numRows-j-2][col++]=s.charAt(i+j);
                down=!down;
                col++;
                i+=numRows-2;
            }
        }
        String str="";
        for(int i=0;i<numRows;i++)
        {
            for(int j=0;j<s.length();j++)
            {
                if(grid[i][j]!='$')
                str=str+ grid[i][j];
            }
        }
        return str;

    }
}