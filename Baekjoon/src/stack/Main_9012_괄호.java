package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			String flag = "YES";
			for (int j = 0; j < str.length(); j++) {
				if (stack.isEmpty()) {
					if (str.charAt(j) == ')') {
						flag = "NO";
						break;
					}
					stack.push(str.charAt(j));
				} else {
					if (str.charAt(j) == '(')
						stack.push(str.charAt(j));
					else {
						stack.pop();
					}
				}
			}
			if (!stack.isEmpty())
				flag = "NO";

			System.out.println(flag);
		}

	}

}