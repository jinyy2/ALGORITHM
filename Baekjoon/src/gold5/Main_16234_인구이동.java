package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
    static int N, L, R;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> queue;
    static List<Node> list;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (true) {
            if (check())
                answer++;
            else break;

        }
        System.out.println(answer);

    }

    private static boolean check() {
        visited = new boolean[N][N];
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                queue = new LinkedList<>();
                list = new LinkedList<>();
                queue.offer(new Node(i, j));
                list.add(new Node(i, j));
                int sum = map[i][j];
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = node.r + dr[d];
                        int nc = node.c + dc[d];
                        if (!safe(nr, nc)) continue;
                        if (visited[nr][nc]) continue;
                        int abs = Math.abs(map[node.r][node.c] - map[nr][nc]);
                        if (L <= abs && abs <= R) {
                            visited[nr][nc] = true;
                            sum += map[nr][nc];
                            list.add(new Node(nr, nc));
                            queue.offer(new Node(nr, nc));
                        }
                    }
                }
                if (list.size() > 1) {
                    int avg = sum / list.size();
                    for (Node node : list) {
                        map[node.r][node.c] = avg;
                    }
                    flag = true;
                }


            }
        }
        return flag;
    }

    private static boolean safe(int nr, int nc) {
        return 0 <= nr && 0 <= nc && nr < N && nc < N;
    }
}
