class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if (o1[0] != o2[0]) // diff height, compare order
                    return o2[0] - o1[0]; // higher first  
                else
                    return o1[1] - o2[1]; // smaller order first
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++)
            list.add(people[i][1], people[i]);
        return list.toArray(people);
    }
}