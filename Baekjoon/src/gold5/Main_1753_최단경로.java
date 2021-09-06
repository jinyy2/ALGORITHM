package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753_최단경로 {
    static int V, E, K;
    static ArrayList<List<Node>> list;
    static int[] dist;


    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    private static final int INF = 100000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i < V + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        }
        dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.print(sb.toString());
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int end = node.end;
            int weight = node.weight;
            if (dist[end] < weight) continue;
            for (int i = 0; i < list.get(end).size(); i++) {
                int cost = dist[end] + list.get(end).get(i).weight;
                if (cost < dist[list.get(end).get(i).end]) {
                    dist[list.get(end).get(i).end] = cost;
                    pq.offer(new Node(list.get(end).get(i).end, cost));
                }
            }
        }
    }
}
