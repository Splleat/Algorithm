import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);
    }

    static int partition(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = arr[mid];

        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(" ");

        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);

        String[] input1 = reader.readLine().split(" ");
        String[] input2 = reader.readLine().split(" ");

        int[] given1 = Arrays.stream(input1)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] given2 = Arrays.stream(input2)
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(given1, 0, n - 1);

        int intersectionCount = 0;

        for (int i = 0; i < m; i++) {
            if (binarySearch(given1, given2[i])) {
                intersectionCount++;
            }
        }

        int result = n + m - intersectionCount * 2;

        System.out.println(result);
    }
}
