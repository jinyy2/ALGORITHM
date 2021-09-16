package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14467_소가길을건너간이유1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cows = new int[11];
        Arrays.fill(cows, -1);
        StringTokenizer st = null;
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            if (cows[cow] == -1) {
                cows[cow] = location;
            } else if (cows[cow] == location) {
                continue;
            } else {
                count++;
                cows[cow] = location;
            }
        }
        System.out.println(count);
    }
}
