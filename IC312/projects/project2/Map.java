import java.util.List;

/**
 * Map for holding a group of Key-Value Pairs; can search by Key.
 * No Key may appear more than once.
 */
public interface Map<K,V> {

  /** Return the value associated with the key */
  public V get(K key);

  /** Insert a key-value pair into the Map */
  public void insert(K key, V value);

  /** Return the number of key-value pairs in the Map */
  public int size();

  /** Return the keys as a List; no order is guaranteed */
  public List<K> keys();

  /** Return the values as a List; no order is guaranteed */
  public List<V> values();
}
