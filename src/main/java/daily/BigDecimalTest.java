package daily;

import java.math.BigDecimal;

public class BigDecimalTest {


    public static void main(String[] args) {

        Double d = 8.7;
        Double d1 = Double.parseDouble(d.toString());
        Double d2 = d1*100;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(Integer.valueOf(d2.intValue()));


        BigDecimal b = new BigDecimal(d.toString());
        BigDecimal b2 = new BigDecimal(100);
        System.out.println(b.multiply(b2).intValue());

        BigDecimal b00 = BigDecimal.valueOf(d);
        System.out.println(b00);

        BigDecimal b0 = new BigDecimal(d);
        System.out.println(b0);

        System.out.println("最终：" + BigDecimal.valueOf(Double.parseDouble("8.7")).multiply(BigDecimal.valueOf(100)).intValue());


        for(int i = 1; i< 10; i++){
            System.out.println(i*1.2);
        }


        System.out.println("原渠道：" + BigDecimal.valueOf(Double.parseDouble("8.7")).multiply(BigDecimal.valueOf(100)).intValue());
        System.out.println("余额：" + BigDecimal.valueOf(Double.parseDouble("8.7")).multiply(BigDecimal.valueOf(100)).intValue());
        System.out.println(BigDecimal.valueOf(Double.parseDouble("8.7")).multiply(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(0.6)).intValue());
    }
}
