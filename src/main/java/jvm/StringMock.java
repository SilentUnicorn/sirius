package jvm;

/**
 * @author zhangjingsi
 * @date 2018/5/2下午3:45
 */
public class StringMock {
    private Integer age;
    public static void main(String[] args) {
        StringMock stringMock = new StringMock();
        String s = new String("s");
        stringMock.setAge(1);
        StringMock.test1(s, stringMock);
    }

    public static void test1(String s, StringMock stringMock){
        System.out.println(s+":"+stringMock.toString());
        s = s +"s";
        stringMock.setAge(2);
        StringMock.test2(s, stringMock);
    }
    public static void test2(String s, StringMock stringMock){
        System.out.println(s+":"+stringMock.toString());
    }




    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StringMock{" +
                "age=" + age +
                '}';
    }
}
