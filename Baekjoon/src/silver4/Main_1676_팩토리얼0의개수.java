package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[501];
        int twoCount = 0;
        int fiveCount = 0;
        for (int i = 1; i <= N; i++) {
            int number = i;
            while (number % 2 == 0) {
                number /= 2;
                twoCount++;
            }
            while (number % 5 == 0) {
                number /= 5;
                fiveCount++;
            }
        }

        System.out.println(Math.min(twoCount, fiveCount));
    }
}
