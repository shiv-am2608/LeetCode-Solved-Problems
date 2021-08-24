class Solution {
    int x=0,y=0;
    char dir='N';
    public void move(char ch)
    {
        if(ch=='G')
        {
            if(dir=='N')
                y--;
            if(dir=='S')
                y++;
            if(dir=='E')
                x++;
            if(dir=='W')
                x--;
        }
        else if(ch=='L')
        {
            if(dir=='N')
                dir='W';
            else if(dir=='S')
                dir='E';
            else if(dir=='E')
                dir='N';
            else if(dir=='W')
                dir='S';
        }
        else
        {
            if(dir=='N')
                dir='E';
            else if(dir=='S')
                dir='W';
            else if(dir=='E')
                dir='S';
            else if(dir=='W')
                dir='N';
        }
    }
    public boolean isRobotBounded(String instructions) {
        for(int i=0;i<instructions.length();i++)
            move(instructions.charAt(i));
        if(x==0 && y==0)
                return true;
        if(dir=='N')
                return false;
        return true;
    }
}