import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Hashmap<V> implements Hash<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    private final ArrayList<LinkedList<Pair<V>>> buckets;

    private static class Pair<V> {
        final String k;
        V v;

        Pair(String k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public Hashmap() {
        this.buckets = new ArrayList<>(Collections.nCopies(TABLE_SIZE, null));
    }

    private long hashByString(String value) {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
        int pos = (int) hashByString(key);
        LinkedList<Pair<V>> chain = buckets.get(pos);

        if (chain == null) {
            chain = new LinkedList<>();
            buckets.set(pos, chain);
        }

        for (Pair<V> item : chain) {
            if (item.k.equals(key)) {
                item.v = value;
                return;
            }
        }

        chain.addLast(new Pair<>(key, value));
    }

    @Override
    public V getValue(String key) {
        int pos = (int) hashByString(key);
        LinkedList<Pair<V>> chain = buckets.get(pos);

        if (chain != null) {
            for (Pair<V> item : chain) {
                if (item.k.equals(key)) {
                    return item.v;
                }
            }
        }

        return null;
    }

    @Override
    public V delete(String key) {
        int pos = (int) hashByString(key);
        LinkedList<Pair<V>> chain = buckets.get(pos);

        if (chain == null) {
            return null;
        }

        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).k.equals(key)) {
                return chain.remove(i).v;
            }
        }

        return null;
    }
}
