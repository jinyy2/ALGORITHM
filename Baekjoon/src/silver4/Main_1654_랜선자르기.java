package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Long[] arr = new Long[N];
        long end = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            end = Math.max(end, arr[i]);
        }
        long result = binarySearch(arr, end, K);
        System.out.println(result);
    }

    private static long binarySearch(Long[] arr, long end, int key) {
        long start = 1;
        while (start <= end) {
            int cnt = 0;
            long mid = (start + end) / 2;
            for (int i = 0; i < arr.length; i++) {
                cnt += arr[i] / mid;
            }
            if (key <= cnt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
