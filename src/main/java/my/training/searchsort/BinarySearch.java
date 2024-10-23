package my.training.searchsort;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] == target) {
                return mid;
            }

            if(arr[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 5;

        int result = binarySearch(arr, target);

        printResult(target, result);
    }

    private static void printResult(int target, int result) {
        if (result != -1) {
            System.out.println("타겟 " + target + "은 인덱스 " + result + "에 있습니다.");
        } else {
            System.out.println("타겟 " + target + "은 배열에 없습니다.");
        }
    }
}
