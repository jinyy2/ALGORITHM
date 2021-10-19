package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2670_연속부분최대곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] num = new double[N];
        double max = Double.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            num[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            double sum = 1;
            for (int j = i; j < N; j++) {
                sum *= num[j];
                max = Math.max(max, sum);
            }

        }
        System.out.printf("%.3f", max);
    }
}
