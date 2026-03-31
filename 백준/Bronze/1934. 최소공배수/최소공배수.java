import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int getGcd(int a, int b) {
        if (b == 0) return a;

        return getGcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int gcd = getGcd(a, b);
            int lcm = (a * b) / gcd;

            sb.append(lcm).append('\n');
        }

        System.out.println(sb);
    }
}