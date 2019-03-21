package sort;

/**
 * @author zhangjingsi
 * @date 2019/3/18下午5:54
 */
public class BubbleSort {
    public static void sort(int[] array){
        /**遍历第 i 次，每遍历一次都会向数组尾部的有序队列增加一个元素*
         * 最差时间复杂度(数组长度n)： 等差数列之和 (n-2)+(n-3)+(n-4).....+1 = ((n-2)+1)n/2 = n^2/2-n/2=O(n^2)
         * n=20 时 循环 190 次
         * 最好时间复杂度：遍历一次发现无交换，也就是所有元素有序，外层循环走 n-1 次即可,所以 O(n)
         */
        int temp;
        int count = 0;
        boolean flag;
        for(int i = 0; i <= array.length - 2; i++ ){
            flag = true;
            for(int j = 0; j <= array.length - 2 - i; j++){
                count++;
                if (array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println("count" + count);
    }
}
