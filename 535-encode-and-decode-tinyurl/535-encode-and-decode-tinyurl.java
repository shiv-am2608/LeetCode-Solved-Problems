public class Codec {

    // Encodes a URL to a shortened URL.
    HashMap<Long,String>hmap=new HashMap<Long,String>();
    long id = 1;
    public String encode(String longUrl) {
        hmap.put(id++,longUrl);
        return String.valueOf(id-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hmap.get(Long.parseLong(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));