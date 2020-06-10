package arithmetic;

public class SuperEggDrop {
    public static void main(String[] args) {
        int k = 2;
        int n = 6;
        int[] floor;
        int result = 0;
        for (int i = 0; i <= n; i++){
            floor = new int[n];
            for(int j = 0; j < i; j++){
                floor[j] = 0;
            }
            for(int j = i; j < n; j++){
                floor[j] = 1;
            }
            int temp = findRight(floor, 0, k);
            result = temp > result ? temp : result;
        }
        System.out.println(result);
    }

    public static int findRight(int[] floor ,int target, int k){
        int start = 0;
        int end = floor.length - 1;
        int count = 0;
        while(start < end){
            count ++;
            int mid = (start + end)/2 + 1;
            if (floor[mid] <= target){
                start = mid;
            }else{
                k--;
                end = mid - 1;
            }
        }
        //count++;
        if (floor[end] == target){
            if (k < 0){
                System.out.println(k);
            }
            return count;
            //return end;
        }else{
            return 0;
        }
    }
}
