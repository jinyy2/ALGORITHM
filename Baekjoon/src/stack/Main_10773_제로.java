package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n != 0) {
				stack.push(n);
				sum += n;
			} else {
				if (stack.isEmpty())
					continue;
				sum -= stack.pop();
			}
		}
		System.out.println(sum);
	}

}
