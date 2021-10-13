package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17103_골드바흐파티션 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        boolean[] num = new boolean[1000001];
        num[0] = true;
        num[1] = true;
        for (int i = 2; i <= Math.sqrt(num.length); i++) {
            if (num[i]) continue;
            for (int j = i + i; j < num.length; j += i) {
                num[j] = true;
            }
        }

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 2; i <= N / 2; i++) {
                if (!num[i] && !num[N - i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
