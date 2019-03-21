package my.java;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author zhangjingsi
 * @date 2019/1/23上午11:13
 */
public class MyHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

    /**桶*/
    Node<K, V>[] table;

    /**已存在 k-v 数量*/
    int size;

    /**桶默认大小*/
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**最大容量*/
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**默认负载因子*/
    static final float DEFAULT_LOAD_FACTOR = .75f;

    /**负载因子*/
    final float loadFactor;

    /**扩容临界值*/
    int threshold;


    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    @Override
    public V put(K key, V value) {
        if (Objects.isNull(table) || table.length == 0){
            resize();
        }
        return super.put(key, value);
    }

    final Node<K, V>[] resize(){
        Node<K, V>[] oldTab = table;
        int oldCap = table.length;
        int oldThr = threshold;
        int newCap,newThr;
        if (Objects.isNull(table) || table.length <= 0){
            newCap = DEFAULT_INITIAL_CAPACITY;
        }else{
            newCap = oldCap << 1;
        }
        return null;
    }


    @Override
    public V get(Object o){

        return null;
    }

    @Override
    public V remove(Object key) {
        return super.remove(key);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    static class Node<K, V> implements Map.Entry<K, V>{

        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Map.Entry){
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(e.getKey(), this.key) && Objects.equals(this.getValue(), this.value)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key) ^ Objects.hashCode(value);
        }
    }
}
