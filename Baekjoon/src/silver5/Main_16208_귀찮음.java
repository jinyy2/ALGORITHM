package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16208_귀찮음 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Long> a = new ArrayList<>();

        long sum = 0;
        long result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Long.parseLong(st.nextToken()));
            sum += a.get(i);
        }
        Collections.reverse(a);
        for (int i = 0; i < a.size() - 1; i++) {
            long x = a.get(i);
            sum -= a.get(i);
            long y = sum;

            result += x * y;
        }
        System.out.println(result);
    }
}
