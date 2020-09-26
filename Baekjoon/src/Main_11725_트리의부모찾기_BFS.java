import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기_BFS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (list[r] == null)
				list[r] = new ArrayList<Integer>();
			if (list[c] == null)
				list[c] = new ArrayList<Integer>();

			list[r].add(c);
			list[c].add(r);
		}
		int[] parents = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.add(1);
		while (!queue.isEmpty()) {
			int root = queue.poll();
			List<Integer> parent = list[root];

			for (int i = 0; i < parent.size(); i++) {
				int child = parent.get(i);
				if (parents[child] == 0) {
					queue.add(child);
					parents[child] = root;
				}
			}

		}
		for (int j = 2; j <= N; j++) {
			System.out.println(parents[j]);
		}
	}
}
