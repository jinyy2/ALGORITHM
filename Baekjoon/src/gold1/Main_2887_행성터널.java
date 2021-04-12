package gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2887_행성터널 {

	static class Planet {
		int idx;
		int x;
		int y;
		int z;

		public Planet(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	static class Node {
		int s;
		int e;
		int c;

		public Node(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}
	}

	static int[] parent;
	static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Planet[] planet = new Planet[N];
		parent = new int[N + 1];
		rank = new int[N + 1];
		long answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planet[i] = new Planet(i, x, y, z);
		}
		ArrayList<Node> list = new ArrayList<Node>();
		Arrays.sort(planet, (o1, o2) -> o1.x - o2.x);
		for (int i = 0; i < N - 1; i++) {
			list.add(new Node(planet[i].idx, planet[i + 1].idx, Math.abs(planet[i].x - planet[i + 1].x)));
		}
		Arrays.sort(planet, (o1, o2) -> o1.y - o2.y);
		for (int i = 0; i < N - 1; i++) {
			list.add(new Node(planet[i].idx, planet[i + 1].idx, Math.abs(planet[i].y - planet[i + 1].y)));
		}
		Arrays.sort(planet, (o1, o2) -> o1.z - o2.z);
		for (int i = 0; i < N - 1; i++) {
			list.add(new Node(planet[i].idx, planet[i + 1].idx, Math.abs(planet[i].z - planet[i + 1].z)));
		}

		// sort
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node n1, Node n2) {
				return Long.compare(n1.c, n2.c);
			}

		});

		for (int i = 0; i < parent.length; i++) {
			makeSet(i);
		}
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			int a = findSet(node.s);
			int b = findSet(node.e);
			if (a == b)
				continue;
			union(a, b);
			cnt++;
			answer += node.c;
			if (N - 1 == cnt)
				break;
		}
		System.out.println(answer);
	}

	private static void makeSet(int x) {
		parent[x] = x;
	}

	private static int findSet(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = findSet(parent[x]);
	}

	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parent[py] = px;
		} else {
			parent[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}

}