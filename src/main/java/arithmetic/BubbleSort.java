package arithmetic;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {10,5,4,7,8,9,21,34,20,1,2,3,6,11};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array){
        if (array.length <= 0){
            return;
        }
        int temp;
        for (int j = 0; j < array.length; j ++){
            //第 j 次，后 j 个数字已经有序，不参与冒泡
            for (int i = 0; i < array.length-1-j; i ++){
                if (array[i] > array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }
}
