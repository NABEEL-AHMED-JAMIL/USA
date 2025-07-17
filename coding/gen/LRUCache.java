package coding.gen;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * V.V IMP Question For Interview
 * */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int cap;

    public LRUCache(int cap) {
        // import point
        super(cap, 0.75f, true);
        this.cap = cap;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cap;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.get(1); // Access key 1
        cache.put(4, "Four"); // Evicts key 2 (least recently used)
        System.out.println(cache); // Output: {3=Three, 1=One, 4=Four}
    }

}
