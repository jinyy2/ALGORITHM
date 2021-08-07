package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결 {

	static int[] p, rank;

	static class Node {
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Node[] edges = new Node[M];
		p = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Node(s, e, c);
		}
		Arrays.sort(edges, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return Integer.compare(n1.cost, n2.cost);
			}
		});

		for (int i = 0; i < p.length; i++) {
			makeSet(i);
		}
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < edges.length; i++) {
			Node node = edges[i];
			int a = findSet(node.start);
			int b = findSet(node.end);
			if (a == b)
				continue;
			union(a, b);
			cnt++;
			result += node.cost;
			if (cnt == N - 1)
				break;
		}
		System.out.println(result);

	}

	private static void makeSet(int x) {
		p[x] = x;
	}

	private static int findSet(int x) {
		if (p[x] == x) {
			return x;
		} else {
			p[x] = findSet(p[x]);
			return p[x];
		}

	}

	private static void union(int a, int b) {
		int px = findSet(a);
		int py = findSet(b);
		if (rank[px] > rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}

}
