package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] num = new boolean[1000001];
        num[0] = true;
        num[1] = true;
        for (int i = 2; i <= Math.sqrt(num.length); i++) {
            if (num[i]) continue;
            for (int j = i + i; j <= end; j += i) {
                num[j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (!num[i]) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());

    }
}
