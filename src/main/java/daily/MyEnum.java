package daily;

import java.util.Random;

/**
 * @author zhangjingsi
 * @date 2018/8/7上午11:06
 */
public enum MyEnum {
    SUCCESS("success", 1),
    FAIL("fail", 2);

    private String name1;
    private Integer code;

    MyEnum(String name1, Integer code) {
        this.name1 = name1;
        this.code = code;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static void main(String[] args) {
        System.out.println(MyEnum.SUCCESS.name());
        for (int i = 0; i < 10; i++){
            System.out.println(new Random().nextInt(3));
        }
    }
}
