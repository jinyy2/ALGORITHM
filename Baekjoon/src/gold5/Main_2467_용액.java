package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = N - 1;
        long sum = 0;
        long max = Long.MAX_VALUE;
        int answerL = s;
        int answerR = e;
        while (s < e) {
            sum = arr[s] + arr[e];
            if (Math.abs(sum) < max) {
                max = Math.abs(sum);
                answerL = arr[s];
                answerR = arr[e];
            }
            if (sum < 0) s++;
            else e--;

        }
        System.out.println(answerL + " " + answerR);
    }
}
