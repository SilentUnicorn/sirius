package my.java;

import java.util.*;

/**
 * @author zhangjingsi
 * @date 2019/1/21下午5:10
 */
public class MyHashSet<E> extends AbstractSet<E> implements Set<E> {

    private HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        this.map = new HashMap<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean add(E e) {
        /** HashMap 的性质：增加新 key 返回 null，覆盖原有的 key 返回原有的 value */
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        /** HashMap 的性质：存在此 key 返回对应的 value，不存在则返回 null*/
        return map.remove(o) == PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }
}
