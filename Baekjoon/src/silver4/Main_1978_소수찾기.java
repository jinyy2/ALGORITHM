package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            int num = Integer.parseInt(st.nextToken());
            if (num < 2) continue;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) ++cnt;
        }
        System.out.println(cnt);

    }
}
