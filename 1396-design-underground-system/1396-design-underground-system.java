class UndergroundSystem {
    // ID mapped to start name and time difference
    HashMap<Integer, Pair<String, Integer>> check_in = new HashMap<>();
    
    // lets map a start location to another map of end locations which will have a value that will be an array to keep track of count and sum
	
	// Ex:    {  "WaterLoo":  { "Cambridge": [1, 20], "Britain": [3, 45] }  } 
	
    HashMap<String, HashMap<String, int[]>> time_differences = new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    // lets first keep track of id -> name, time
    public void checkIn(int id, String stationName, int t) {
        check_in.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String end, int t) {
        // find the start location and the start time
        Pair<String, Integer> start = check_in.get(id);
        
        // initalize map for starting locations
        time_differences.putIfAbsent(start.getKey(), new HashMap<>());
        
        // initialize start location map with an entry for this current end location
        time_differences.get(start.getKey()).putIfAbsent(end, new int[2]);
        
        // first array indice will simply count trips
        time_differences.get(start.getKey()).get(end)[0]++;
        
        // count the time
        time_differences.get(start.getKey()).get(end)[1] += (t - start.getValue());
        
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        // find ALL entries for corresponding start location
        HashMap<String, int[]> trips = time_differences.get(startStation);
        
        // find data points for specific end location
        int[] arr = trips.get(endStation);
        
        // pretty simple, sum over count
        return (double) arr[1] / arr[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */