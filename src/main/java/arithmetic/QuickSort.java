package arithmetic;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {10,5,4,7,8,9,21,34,20,1,2,3,6,11};
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int start, int end){
        if (array.length <= 0 || start >= end){
            return;
        }
        int i = start;
        int j = end;
        int temp = array[start];
        while(i < j){
            while(i < j && array[j] >= temp){
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= temp) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = temp;
        sort(array, start, i-1);
        sort(array, i+1, end);
    }
}
