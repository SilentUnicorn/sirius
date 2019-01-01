package daily;

/**
 * @author zhangjingsi
 * @date 2018/8/7上午10:58
 */
public class Enu {
    public static Enu enu1 = new Enu("1", 1);
    public static Enu enu2 = new Enu("2", 2);


    private String name;
    private Integer code;

    public Enu(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(Enu.enu1);
    }
}
