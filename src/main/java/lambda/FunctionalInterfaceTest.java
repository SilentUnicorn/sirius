package lambda;

import java.util.Stack;

/**
 * @author zhangjingsi
 * @date 2018/3/28下午7:50
 */
@FunctionalInterface
public interface FunctionalInterfaceTest {
    String test(String str);
}

class FunctionalClass{
    public static void main(String[] args) {
        FunctionalInterfaceTest f = (String str) -> {
            char[] chars = str.toCharArray();
            Stack<Character> c = new Stack<>();
            for (int i = 0; i < chars.length; i++){
                c.push(chars[i]);
            }
            while (!c.empty()){
                str += c.pop();
            }
            return str;
        };
        System.out.println(f.test("123"));
    }
}