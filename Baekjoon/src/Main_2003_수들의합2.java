import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//슬라이딩 윈도우 알고리즘
public class Main_2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} //input-end
		
		int sum = 0;
		int start = 0;
		int end = 0;
		int count = 0;
		while(true) {
			System.out.println(start +" " + end +" "+count);			
			if(sum >=M) {
				sum-=arr[start++];
			} else if(end == N)  {
				break;
			} else if (sum < M) {
				sum += arr[end++];
			}
			if(sum==M)count++;

			
		}
		System.out.println(count);

	}

}
