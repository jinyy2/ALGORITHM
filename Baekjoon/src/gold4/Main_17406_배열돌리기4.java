package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
    static int[][] map;
    static List<Node> list;
    static boolean[] checked;
    static int[] num;
    static int min;

    static class Node {
        int r;
        int c;
        int s;

        public Node(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();
        checked = new boolean[K];
        num = new int[K];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new Node(r, c, s));
        }
        permutation(K, 0);
        System.out.println(min);

    }

    private static void permutation(int k, int cnt) {
        if (cnt == k) {
            int[][] copyMap = new int[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < k; i++) {
                copyMap = rotate(copyMap, list.get(num[i]));
            }
            for (int[] minArray : copyMap) {
                int sum = 0;
                for (int value : minArray) {
                    sum += value;
                }
                min = Math.min(min, sum);
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (checked[i]) continue;
            checked[i] = true;
            num[cnt] = i;
            permutation(k, cnt + 1);
            checked[i] = false;
        }

    }

    public static int[][] rotate(int[][] copyMap, Node node) {
        int r = node.r - 1;
        int c = node.c - 1;
        int s = node.s;

        for (int k = 1; k <= s; k++) {
            int temp = copyMap[r - k][c + k];
            for (int i = c + k; i > c - k; i--) {
                copyMap[r - k][i] = copyMap[r - k][i - 1];
            }
            for (int i = r - k; i < r + k; i++) {
                copyMap[i][c - k] = copyMap[i + 1][c - k];
            }
            for (int i = c - k; i < c + k; i++) {
                copyMap[r + k][i] = copyMap[r + k][i + 1];
            }
            for (int i = r + k; i > r - k; i--) {
                copyMap[i][c + k] = copyMap[i - 1][c + k];
            }
            copyMap[r - k + 1][c + k] = temp;
        }
        return copyMap;
    }
}
