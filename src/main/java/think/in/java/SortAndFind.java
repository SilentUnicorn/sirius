package think.in.java;

import com.google.gson.Gson;
import sort.BubbleSort;

/**
 * @author zhangjingsi
 * @date 2019/3/18下午5:44
 */
public class SortAndFind {

    public static void main(String[] args) {
        int[] i1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int[] i2 = new int[20];
        for(int i = 20; i > 0; i--){
            i2[20 - i] = i;
        }
        System.out.println("sort before:" + new Gson().toJson(i2));
        BubbleSort.sort(i2);
        System.out.println("sort before:" + new Gson().toJson(i2));
        BubbleSort.sort(i1);
        System.out.println(new Gson().toJson(i1));

    }
}
