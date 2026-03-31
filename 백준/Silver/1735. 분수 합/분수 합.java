import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long getGcd(long a, long b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = reader.readLine().split(" ");
        int a1 = Integer.parseInt(input1[0]);
        int b1 = Integer.parseInt(input1[1]);

        String[] input2 = reader.readLine().split(" ");
        int a2 = Integer.parseInt(input2[0]);
        int b2 = Integer.parseInt(input2[1]);

        long resultB = (b1 * b2) / getGcd(b1, b2);

        long resultA = (resultB / b1 * a1) + (resultB / b2 * a2);

        long gcd = getGcd(resultA, resultB);

        System.out.println((resultA / gcd) + " " + (resultB / gcd));
    }
}