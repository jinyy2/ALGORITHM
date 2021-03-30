import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {

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

	static int[] p, rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		p = new int[V + 1];
		rank = new int[V + 1];
		Node[] edges = new Node[E];

		for (int i = 0; i < E; i++) {
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
		int result = 0;
		int cnt = 0;
		for (int i = 0; i < edges.length; i++) {
			Node node = edges[i];
			int a = findSet(node.start);
			int b = findSet(node.end);
			if (a == b)
				continue;
			union(a, b);
			cnt++;
			result += node.cost;
			if (cnt == V - 1) {
				break;
			}

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

	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;
			if (rank[py] == rank[px])
				rank[py]++;
		}
	}

}
