import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static void checkPrime(boolean[] arr, int end) {
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (arr[i]) {
                for (int j = i * i; j <= end; j += i) {
                    arr[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = reader.readLine().split(" ");

        int start = Integer.parseInt(input[0].trim());
        int end = Integer.parseInt(input[1].trim());

        boolean[] arr = new boolean[end + 1];
        Arrays.fill(arr, true);

        arr[0] = false;
        arr[1] = false;

        checkPrime(arr, end);

        for (int i = start; i <= end; i++) {
            if (arr[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}