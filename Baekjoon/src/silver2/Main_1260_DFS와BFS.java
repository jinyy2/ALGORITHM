package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260_DFS와BFS {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] checked;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(list.get(i));
        }
        StringBuilder sb = new StringBuilder();
        checked = new boolean[N + 1];
        checked[V] = true;
        dfs(sb, V);
        System.out.println(sb.toString());
        bfs();
    }

    public static void dfs(StringBuilder sb, int v) {
        sb.append(v).append(" ");

        for (int i = 0; i < list.get(v).size(); i++) {
            int num = list.get(v).get(i);
            if (checked[num]) continue;
            checked[num] = true;
            dfs(sb, num);
        }
    }

    public static void bfs() {
        StringBuilder sb = new StringBuilder();
        checked = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        checked[V] = true;
        queue.offer(V);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");
            for (int i = 0; i < list.get(v).size(); i++) {
                int num = list.get(v).get(i);
                if (checked[num]) continue;
                checked[num] = true;
                queue.offer(num);
            }
        }
        System.out.println(sb.toString());
    }
}
