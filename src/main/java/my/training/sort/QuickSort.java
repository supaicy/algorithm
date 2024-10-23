package my.training.sort;

public class QuickSort {
    // 퀵 정렬 메소드
    public static void quickSort(int[] arr, int low, int high) {

        if(low < high) {
            // 피벗을 기준으로 배열을 나누고, 피벗의 인덱스를 가져옴
            int pi = partition(arr, low, high);

            // 피벗의 왼쪽과 오른쪽을 각각 재귀적으로 정렬
            quickSort(arr, low,  pi-1);
            quickSort(arr,pi+1, high);
        }
    }

    // 배열을 분할하는 메소드
    public static int partition(int[] arr, int low, int high) {
        // 마지막 요소를 피벗으로 설정
        int pivot = arr[high];
        // 작은 요소의 인덱스를 나타냄
        int i = low-1;

        for(int j = low; j < high; j++) {
            // 현재 요소가 피벗보다 작은 경우
            if(arr[j] < pivot) {
                i++;
                // 작은 요소와 현재 요소를 교체
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 피벗을 올바른 위치로 교체
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        // 피벗의 인덱스를 반환
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {9,7,2,4,3,1,2,1,4,7,8,11};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("정렬된 배열: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
