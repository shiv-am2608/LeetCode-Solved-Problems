class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int low = 0, high = Math.min(tasks.length, workers.length);
        while(low<high){
            int mid = (low+high+1)/2;
            if(canAssign(tasks,workers,pills,strength,mid))
                low=mid;
            else
                high=mid-1;
        }
        return low;
    }

    public boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int mid){
        Deque<Integer> power = new ArrayDeque<>();
        int workerIdx = workers.length-1;
        for(int i=mid-1;i>=0;i--){
            if(!power.isEmpty() && power.peekFirst()>=tasks[i])
                power.pollFirst();
            else if(workerIdx>=0 && tasks[i]<= workers[workerIdx])
                workerIdx--;
            else{
                while(workerIdx >=0 && workers[workerIdx]+strength>=tasks[i]){
                    power.addLast(workers[workerIdx--]);
                }
                if(power.isEmpty() || pills==0)
                    return false;
                power.pollLast();
                pills--;
            }
        }
        return true;
    }
}