package lambda;

/**
 * @author zhangjingsi
 * @date 2018/3/6下午7:59
 */
public class Apple {
    private String name;
    private Integer weigh;

    public Apple(String name, Integer weigh) {
        this.name = name;
        this.weigh = weigh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeigh() {
        return weigh;
    }

    public void setWeigh(Integer weigh) {
        this.weigh = weigh;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weigh=" + weigh +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(Math.random()*9+1);
        System.out.println((int)((Math.random())*9000+1000));
    }
}
