import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

//7 11
//0 1 2
//0 2 2
//0 5 8
//1 2 1
//1 3 19
//2 5 5
//3 4 7
//3 5 11
//3 6 15
//4 5 9
//4 6 3
public class Kruskal {
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		parents = new int[V];
		rank = new int[V];
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});

		for (int i = 0; i < parents.length; i++) {
			makeSet(i);
		}
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < edges.length; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if (a != b) {
				union(a, b);
				result += edges[i][2];
				System.out.println(edges[i][0] + " " + edges[i][1] + " " + edges[i][2]);
				cnt++;
				if (cnt == V - 1)
					break;
			}
		}
		System.out.println(result);

	}

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (rank[px] > rank[py])
			parents[py] = px;
		else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}

		}
	}
}
