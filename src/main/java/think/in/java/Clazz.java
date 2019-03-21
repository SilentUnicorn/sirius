package think.in.java;

/**
 * @author zhangjingsi
 * @date 2019/3/11下午6:23
 */
public class Clazz {
    private String name = "cc1";

    static {
        System.out.println("static");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("main");

        String s1 = "think.in.java.Clazz";
        Class<?> aClass = Class.forName(s1);
        Clazz c1 = (Clazz)aClass.newInstance();
        System.out.println(c1.name);
        System.out.println(aClass.getName());
        //Uuid.main(new String[]{});

        Thread.yield();
    }
}
