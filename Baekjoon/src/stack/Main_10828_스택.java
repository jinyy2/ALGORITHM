package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			if (str.length == 2 && str[0].equals("push")) {
				stack.push(Integer.parseInt(str[1]));
			} else {
				if (str[0].equals("top")) {
					if (!stack.isEmpty())
						System.out.println(stack.peek());
					else
						System.out.println(-1);
				} else if (str[0].equals("size")) {
					System.out.println(stack.size());
				} else if (str[0].equals("empty")) {
					if (stack.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);

				} else {
					if (!stack.isEmpty())
						System.out.println(stack.pop());
					else
						System.out.println("-1");
				}
			}
		}
	}

}
