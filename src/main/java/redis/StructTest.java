package redis;

import com.google.gson.Gson;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author zhangjingsi
 * @date 2018/12/29下午5:55
 */
public class StructTest {
    public static void main(String[] args) {
        /**有序不重复*/
        Set<String> s = new HashSet<>();
        s.add("c");
        s.add("b");
        s.add("4");
        s.add("2");
        s.add("3");
        System.out.println(new Gson().toJson(s));

        Vector<String> v = new Vector<>();
        v.add("b");
        v.add("a");
        v.add("c");
        System.out.println(new Gson().toJson(v));
        List<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.remove(1);
        Collection<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        Collection<Integer> vector = new Vector<>();

        Collection<Integer> set = new HashSet();
    }
}
