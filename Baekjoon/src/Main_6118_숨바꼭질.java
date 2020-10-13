import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6118_숨바꼭질 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> maxDistance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		maxDistance = new ArrayList<>();
		visited = new boolean[N + 1];
		
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A_i = Integer.parseInt(st.nextToken());
			int B_i = Integer.parseInt(st.nextToken());
			list[A_i].add(B_i);
			list[B_i].add(A_i);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		visited[1] = true;
		queue.add(1);
		int depth = 0;

		while (!queue.isEmpty()) {
			maxDistance.clear();
			depth++;
			int qSize = queue.size();
			
			for (int i = 0; i < qSize; i++) {
				int temp = queue.poll();
				maxDistance.add(temp);
				
				for (int j = 0; j < list[temp].size(); j++) {
					if (!visited[list[temp].get(j)]) {
						visited[list[temp].get(j)] = true;
						queue.add(list[temp].get(j));

					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < maxDistance.size(); i++) {
			min = Math.min(min, maxDistance.get(i));
		}
		System.out.println(min + " " + (depth - 1) + " " + maxDistance.size());

	}

}
