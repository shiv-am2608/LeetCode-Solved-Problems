// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.
    private static LinkedHashMap<Integer, Integer> map;
    private static int size;
    
    LRUCache(int cap) {
        //code here
        size = 0;
        map = new LinkedHashMap<>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cap;
            }
        };
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        // your code here
        int ans = map.getOrDefault(key, -1);
        if (ans != -1) {
            map.remove(key);
            set(key, ans);
        }
        return ans;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        // your code here
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
    }
}
