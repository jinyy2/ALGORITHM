package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593_상범빌딩 {
    static int L, R, C;
    static int[] dl = {0, 0, 0, 0, -1, 1}; //동서남북상하
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};

    static class Node {
        int l;
        int r;
        int c;

        public Node(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) break; // 입력의 끝은 L, R, C가 모두 0으로 표현된다.
            int sl = 0, sr = 0, sc = 0;
            int el = 0, er = 0, ec = 0;
            char[][][] map = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    map[l][r] = br.readLine().toCharArray();
                    for (int c = 0; c < C; c++) {
                        if (map[l][r][c] == 'S') {
                            sl = l;
                            sr = r;
                            sc = c;
                        } else if (map[l][r][c] == 'E') {
                            el = l;
                            er = r;
                            ec = c;
                        }
                    }
                }
                br.readLine();
            }
            Queue<Node> queue = new LinkedList<>();
            visited[sl][sr][sc] = true; //시작점 방문
            queue.offer(new Node(sl, sr, sc));
            int cnt = 0;
            boolean trap = true;
            loop:
            while (!queue.isEmpty()) {
                int qSize = queue.size();
                cnt++;
                for (int i = 0; i < qSize; i++) {
                    Node node = queue.poll();
                    for (int d = 0; d < 6; d++) {
                        int nl = node.l + dl[d];
                        int nr = node.r + dr[d];
                        int nc = node.c + dc[d];
                        if (!safe(nl, nr, nc)) continue;
                        if (map[nl][nr][nc] == '#') continue;
                        if (visited[nl][nr][nc]) continue;
                        if (nl == el && nr == er && nc == ec) {
                            sb.append("Escaped in " + cnt + " minute(s).\n");
                            trap = false;
                            break loop;
                        }
                        if (map[nl][nr][nc] == '.') {
                            visited[nl][nr][nc] = true;
                            queue.offer(new Node(nl, nr, nc));
                        }
                    }

                }
            }
            if (trap) sb.append("Trapped!\n");
        }
        System.out.println(sb.toString());
        "Stirn".charAt(1);
    }

    private static boolean safe(int nl, int nr, int nc) {
        return 0 <= nl && nl < L && 0 <= nr && nr < R && 0 <= nc && nc < C;
    }
}
