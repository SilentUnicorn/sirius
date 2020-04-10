package arithmetic;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1 ,2 ,3 ,4 ,5 ,6};
        int target = 3;
        if (arr.length <=0 || target < arr[0] || target > arr[arr.length-1]){
            return;
        }
        findLeft(arr, target);
        findRight(arr, target);
        find(arr, target);
    }

    public static void findLeft(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        //left
        while(left < right){
            int mid = (left + right)/2;
            if (arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if (arr[left] == target){
            System.out.println("left:" + left);
        }else{
            System.out.println("not found left");
        }
    }

    public static void findRight(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        //right
        while(left < right - 1){
            int mid = (left + right)/2;
            if (arr[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        if (arr[right] == target){
            System.out.println("right:" + right);
        }else{
            System.out.println("not found right");
        }
    }

    public static void find(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            int mid = (left + right)/2;
            if (arr[mid] == target){
                System.out.println(mid);
                return;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
    }
}
