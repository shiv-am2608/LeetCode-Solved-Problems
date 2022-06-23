class Solution {
    public int scheduleCourse(int[][] courses) {
        // sort courses by last day in ascending order
        Arrays.sort(courses, (c1, c2) -> Integer.compare(c1[1], c2[1]));
        // max heap to track the max duration courses
        PriorityQueue<Integer> heap = new PriorityQueue<>((d1, d2) -> Integer.compare(d2, d1));
        
        int time = 0;
        for(int[] course: courses) {
            int duration = course[0], lastDay = course[1];
            time += duration;
            heap.add(duration);
            // if pass the last day, remove courses these take longest time.
            if(time > lastDay) {
                time -= heap.poll();
            }
        }
        return heap.size();
	}
}