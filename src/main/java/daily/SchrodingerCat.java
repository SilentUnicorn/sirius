package daily;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author zhangjingsi
 * @date 2018/8/16上午9:49
 */
public class SchrodingerCat {

    public static void main(String[] args) {
        String [] cat1 = new String[]{"male", "female"};
        String [] cat2 = new String[]{"male", "female"};
        String [] cat3 = new String[]{"male", "female"};
        String [] cat4 = new String[]{"male", "female"};
        List<String[]> all = new ArrayList<>();
        while (all.size() < 16){
            String[] temp1 = new String[4];
            temp1[0] = cat1[new Random().nextInt(2)];
            temp1[1] = cat2[new Random().nextInt(2)];
            temp1[2] = cat3[new Random().nextInt(2)];
            temp1[3] = cat4[new Random().nextInt(2)];

            boolean flag = true;
            if (!CollectionUtils.isEmpty(all)){
                for(String[] s : all){
                    if (Arrays.asList(s).toString().equals(Arrays.asList(temp1).toString())){
                        flag = false;
                    }
                }
            }else{
                flag = true;
            }
            if (flag){
                all.add(temp1);
            }
        }

        all.forEach(a->System.out.println(Arrays.asList(a)));

        all.forEach(a->{
            List<String> f = new ArrayList<>();
            List<String> m = new ArrayList<>();
            Arrays.asList(a).forEach(aa->{
                if (aa.equals("female")){
                    f.add("female");
                }else if (aa.equals("male")){
                    m.add("male");
                }
            });

            System.out.println("f:"+f.size()+"---m:"+m.size());
        });
    }
}
