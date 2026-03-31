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

        String[] input = reader.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);

        long gcd = getGcd(a, b);
        long lcm = (a * b) / gcd;

        System.out.println(lcm);
    }
}
