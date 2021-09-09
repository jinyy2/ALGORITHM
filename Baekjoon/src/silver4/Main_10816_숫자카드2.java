package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Arrays.binarySearch;


public class Main_10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            int left = binarySearchLeft(arr, key);
            int right = binarySearchRight(arr, key);
            sb.append(right - left).append(" ");
        }
        System.out.print(sb.toString());
    }

    private static int binarySearchLeft(int[] arr, int key) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (key <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static int binarySearchRight(int[] arr, int key) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}

