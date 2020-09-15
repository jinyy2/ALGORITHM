import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568_덩치 {
	static class Volumn {
		int w;
		int h;
		int rank;

		public Volumn(int w, int h, int rank) {
			this.w = w;
			this.h = h;
			this.rank = rank;
		}

		@Override
		public String toString() {
			return "Volumn [w=" + w + ", h=" + h + ", rank=" + rank + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		Volumn[] v = new Volumn[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			v[i] = new Volumn(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (v[i].w > v[j].w && v[i].h > v[j].h) {
					v[j].rank++;
				} else if (v[i].w < v[j].w && v[i].h < v[j].h) {
					v[i].rank++;
				}
			}
		}
		
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i].rank + " ");
		}
	}
}
