import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void quickSort(String[] arr, int left, int right) {
        if (left >= right) return;

        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);
    }

    static int partition(String[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        String pivot = arr[mid];

        while (left <= right) {
            while (arr[left].compareTo(pivot) < 0) left++;
            while(arr[right].compareTo(pivot) > 0) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String target = reader.readLine();

        int arraySize = (target.length() * (target.length() + 1)) / 2;
        int k = 0;

        String[] substr = new String[arraySize];

        for (int i = 0; i < target.length(); i++) {
            for (int j = i + 1; j < target.length() + 1; j++) {
                substr[k++] = target.substring(i, j);
            }
        }

        quickSort(substr, 0, k - 1);

        int count = (k > 0) ? 1 : 0;

        for (int i = 1; i < k; i++) {
            if (!substr[i].equals(substr[i - 1])) {
                count++;
            }
        }

        System.out.println(count);
    }
}
